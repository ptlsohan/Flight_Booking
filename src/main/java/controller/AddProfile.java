package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Passanger;

import dao.PassangerDao;


@WebServlet("/addProfile")
public class AddProfile extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
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
		
		Passanger p =new Passanger(uname,fname,lname,ssn,age,street,apt,city,state,zip,thome,toffice,email);
		int id=0;
		try {
			int ret=PassangerDao.insertPassanger(p);
			if(ret==1) {
				id=PassangerDao.getPassangerId(uname);
				HttpSession session=request.getSession(false);
				session.setAttribute("pid", id);
			}
			System.out.println(ret);
		} catch (SQLException e) {
		e.printStackTrace();
		request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		request.getRequestDispatcher("search.jsp").forward(request,response);
	}
}
