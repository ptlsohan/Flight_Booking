package controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.Seat;
import com.google.gson.Gson;

import dao.SeatDao;


@WebServlet("/fetchseats")
public class FetchSeats extends HttpServlet {
	 @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException, ServletException {
	        System.out.println("Fetch seat");
	        int id=Integer.parseInt(request.getParameter("id"));
	        System.out.println(id);
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	       Seat seat = null;
	       
	       
	      try {
			seat = SeatDao.getSeats(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(new Gson().toJson(seat));

	      
	        
	       
	        response.getWriter().write(new Gson().toJson(seat));
	 }
	
	

}

