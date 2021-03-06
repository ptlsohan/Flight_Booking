package com.controller;


import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Passanger;
import com.controller.AddProfile;
import com.dao.PassangerDao;
import com.exception.DBException;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PassangerDao.class)
public class AddProfileTest {

	
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock
	RequestDispatcher rd;
	@Mock HttpSession session;
	@BeforeClass
	public static void init() throws DBException {
		PowerMockito.mockStatic(PassangerDao.class);
		when(PassangerDao.insertPassanger(new Passanger())).thenReturn(1);
		
	}
	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("fname")).thenReturn("abc");
		when(req.getParameter("lname")).thenReturn("abc");
		when(req.getParameter("username")).thenReturn("user");
		when(req.getParameter("ssn")).thenReturn("12345");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("2");
		when(req.getParameter("street")).thenReturn("king dr");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getParameter("pid")).thenReturn("12");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		when(req.getSession(false)).thenReturn(session);
		AddProfile profile= new AddProfile();
		profile.doPost(req, res);
		verify(req,Mockito.never()).getRequestDispatcher("/Error.jsp");
		verify(res,times(1)).sendRedirect("search.jsp");
	}
	
	@Test
	public void test1() throws IOException, ServletException {
		when(req.getParameter("fname")).thenReturn(null);
		when(req.getParameter("lname")).thenReturn(null);
		when(req.getParameter("username")).thenReturn(null);
		when(req.getParameter("ssn")).thenReturn("12345");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("2");
		when(req.getParameter("street")).thenReturn("king dr");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getParameter("pid")).thenReturn("12");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		when(req.getSession(false)).thenReturn(session);
		AddProfile profile= new AddProfile();
		profile.doPost(req, res);
		verify(req,times(1)).getRequestDispatcher("/Error.jsp");
	}

}
