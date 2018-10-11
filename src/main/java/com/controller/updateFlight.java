package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

@WebServlet("/updateFlight")
public class updateFlight extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
System.out.println(request.getParameter("air_id"));


String datepattern = "^([12]\\d)?(\\d\\d)[\\.\\/\\-](0?[1-9]|1[012])[\\.\\/\\-](0?[1-9]|[12]\\d|3[01])$";
Pattern r = Pattern.compile(datepattern);
Matcher m1 = r.matcher(request.getParameter("ddate"));
Matcher m2 = r.matcher(request.getParameter("adate"));
String timepattern = "^([01]\\d|2[0-3]|[0-9])(:[0-5]\\d){1,2}(:[0-5]\\d){1,2}$";
Pattern r1 = Pattern.compile(timepattern);
Matcher t1 = r1.matcher(request.getParameter("dtime"));
Matcher t2 = r1.matcher(request.getParameter("atime"));
if(!m1.matches() || !m2.matches() || !t1.matches() || !t2.matches()) {
	 request.setAttribute("error", "Please enter correct date/time ");
		request.getRequestDispatcher("addFlightDetail").forward(request, response);
		return;
}

if(!isInteger(request.getParameter("fno")) || !isInteger(request.getParameter("air_id"))
		|| !isInteger(request.getParameter("eseat")) || !isInteger(request.getParameter("bseat"))
		|| !isInteger(request.getParameter("fseat")) || !isInteger(request.getParameter("version")) ) {
	request.setAttribute("error", "Please enter correct number ");
	request.getRequestDispatcher("addFlightDetail").forward(request, response);
	return;
}
		int fno = Integer.parseInt(request.getParameter("fno"));
		int v = Integer.parseInt(request.getParameter("version"));
		String a_time = request.getParameter("atime");
		String a_date= request.getParameter("adate");
		String d_time = request.getParameter("dtime");
		String d_date= request.getParameter("ddate");
		int air_id = Integer.parseInt(request.getParameter("air_id"));
		String d_city = request.getParameter("d_city");
		String a_city= request.getParameter("a_city");
		
		if(fno<=0 || a_time ==null || a_date == null || d_time==null || d_date==null || air_id<=0
				|| d_city==null || a_city == null) {
			request.setAttribute("error", "Please enter correct details ");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
			
		}
		
		Date ddate= Date.valueOf(d_date);
		Date adate= Date.valueOf(a_date);
		Time dtime= Time.valueOf(d_time);
		Time atime = Time.valueOf(a_time);
		int eseat = Integer.parseInt(request.getParameter("eseat"));
		int fseat = Integer.parseInt(request.getParameter("fseat"));
		int bseat = Integer.parseInt(request.getParameter("bseat"));
		Flight f= new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
//		Airplane a= new Airplane(air_id,"Boeing",777);
		//int v=1;
		Seat s=new Seat(fno,eseat,fseat,bseat,v);
		try {
//			AirplaneDao.insertAirplane(a);
			FlightDao.updateFlight(f);
			SeatDao.updateSeat(s);
			
			
		} catch (DBException e) {
			request.setAttribute("error", "Unable to update flight details.Please try again later");
			e.printStackTrace();
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		HttpSession session = request.getSession(false);
		session.setAttribute("alertMsg", "Flight "+ fno+"updated");
		response.sendRedirect("listFlight");

		
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
