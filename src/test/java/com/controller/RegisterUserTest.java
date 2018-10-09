package com.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.controller.RegisterUser;
import com.dbUtility.DBStore;
import com.dbUtility.PropertyUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyUtil.class)
public class RegisterUserTest {
	
	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock 
	PropertyUtil obj;
	@Mock
	RequestDispatcher rd;
	
	@BeforeClass
	public static void init() throws SQLException, IOException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		
		p.load(RegisterUserTest.class.getResourceAsStream("/db_test.properties"));
		String CreateQuery="CREATE TABLE Passanger(\n" + 
				"Passanger_id INT NOT NULL AUTO_INCREMENT,\n" + 
				"username VARCHAR(20),\n" + 
				"FirstName VARCHAR(45) NOT NULL,\n" + 
				"LastName VARCHAR(45) ,\n" + 
				"SSN VARCHAR(9),\n" + 
				"Age INT,\n" + 
				"Street VARCHAR(45) NOT NULL,\n" + 
				"Apartment_number INT NOT NULL,\n" + 
				"City VARCHAR(45) NOT NULL,\n" + 
				"State VARCHAR(45) NOT NULL,\n" + 
				"Zip INT NOT NULL,\n" + 
				"Tel_home VARCHAR(45),\n" + 
				"Tel_office VARCHAR(45),\n" + 
				"Email VARCHAR(45),\n" + 
				"PRIMARY KEY (Passanger_id)\n" + 
				"\n" + 
				");" ;
		String CreateUser="CREATE TABLE User(\n" + 
				"username VARCHAR(20) PRIMARY KEY,\n" + 
				"password VARCHAR(20) NOT NULL,\n" + 
				"usertype VARCHAR(10) DEFAULT 'customer',\n" + 
				"FOREIGN KEY (username) REFERENCES User(username)\n"+
				");" ;
	when(PropertyUtil.readPropertyFile()).thenReturn(p);
	Connection conn=DBStore.getConnection();
	PreparedStatement createPreparedStatement = conn.prepareStatement(CreateQuery);
	createPreparedStatement.executeUpdate();
	createPreparedStatement = conn.prepareStatement(CreateUser);
	createPreparedStatement.executeUpdate();
	}

	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("uname")).thenReturn("abc");
		when(req.getParameter("password")).thenReturn("123");
		when(req.getParameter("utype")).thenReturn("admin");
		when(req.getParameter("fname")).thenReturn("abc");
		when(req.getParameter("lname")).thenReturn("cde");
		when(req.getParameter("ssn")).thenReturn("789123456");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("25");
		when(req.getParameter("street")).thenReturn("King drive");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		
		RegisterUser ru=new RegisterUser();
		ru.doPost(req, res);
		
		verify(res,times(1)).sendRedirect("login.jsp");

}
//	@BeforeClass
//	public static void init2() throws SQLException, IOException {
//		PowerMockito.mockStatic(PropertyUtil.class);
//		Properties p = new Properties();
//		
//		p.load(RegisterUserTest.class.getResourceAsStream("/db_test.properties"));
//		
//	when(PropertyUtil.readPropertyFile()).thenReturn(p);
//	
//	}

	@Test
	public void test2() throws IOException, ServletException {
		when(req.getParameter("uname")).thenReturn("abc");
		when(req.getParameter("password")).thenReturn("123");
		when(req.getParameter("utype")).thenReturn("admin");
		when(req.getParameter("fname")).thenReturn("abc");
		when(req.getParameter("lname")).thenReturn("cde");
		when(req.getParameter("ssn")).thenReturn("789123456");
		when(req.getParameter("email")).thenReturn("abc@abc.com");
		when(req.getParameter("age")).thenReturn("25");
		when(req.getParameter("street")).thenReturn("King drive");
		when(req.getParameter("apt")).thenReturn("1000");
		when(req.getParameter("city")).thenReturn("chicago");
		when(req.getParameter("state")).thenReturn("IL");
		when(req.getParameter("zip")).thenReturn("60000");
		when(req.getParameter("thome")).thenReturn("987654321");
		when(req.getParameter("toffice")).thenReturn("987654321");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		
		RegisterUser ru=new RegisterUser();
		ru.doPost(req, res);
		
		verify(req,times(2)).getRequestDispatcher("/Error.jsp");

}
	}
