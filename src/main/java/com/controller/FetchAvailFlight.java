package com.controller;

import java.io.IOException;
import java.sql.Date;

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


@WebServlet("/fetchAvailFlight")
public class FetchAvailFlight extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Flight> fli = new ArrayList<>();
		String dep_city = request.getParameter("from");
		String arr_city = request.getParameter("to");
		String d= request.getParameter("ondate");
//		System.out.println("ondate"+d);
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//		LocalDate parsed;
//		parsed = LocalDate.parse(d, format);
//		
//		System.out.println("ondate"+d);
		Date date = Date.valueOf(d);
		
		
		try {
			fli=FlightDao.selectFlight(date, dep_city, arr_city);
		} catch (DBException e1) {
			request.setAttribute("error", "Database down! Please try again later.");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			
		}
		
		
		System.out.println(fli);
		request.setAttribute("list", fli);	
		request.getRequestDispatcher("/displayFlight.jsp").forward(request, response);
			
		
		
	}

}
