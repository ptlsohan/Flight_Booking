package com.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Properties;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Booking;
import com.bean.Flight;
import com.bean.Passanger;
import com.dbUtility.DBStore;
import com.dbUtility.PropertyUtil;
import com.exception.DBException;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyUtil.class)
public class BookDaoTest {

	
	@BeforeClass
	public static void init() throws IOException, SQLException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		p.load(BookDaoTest.class.getResourceAsStream("/db_test.properties"));
		when(PropertyUtil.readPropertyFile()).thenReturn(p);
		String CreateFlight="CREATE TABLE IF NOT EXISTS Flight(\n" + 
				"Flight_number INT NOT NULL,\n" + 
				"Arrival_time TIME NOT NULL,\n" + 
				"Arrival_date DATE NOT NULL,\n" + 
				"Departure_time TIME NOT NULL,\n" + 
				"Departure_date DATE NOT NULL,\n" + 
				"Destination VARCHAR(45) NOT NULL,\n" + 
				"Airplane_id INT,\n" + 
				"Departure_city VARCHAR(45) NOT NULL,\n" + 
				"Arrival_city VARCHAR(45) NOT NULL,\n" + 

				");";
		Connection conn=DBStore.getConnection();
		PreparedStatement createPreparedStatement = conn.prepareStatement(CreateFlight);
		createPreparedStatement.executeUpdate();
		
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
		 createPreparedStatement = conn.prepareStatement(CreateQuery);
		 createPreparedStatement.executeUpdate();
		 
		 CreateQuery="CREATE TABLE Flight_class(\n" + 
				"Class VARCHAR(15),\n" + 
				"PRIMARY KEY (Class)\n" + 
				"\n" + 
				");";
		
		 createPreparedStatement = conn.prepareStatement(CreateQuery);
		 createPreparedStatement.executeUpdate();
		
		 CreateQuery="CREATE TABLE Booking_status (\n" + 
					"Status VARCHAR(20),\n" + 
					"PRIMARY KEY(Status)\n" + 
					");";
			createPreparedStatement = conn.prepareStatement(CreateQuery);
			createPreparedStatement.executeUpdate();	
		 CreateQuery="CREATE TABLE Booking(\n" + 
				"Booking_id INT AUTO_INCREMENT,\n" + 
				"Passanger_id INT,\n" + 
				"Flight_number INT NOT NULL,\n" + 
				"Seat_number INT NOT NULL,\n" + 
				"Baggage VARCHAR(45),\n" + 
				"Class VARCHAR(15),\n" + 
				"Reser_status VARCHAR(20),\n" + 
				"PRIMARY KEY (Booking_id),\n" + 
				"FOREIGN KEY (Flight_number)\n" + 
				"REFERENCES Flight(Flight_number),\n" + 
				"FOREIGN KEY (Passanger_id)\n" + 
				"REFERENCES Passanger(Passanger_id),\n" + 
				"FOREIGN KEY (Class)\n" + 
				"REFERENCES Flight_class(Class),\n" + 
				"FOREIGN KEY (Reser_status)\n" + 
				"REFERENCES Booking_status(Status)\n" + 
				");\n" + 
				"";
		
		 createPreparedStatement = conn.prepareStatement(CreateQuery);
		createPreparedStatement.executeUpdate();
	}
	@Test(expected=DBException.class)
	public void test() throws DBException {
		Booking b= new Booking(1,0,0,2,"checkin",null,null);
		assertTrue(BookDao.insertBooking(b));
	}
	
	@Before
	public void init1() throws DBException, IOException, SQLException {

		
	}
	
	@Test
	public void testInsert() throws DBException {
		Passanger p1 =new Passanger("abc","Sohan","P","3345",25,"St Charles",1000,"St Charles","IL",12345,"12345","456789","abc@abc.com");
		PassangerDao.insertPassanger(p1);
		Date d= Date.valueOf("2018-8-19");
		Date d2= Date.valueOf("2018-8-19");
		Time t= Time.valueOf("08:23:45");
		Time t2= Time.valueOf("08:23:45");
		Flight f= new Flight(96,t,d,t2,d2,0,"chicago","new york");
		FlightDao.insertFlight(f);

		Booking b= new Booking(1,1,96,2,"checkin",null,null);
		assertFalse(BookDao.insertBooking(b));
	}

}
