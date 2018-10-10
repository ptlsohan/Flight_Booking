package com.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Booking;
import com.dao.BookDao;
import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;


@WebServlet("/deleteBooking")
public class DeleteBooking extends HttpServlet {
	
	private static final long serialVersionUID = -6651908218510825906L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		int fno = Integer.parseInt(request.getParameter("fno"));
		
		try {
			
			FlightDao.getFlight(fno);
			BookDao.removeBooking(bId);
			
		} catch (DBException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error","Unable to delete booking.Please try again later.");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			System.out.println(e.getMessage());
		}
		//request.getRequestDispatcher("bookHistory").forward(request, response);
		response.sendRedirect("bookHistory");
}
}
