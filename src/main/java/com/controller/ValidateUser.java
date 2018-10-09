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
import com.dao.UserDao;
import com.exception.DBException;


@WebServlet("/validate")
public class ValidateUser extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String utype= request.getParameter("utype");
		Passanger i=null;
		
		String user=null;
		try {
			user = UserDao.selectUser(uname, password, utype);
			i=PassangerDao.getPassanger(uname);
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("error", "Database down! Please try again later");
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
			//return;
		}
		if(user!=null) {
			HttpSession session= request.getSession(true);
		      session.setAttribute("username",uname);
		      session.setAttribute("p",i);
		      session.setAttribute("usertype",utype);
			request.getRequestDispatcher("/search.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Invalid username/password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
