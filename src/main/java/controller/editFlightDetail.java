package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.bean.Seat;

import dao.FlightDao;
import dao.SeatDao;

@WebServlet("/editFlightDetail")
public class editFlightDetail extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int ret=0;
		int fno = Integer.parseInt(request.getParameter("f"));
		Flight f= null;
		Seat s=null;
		try {
			f=FlightDao.getFlight(fno);
			s=SeatDao.getSeats(fno);
			System.out.println(s);
		} catch (SQLException e) {
			request.setAttribute("error", e);
			
			e.printStackTrace();
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		request.setAttribute("flist",f);
		request.setAttribute("seat",s);
		request.getRequestDispatcher("editFlight.jsp").forward(request, response);
	}
}
