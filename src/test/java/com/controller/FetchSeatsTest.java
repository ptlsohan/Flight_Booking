package com.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Seat;
import com.dao.SeatDao;
import com.exception.DBException;
import com.google.gson.Gson;

@RunWith(PowerMockRunner.class)
@PrepareForTest(SeatDao.class)
public class FetchSeatsTest {
	FetchSeats fetchSeats= new FetchSeats();
	@Mock HttpServletRequest req;
	@Mock HttpServletResponse res;
	@Test
	public void test() throws DBException, ServletException, IOException {
		Mockito.when(req.getParameter("id")).thenReturn("4");
		PowerMockito.mockStatic(SeatDao.class);
		PowerMockito.when(SeatDao.getSeats(anyInt())).thenReturn(new Seat(1,1,1,1,1));
		StringWriter obj = new StringWriter();
		Mockito.when(res.getWriter()).thenReturn(new PrintWriter(obj));
		fetchSeats.doGet(req,res);
		assertEquals(new Gson().toJson(new Seat(1,1,1,1,1)),obj.toString());
	}

}
