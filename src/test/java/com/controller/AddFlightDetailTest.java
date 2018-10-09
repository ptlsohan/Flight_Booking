package com.controller;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static org.mockito.Mockito.*;

import java.io.IOException;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Airplane;
import com.bean.Flight;
import com.bean.Seat;
import com.controller.AddFlightDetail;
import com.dao.AirplaneDao;
import com.dao.FlightDao;
import com.dao.SeatDao;
import com.exception.DBException;

@RunWith(PowerMockRunner.class)
@PrepareForTest({FlightDao.class,SeatDao.class,AirplaneDao.class})
public class AddFlightDetailTest {

	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock
	RequestDispatcher rd;
	@Mock
	HttpSession session;
	
	@Before
	public void init() throws DBException {
		PowerMockito.mockStatic(FlightDao.class);
		when(FlightDao.insertFlight(new Flight())).thenReturn(1);
		PowerMockito.mockStatic(SeatDao.class);
		when(SeatDao.insertSeat(new Seat())).thenReturn(1);
		PowerMockito.mockStatic(AirplaneDao.class);
		when(AirplaneDao.insertAirplane(new Airplane())).thenReturn(1);
	}
	
	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("fno")).thenReturn("1");
		when(req.getParameter("atime")).thenReturn("10:30:34");
		when(req.getParameter("dtime")).thenReturn("10:30:34");
		when(req.getParameter("adate")).thenReturn("2018-08-19");
		when(req.getParameter("ddate")).thenReturn("2018-08-19");
		when(req.getParameter("air_id")).thenReturn("2");
		when(req.getParameter("a_city")).thenReturn("chicago");
		when(req.getParameter("d_city")).thenReturn("nyc");
		when(req.getParameter("eseat")).thenReturn("10");
		when(req.getParameter("fseat")).thenReturn("10");
		when(req.getParameter("bseat")).thenReturn("10");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		when(req.getSession(false)).thenReturn(session);
		AddFlightDetail a= new AddFlightDetail();
		a.doPost(req, res);
		verify(res,times(1)).sendRedirect("listFlight");
		
	}
	@Before
	public void init2() throws DBException {
		PowerMockito.mockStatic(FlightDao.class);
		when(FlightDao.insertFlight(new Flight())).thenReturn(0);
		
	}
	@Test
	public void test2() throws IOException, ServletException {
		when(req.getParameter("fno")).thenReturn("156");
		when(req.getParameter("atime")).thenReturn("7:00:34");
		when(req.getParameter("dtime")).thenReturn("10:30:22");
		when(req.getParameter("adate")).thenReturn("2018-10-22");
		when(req.getParameter("ddate")).thenReturn("2018-10-19");
		when(req.getParameter("air_id")).thenReturn("12");
		when(req.getParameter("a_city")).thenReturn("london");
		when(req.getParameter("d_city")).thenReturn("nyc");
		when(req.getParameter("eseat")).thenReturn("10");
		when(req.getParameter("fseat")).thenReturn("12");
		when(req.getParameter("bseat")).thenReturn("8");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		when(req.getSession(false)).thenReturn(session);
		AddFlightDetail a= new AddFlightDetail();
		a.doPost(req, res);
		verify(req,times(1)).getRequestDispatcher("/Error.jsp");
		
	}
	
	
	
	@Test
	public void test3() throws IOException, ServletException {
		when(req.getParameter("fno")).thenReturn("1");
		when(req.getParameter("atime")).thenReturn(null);
		when(req.getParameter("dtime")).thenReturn(null);
		when(req.getParameter("adate")).thenReturn(null);
		when(req.getParameter("ddate")).thenReturn("2018-08-19");
		when(req.getParameter("air_id")).thenReturn("2");
		when(req.getParameter("a_city")).thenReturn("chicago");
		when(req.getParameter("d_city")).thenReturn("nyc");
		when(req.getParameter("eseat")).thenReturn("10");
		when(req.getParameter("fseat")).thenReturn("10");
		when(req.getParameter("bseat")).thenReturn("10");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		when(req.getSession(false)).thenReturn(session);
		AddFlightDetail a= new AddFlightDetail();
		a.doPost(req, res);
		verify(req,times(1)).getRequestDispatcher("/Error.jsp");
		
	}
	
	@Test
	public void test4() throws IOException, ServletException {
		when(req.getParameter("fno")).thenReturn("error");
		when(req.getParameter("air_id")).thenReturn("2");
		when(req.getParameter("eseat")).thenReturn("10");
		when(req.getParameter("fseat")).thenReturn("10");
		when(req.getParameter("bseat")).thenReturn("10");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		AddFlightDetail a= new AddFlightDetail();
		a.doPost(req, res);
		verify(req,times(1)).getRequestDispatcher("/Error.jsp");
		
	}
	
	

}
