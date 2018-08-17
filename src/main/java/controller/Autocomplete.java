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

import com.bean.Flight;
import com.google.gson.Gson;

import dao.FlightDao;


@WebServlet("/autocomplete")
public class Autocomplete extends HttpServlet {
	 @Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException, ServletException {
	        System.out.println("Autocomplete");
	        System.out.println(request.getParameter("city"));
	        String city=request.getParameter("city");
	       // System.out.println(request.getPathInfo());
	        response.setContentType("application/json");
	      //  response.setCharacterEncoding("UTF-8");
	        List<Flight> list = new ArrayList<>();
	        List<String> citylist = new ArrayList<>();
	        StringBuilder sb= new StringBuilder();
	      try {
			list = FlightDao.selectAllFlight();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(new Gson().toJson(list));

	      boolean namesAdded = false;
	       
	           
	            if (!city.equals("")) {


	        		for(Flight li: list) {
	                   
	                    

	                    if (li.getArrival_city().toLowerCase().startsWith(city.toLowerCase()) ||
	                            li.getDeparture_city().toLowerCase().startsWith(city.toLowerCase())) {
//	                        sb.append("{");
//	                        sb.append("'d_city':'" + li.getDeparture_city() + "',");
//	                        sb.append("'a_city':'" + li.getArrival_city() + "'");
//	                        sb.append("},");
//	                        System.out.println(li.getDeparture_city());
//	                        namesAdded = true;
	                    	citylist.add(li.getDeparture_city());
	                    	//citylist.add(li.getDeparture_city(li.getArrival_city()));
	                    }
	                }
	                }
	      System.out.println(sb.toString());
	        
	       
	        response.getWriter().write(new Gson().toJson(citylist));
	 }
	
	

}
