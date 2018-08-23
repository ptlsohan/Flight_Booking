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
import javax.servlet.http.HttpSession;

import com.bean.Flight;

import dao.FlightDao;


	@WebServlet("/listFlight")
	public class ListFlight  extends HttpServlet {
		@Override
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			List<Flight> fli = new ArrayList<>();
			
			//System.out.println(date+" "+dep_city+" "+arr_city);
			try {
				fli=FlightDao.selectAllFlight();
			} catch (SQLException e1) {
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
			request.setAttribute("list", fli);
			request.getRequestDispatcher("/displayList.jsp").forward(request, response);
				
			
			
		}
		public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
			doGet(request,response);
		}
	}


