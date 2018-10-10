package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Passanger;
import com.dao.PassangerDao;
import com.exception.DBException;


@WebServlet("/addProfile")
public class AddProfile extends HttpServlet {

	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
	if(!isInteger(request.getParameter("pid")) || !isInteger(request.getParameter("age")) ||
			!isInteger(request.getParameter("apt")) || !isInteger(request.getParameter("zip"))) {
		request.setAttribute("error", "Please enter correct number ");
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
		return;
	}
		
	
	
		int pid = Integer.parseInt(request.getParameter("pid"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String uname= request.getParameter("username");
		String ssn = request.getParameter("ssn");
		String email= request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		String street = request.getParameter("street");
		int apt = Integer.parseInt(request.getParameter("apt"));
		String city= request.getParameter("city");
		String state= request.getParameter("state");
		int zip = Integer.parseInt(request.getParameter("zip"));
		String thome= request.getParameter("thome");
		String toffice= request.getParameter("toffice");
		
		if(pid<=0 || fname==null || lname==null || ssn==null || email==null || age<=0 || street==null
				|| apt<=0 || city==null || state==null || zip <=0 || thome == null || toffice ==null) {
			request.setAttribute("error", "Please enter correct details ");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			return;
			
		}
		
		Passanger p =new Passanger(pid,uname,fname,lname,ssn,age,street,apt,city,state,zip,thome,toffice,email);
		int id=0;
		try {
			int ret=PassangerDao.updatePassanger(p);
			if(ret==1) {
				Passanger i=PassangerDao.getPassanger(uname);
				id = PassangerDao.getPassangerId(uname);
				HttpSession session=request.getSession(false);
				session.setAttribute("p", i);
				session.setAttribute("pid", id);
			}
			System.out.println(ret);
		} catch (DBException e) {
		e.printStackTrace();
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		//request.getRequestDispatcher("search.jsp").forward(request,response);
		HttpSession session = request.getSession(false);
		session.setAttribute("alertMsg", "Profile updated");
		response.sendRedirect("search.jsp");
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
