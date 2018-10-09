package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

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

@WebServlet("/updateFlight")
public class updateFlight extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		

		int fno = Integer.parseInt(request.getParameter("fno"));
		String a_time = request.getParameter("atime");
		String a_date= request.getParameter("adate");
		String d_time = request.getParameter("dtime");
		String d_date= request.getParameter("ddate");
		int air_id = Integer.parseInt(request.getParameter("air_id"));
		String d_city = request.getParameter("d_city");
		String a_city= request.getParameter("a_city");
		
		Date ddate= Date.valueOf(d_date);
		Date adate= Date.valueOf(a_date);
		Time dtime= Time.valueOf(d_time);
		Time atime = Time.valueOf(a_time);
		int eseat = Integer.parseInt(request.getParameter("eseat"));
		int fseat = Integer.parseInt(request.getParameter("fseat"));
		int bseat = Integer.parseInt(request.getParameter("bseat"));
		Flight f= new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
		int v=1;
		Seat s=new Seat(fno,eseat,fseat,bseat,v);
		try {
			FlightDao.updateFlight(f);
			SeatDao.updateSeat(s);
			
		} catch (DBException e) {
			request.setAttribute("error", "Unable to update flight details.Please try again later");
			e.printStackTrace();
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		response.sendRedirect("listFlight");

		
}
}
