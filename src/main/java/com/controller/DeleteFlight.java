package com.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		try {
			
			SeatDao.removeSeat(fno);
			FlightDao.removeFlight(fno);
			
		} catch (DBException | SQLException e) {
			request.setAttribute("error", "Unable to delete flight. Please try again later.");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("alertMsg", "Flight "+fno+" deleted");
		response.sendRedirect("listFlight");
}
}
