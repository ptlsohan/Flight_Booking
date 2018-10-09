package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.BHistory;
import com.bean.Booking;
import com.bean.Flight;
import com.dao.BookDao;
import com.dao.FlightDao;
import com.dao.PassangerDao;
import com.exception.DBException;

@WebServlet("/bookHistory")
public class BookHistory extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			request.setAttribute("error", "Session expired!Please login again");
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		
		}
		int pId=0;
		List<BHistory> bh=new ArrayList<>(); 
		if(session!=null) {
			String uname = (String) session.getAttribute("username");
			try {
			 pId = PassangerDao.getPassangerId(uname);
			} catch (DBException e) {
				request.setAttribute("ErrorMsg","Please complete your profile");
				System.out.println(e.getMessage());
				request.getRequestDispatcher("/Error.jsp").forward(request,response);
			}
			System.out.println(pId);
			List<Booking> blist = new ArrayList<>();
			Flight flist = null;
			try {
				blist=BookDao.getBooking(pId);
				//flist=FlightDao.
			} catch (DBException e) {
				request.setAttribute("ErrorMsg","No booking found");
				request.getRequestDispatcher("/Error.jsp").forward(request,response);
			}
			for(Booking i:blist) {
				i.getFlight_number();
				try {
					flist=FlightDao.getFlight(i.getFlight_number());
					System.out.println(flist);
				} catch (DBException e) {
					request.setAttribute("error","Unable to fetch flight detail from database.Please try again later.");
					request.getRequestDispatcher("/Error.jsp").forward(request, response);
				}
				BHistory bhistory=new BHistory(i.getBooking_id(),i.getPassanger_id(),i.getFlight_number(),flist.getArrival_time(),flist.getArrival_date(),flist.getDeparture_time(),flist.getDeparture_date(),flist.getAirplane_id(),flist.getDeparture_city(),flist.getArrival_city());
				bh.add(bhistory);
			}
			request.setAttribute("blist",bh);
			request.getRequestDispatcher("/bookingHistory.jsp").forward(request,response);
		}
	
	}

}
