package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;

import dao.FlightDao;


@WebServlet("/fetchAvailFlight")
public class FetchAvailFlight extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		List<Flight> fli = new ArrayList<>();
		String dep_city = request.getParameter("from");
		String arr_city = request.getParameter("to");
		String d= request.getParameter("ondate");
		Date date = Date.valueOf(d);
		
		
		try {
			fli=FlightDao.selectFlight(date, dep_city, arr_city);
		} catch (SQLException e1) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			
		}
		
		
		System.out.println(fli);
		request.setAttribute("list", fli);	
		request.getRequestDispatcher("/displayFlight.jsp").forward(request, response);
			
		
		
	}

}
