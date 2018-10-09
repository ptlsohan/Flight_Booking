package com.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import static org.powermock.api.mockito.PowerMockito.when;
import org.powermock.modules.junit4.PowerMockRunner;

import com.dbUtility.DBStore;
import com.dbUtility.PropertyUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyUtil.class)
public class BookDaoTest {

	
	@Before
	public void init() throws IOException, SQLException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		p.load(BookDaoTest.class.getResourceAsStream("/db_test.properties"));
		when(PropertyUtil.readPropertyFile()).thenReturn(p);
		String CreateQuery="CREATE TABLE Booking(\n" + 
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
		Connection conn=DBStore.getConnection();
		PreparedStatement createPreparedStatement = conn.prepareStatement(CreateQuery);
		createPreparedStatement.executeUpdate();
	}
	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
