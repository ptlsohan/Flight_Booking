package com.controller;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.bean.Seat;
import com.dao.SeatDao;
import com.exception.DBException;
import com.google.gson.Gson;


@WebServlet("/fetchseats")
public class FetchSeats extends HttpServlet {

	private static final long serialVersionUID = 1L;

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
			if(seat==null) {
				throw new DBException("No seat found for this flight id");
			}else {
				 System.out.println(new Gson().toJson(seat));
			       
			        response.getWriter().write(new Gson().toJson(seat));
			}
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
	 }
	
	

}

