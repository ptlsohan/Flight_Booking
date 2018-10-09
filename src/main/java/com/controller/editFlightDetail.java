package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.bean.Seat;
import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;

@WebServlet("/editFlightDetail")
public class editFlightDetail extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int fno = Integer.parseInt(request.getParameter("f"));
		Flight f= null;
		Seat s=null;
		try {
			f=FlightDao.getFlight(fno);
			s=SeatDao.getSeats(fno);
			System.out.println(s);
		} catch (DBException e) {
			request.setAttribute("error", "Unable to edit flight details.Please try again later");	
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		request.setAttribute("flist",f);
		request.setAttribute("seat",s);
		request.getRequestDispatcher("editFlight.jsp").forward(request, response);
	}
}
