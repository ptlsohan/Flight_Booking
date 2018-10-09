package com.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Passanger;
import com.bean.User;
import com.dao.PassangerDao;
import com.dao.UserDao;
import com.exception.DBException;


@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	String uname = request.getParameter("uname");
	String password = request.getParameter("password");
	String utype= request.getParameter("utype");
	User user = new User(uname,password,utype);
	
	String fname = request.getParameter("fname");
	String lname = request.getParameter("lname");
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
	
	Passanger p =new Passanger(uname,fname,lname,ssn,age,street,apt,city,state,zip,thome,toffice,email);
	int ret=0;
	try {
		UserDao.insertUser(user);
		ret=PassangerDao.insertPassanger(p);
		
		
	} catch (DBException e1) {
		System.out.println(e1.getMessage());
		request.setAttribute("error","Unable to insert passanger detail.Please try again later");
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	if(ret==1) {
	response.sendRedirect("login.jsp");
	}else {
		request.setAttribute("error","Unable to insert passanger detail.Please try again later");
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	
 }
}
