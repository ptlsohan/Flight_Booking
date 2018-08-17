package controller;

import java.io.IOException;
import java.sql.SQLException;
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

import dao.BookDao;
import dao.FlightDao;
import dao.PassangerDao;

@WebServlet("/bookHistory")
public class BookHistory extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		HttpSession session = request.getSession(false);
		if(session==null) {
			request.getRequestDispatcher("/Error.jsp").forward(request,response);
		
		}
		int pId=0;
		List<BHistory> bh=new ArrayList<>(); 
		if(session!=null) {
			String uname = (String) session.getAttribute("username");
			try {
			 pId = PassangerDao.getPassangerId(uname);
			} catch (SQLException e) {
				request.setAttribute("ErrorMsg","Please complete your profile");
				e.printStackTrace();
				request.getRequestDispatcher("/Error.jsp").forward(request,response);
			}
			System.out.println(pId);
			List<Booking> blist = new ArrayList<>();
			Flight flist = null;
			try {
				blist=BookDao.getBooking(pId);
				//flist=FlightDao.
			} catch (SQLException e) {
				request.setAttribute("ErrorMsg","No booking found");
				e.printStackTrace();
				request.getRequestDispatcher("/Error.jsp").forward(request,response);
			}
			for(Booking i:blist) {
				i.getFlight_number();
				try {
					flist=FlightDao.getFlight(i.getFlight_number());
					System.out.println(flist);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BHistory bhistory=new BHistory(i.getBooking_id(),i.getPassanger_id(),i.getFlight_number(),flist.getArrival_time(),flist.getArrival_date(),flist.getDeparture_time(),flist.getDeparture_date(),flist.getAirplane_id(),flist.getDeparture_city(),flist.getArrival_city());
				bh.add(bhistory);
			}
			request.setAttribute("blist",bh);
			request.getRequestDispatcher("/bookingHistory.jsp").forward(request,response);
		}
	
	}

}
