package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDao;
import dao.FlightDao;
import dao.SeatDao;

@WebServlet("/deleteFlight")
public class DeleteFlight extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		int fno = Integer.parseInt(request.getParameter("fno"));
		try {
			
			SeatDao.removeFlight(fno);
			FlightDao.removeFlight(fno);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("listFlight").forward(request, response);
}
}
