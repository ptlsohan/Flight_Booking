package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Flight;
import com.bean.Seat;
import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;


@WebServlet("/addFlightDetail")
public class AddFlightDetail extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int ret=0;
		int fno = Integer.parseInt(request.getParameter("fno"));
		String a_time = request.getParameter("atime");
		String a_date= request.getParameter("adate");
		String d_time = request.getParameter("dtime");
		String d_date= request.getParameter("ddate");
		int air_id = Integer.parseInt(request.getParameter("air_id"));
		String d_city = request.getParameter("d_city");
		String a_city= request.getParameter("a_city");
		int eseat = Integer.parseInt(request.getParameter("eseat"));
		int fseat = Integer.parseInt(request.getParameter("fseat"));
		int bseat = Integer.parseInt(request.getParameter("bseat"));
		Date ddate= Date.valueOf(d_date);
		Date adate= Date.valueOf(a_date);
		Time dtime= Time.valueOf(d_time);
		Time atime = Time.valueOf(a_time);
		Flight f= new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
		int v=1;
		Seat s=new Seat(fno,eseat,fseat,bseat,v);
		try {
			ret=FlightDao.insertFlight(f);
			if(ret==1) {
				SeatDao.insertSeat(s);
			}else {
				request.setAttribute("error", "Unable to add flight details");
				
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
			}
			
		}  catch (DBException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getMessage());
				
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("alertMsg", "Flight details added");
		
	//request.getRequestDispatcher("listFlight").forward(request, response);
		response.sendRedirect("listFlight");

}

}
