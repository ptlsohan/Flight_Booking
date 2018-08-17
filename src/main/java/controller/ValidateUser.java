package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.User;

import dao.PassangerDao;
import dao.UserDao;


@WebServlet("/validate")
public class ValidateUser extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String uname = request.getParameter("uname");
		String password = request.getParameter("password");
		String utype= request.getParameter("utype");
		int i=0;
		
		String user=null;
		try {
			user = UserDao.selectUser(uname, password, utype);
			i=PassangerDao.getPassangerId(uname);
		} catch (SQLException e) {
			request.getRequestDispatcher("/Error.jsp").forward(request, response);
		}
		if(user!=null) {
			HttpSession session= request.getSession(true);
		      session.setAttribute("username",uname);
		      session.setAttribute("pId",i);
		      session.setAttribute("usertype",utype);
			request.getRequestDispatcher("/search.jsp").forward(request, response);
		}else {
			request.setAttribute("error", "Invalid username/password");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}
}
