package com.dao;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.junit.Assert.assertArrayEquals;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Flight;
import com.dao.FlightDao;
import com.dbUtility.DBStore;
import com.dbUtility.PropertyUtil;
import com.exception.DBException;


@RunWith(PowerMockRunner.class)
@PrepareForTest({PropertyUtil.class,DBStore.class})
@PowerMockIgnore("javax.management.*")
public class FlightDaoTest {
	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException, IOException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		p.load(FlightDaoTest.class.getResourceAsStream("/db_test.properties"));
		String CreateQuery="CREATE TABLE IF NOT EXISTS Flight(\n" + 
				"Flight_number INT NOT NULL,\n" + 
				"Arrival_time TIME NOT NULL,\n" + 
				"Arrival_date DATE NOT NULL,\n" + 
				"Departure_time TIME NOT NULL,\n" + 
				"Departure_date DATE NOT NULL,\n" + 
				"Destination VARCHAR(45) NOT NULL,\n" + 
				"Airplane_id INT,\n" + 
				"Departure_city VARCHAR(45) NOT NULL,\n" + 
				"Arrival_city VARCHAR(45) NOT NULL,\n" + 
				"PRIMARY KEY (Flight_number)\n" + 
				
				");";
		when(PropertyUtil.readPropertyFile()).thenReturn(p);
		Connection conn=DBStore.getConnection();
		PreparedStatement createPreparedStatement = conn.prepareStatement(CreateQuery);
		createPreparedStatement.executeUpdate();
	
	
	}
	@Test
	public void testInsert() throws DBException {
		Date d= Date.valueOf("2018-8-19");
		Date d2= Date.valueOf("2018-8-19");
		Time t= Time.valueOf("08:23:45");
		Time t2= Time.valueOf("08:23:45");
		Flight f= new Flight(13,t,d,t2,d2,0,"chicago","new york");
		assertEquals(1,FlightDao.insertFlight(f));
	}
	
	@Test
	public void testGetFlight() throws DBException {
		Date d= Date.valueOf("2018-8-19");
		Date d2= Date.valueOf("2018-8-19");
		Time t= Time.valueOf("08:23:45");
		Time t2= Time.valueOf("08:23:45");
		Flight f= new Flight(13,t,d,t2,d2,0,"chicago","new york");
		List<Flight> flist=new ArrayList<>();
		flist.add(f);

		
		assertArrayEquals(flist.toArray(), FlightDao.selectAllFlight().toArray());
		
	}
	@Test
	public void testUpdateFlight() throws DBException {
		
		Date d= Date.valueOf("2018-8-19");
		Date d2= Date.valueOf("2018-8-19");
		Time t= Time.valueOf("08:23:45");
		Time t2= Time.valueOf("08:23:45");
		Flight f= new Flight(13,t,d,t2,d2,0,"chicago","boston");
		assertEquals(1,FlightDao.updateFlight(f));
	}
	
	@Test
	public void testRemoveFlight() throws DBException {
		int f=13;
		
		assertTrue(FlightDao.removeFlight(f));
	}

}
