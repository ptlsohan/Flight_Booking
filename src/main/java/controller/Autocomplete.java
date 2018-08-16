package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;

import dao.FlightDao;


@WebServlet("/autocomplete")
public class Autocomplete extends HttpServlet {
	 @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException, ServletException {
	        System.out.println("Autocomplete");
	       // System.out.println(request.getParameter("searchId"));
	        System.out.println(request.getPathInfo());
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        List<Flight> list = new ArrayList<>();
	      try {
			list = FlightDao.selectAllFlight();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	       
	     //   response.getWriter().write();
	 }
	
	

}
