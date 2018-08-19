package controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Flight;
import com.bean.Passanger;
import com.bean.User;

import dao.PassangerDao;
import dao.UserDao;


@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet{
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
	
	try {
		UserDao.insertUser(user);
		int ret=PassangerDao.insertPassanger(p);
		
	} catch (SQLException e1) {
		request.setAttribute("error", e1);
		//request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	request.getRequestDispatcher("/login.jsp").forward(request, response);
	
 }
}
