package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Booking;

import dao.BookDao;

@WebServlet("/BookFlight")
public class BookFlight extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		int bookId=0;
		HttpSession session = request.getSession(false);
		int fnum = Integer.parseInt(request.getParameter("fnum"));
		int pid = (int)session.getAttribute("pId");
		int seatno= Integer.parseInt(request.getParameter("seatno"));
		String bag = request.getParameter("baggage");
		String fclass= request.getParameter("class");
		String status= request.getParameter("status");
		Booking b = new Booking(pid,fnum,seatno,bag,fclass,status);
		try {
			boolean ret= BookDao.insertBooking(b);
		
			 bookId= BookDao.getBookingId(fnum, pid);
			 System.out.println(bookId);
			 
		} catch (SQLException e) {
		//	request.setAttribute("error","Booking failed");
			e.printStackTrace();
			//request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		
		if(bookId!=0) {
			
			session.setAttribute("bookId", bookId);
		request.getRequestDispatcher("/confirmation.jsp").forward(request, response);
		}
		
}
}
