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
import com.bean.User;

import dao.UserDao;


@WebServlet("/registerUser")
public class RegisterUser extends HttpServlet{
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	
	String uname = request.getParameter("uname");
	String password = request.getParameter("password");
	String utype= request.getParameter("utype");
	User user = new User(uname,password,utype);
	
	try {
		UserDao.insertUser(user);
		
	} catch (SQLException e1) {
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
	}
	request.getRequestDispatcher("/login.jsp").forward(request, response);
	
 }
}
