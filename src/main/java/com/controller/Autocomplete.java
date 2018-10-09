package com.controller;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.dao.FlightDao;
import com.exception.DBException;
import com.google.gson.Gson;


@WebServlet("/autocomplete")
public class Autocomplete extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException, ServletException {
	        System.out.println("Autocomplete");
	        System.out.println(request.getParameter("city"));
	        String city=request.getParameter("city");	       
	        response.setContentType("application/json");
	        List<Flight> list = new ArrayList<>();
	        List<Flight> citylist = new ArrayList<>();
	        StringBuilder sb= new StringBuilder();
	      try {
			list = FlightDao.selectAllFlight();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			System.out.print("Unable to fetch flights"+e.getMessage());
		}
	      System.out.println(new Gson().toJson(list));
         
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
	                    	//if(citylist.)
	                    	citylist.add(li);
	                    	//citylist.add(li.getDeparture_city(li.getArrival_city()));
	                    }
	                }
	                }
	      System.out.println(sb.toString());
	        
	       
	        response.getWriter().write(new Gson().toJson(citylist));
	 }
	
	

}
