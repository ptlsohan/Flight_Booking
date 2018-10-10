package com.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Airplane;

import com.dao.AirplaneDao;

import com.exception.DBException;
import com.google.gson.Gson;


@WebServlet("/fetchAirId")
public class FetchAirId extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	    public void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws IOException, ServletException {
	        
	        
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	  
	       List<Airplane> idList = new ArrayList<>();
	       List<Integer> airId = new ArrayList<>();
	      try {
			 idList = AirplaneDao.selectAllAirplane();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			System.out.print("Unable to fetch id"+e.getMessage());
		}

	        		for(Airplane li: idList) {
	        			airId.add(li.getAirplane_id());
	                }
	                
	       
	        response.getWriter().write(new Gson().toJson(airId));
	 }
	
	     
	 }
	
	



