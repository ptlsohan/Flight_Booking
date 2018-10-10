package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Booking;
import com.bean.Flight;
import com.bean.Passanger;
import com.bean.Seat;
import com.dao.BookDao;
import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;

@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int bookId=0;
		HttpSession session = request.getSession(false);
		if( !isInteger(request.getParameter("seatno")) ||
				!isInteger(request.getParameter("version")) ) {
			request.setAttribute("error", "Please enter correct number ");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		if(session.getAttribute("p")==null) {
			request.setAttribute("error", "Session expired.Please login again ");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
		}
		
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		Passanger p = (Passanger)session.getAttribute("p");
		System.out.println(p);
		int pid= p.getPassanger_id();
		int seatno= Integer.parseInt(request.getParameter("seatno"));
		String bag = request.getParameter("baggage");
		String fclass= request.getParameter("class");
		String status= request.getParameter("status");
		int version = Integer.parseInt(request.getParameter("version"));
		Booking b = new Booking(pid,fnum,seatno,bag,fclass,status);
		Flight flight= null;
		
		try {
			flight= FlightDao.getFlight(fnum);
			Seat s=SeatDao.getSeats(fnum);
			int eseat=s.getEconomy_seat();
			int fseat=s.getFirst_seat();
			int bseat=s.getBusiness_seat();
			
			if("Economy".equals(fclass)) {
				eseat-=seatno;
			}else if("First class".equals(fclass)) {
				fseat-=seatno;
			}else if("Business".equals(fclass)) {
				bseat-=seatno;
			}
			Seat newseat=new Seat(fnum,eseat,fseat,bseat,version);
			System.out.println("flight number"+fnum);
			int val=SeatDao.updateSeat(newseat);
			System.out.println("after insert seat version"+val);
			if(val==0) {
				request.setAttribute("error","Seat not available.Please try selecting another seat");
				request.getRequestDispatcher("/Error.jsp").forward(request, response);
				return;
			}
			 BookDao.insertBooking(b);
			
			 bookId= BookDao.getBookingId(fnum, pid);
			 System.out.println(bookId);
			 
			 
		} catch (DBException e) {
			request.setAttribute("error","Booking failed");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		if(bookId!=0) {
			
			session.setAttribute("bookId", bookId);
			session.setAttribute("fname", p.getFirstName());
			session.setAttribute("lname", p.getLastName());
			session.setAttribute("seat", seatno);
			session.setAttribute("fclass", fclass);
			session.setAttribute("f", flight);
		//request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
		response.sendRedirect("confirmation.jsp");
		}
		
}

public static boolean isInteger(String str) {
    if (str == null) {
        return false;
    }
    if (str.isEmpty()) {
        return false;
    }
    int i = 0;
    if (str.charAt(0) == '-') {
        if (str.length() == 1) {
            return false;
        }
        i = 1;
    }
    for (; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c < '0' || c > '9') {
            return false;
        }
    }
    return true;
}
}
