package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import com.bean.Flight;

import dbUtility.DBStore;

public class FlightDao {
	public static int insertFlight(Flight f) throws SQLException, IOException{
		 Connection conn = DBStore.getConnection();
		 int ret=0;
			String insertIntoFlight = "INSERT INTO Flight(flight_number, arrival_time, arrival_date, departure_time,departure_date, destination, airplane_id, departure_city, arrival_city) "
			+ "VALUES (?,?,?,?,?,?,?,?,?);";
			try(PreparedStatement pst = conn.prepareStatement(insertIntoFlight);){
			pst.setInt(1,f.getFlight_number());
			pst.setTime(2,f.getArrival_time());
			pst.setDate(3,f.getArrival_date());
			pst.setTime(4,f.getDeparture_time());
			pst.setDate(5,f.getDeparture_date());
			pst.setString(6,"default");
			pst.setInt(7,f.getAirplane_id());
			pst.setString(8,f.getDeparture_city());
			pst.setString(9,f.getArrival_city());
			
			
			
			ret =pst.executeUpdate();
			}
			conn.commit();
			
			return ret;
	}
	
	
	public static List<Flight> selectAllFlight() throws SQLException, IOException{
		 Connection conn = DBStore.getConnection();
		List<Flight> flight=new ArrayList();
		 
			String selectAllFlights ="select * from Flight";
			PreparedStatement pst = conn.prepareStatement(selectAllFlights);
			ResultSet rs = pst.executeQuery();
			System.out.println("after execute");
			Flight us=new Flight();
			while(rs.next())
			{
				int fno= rs.getInt("flight_number");
				Time atime= rs.getTime("arrival_time");
				Date adate= rs.getDate("arrival_date");
				Time dtime= rs.getTime("departure_time");
				Date ddate= rs.getDate("departure_date");
				int air_id= rs.getInt("airplane_id");
				String d_city= rs.getString("departure_city");
				String a_city= rs.getString("arrival_city");
				Flight newFlight = new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
				flight.add(newFlight);
			}
			
			conn.commit();
			rs.close();
			pst.close();
			conn.close();
		
			return flight;
	}
	
	public static List<Flight> selectFlight(Date d, String dep_city, String arr_city) throws SQLException, IOException{
		 Connection conn = DBStore.getConnection();
	List<Flight> flight=new ArrayList();
	
	String selectAllFlights ="SELECT * FROM Flight WHERE departure_date=? AND departure_city =? AND arrival_city=?";
	PreparedStatement pst = conn.prepareStatement(selectAllFlights);
	pst.setDate(1, d);
	pst.setString(2, dep_city);
	pst.setString(3, arr_city);
	ResultSet rs = pst.executeQuery();

	while(rs.next())
	{
	    int fno= rs.getInt("flight_number");
		 Time atime= rs.getTime("arrival_time");
		 Date adate= rs.getDate("arrival_date");
		 Time dtime= rs.getTime("departure_time");
		 Date ddate= rs.getDate("departure_date");
		 int air_id= rs.getInt("airplane_id");
		 String d_city= rs.getString("departure_city");
		 String a_city= rs.getString("arrival_city");
	    Flight newFlight = new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
	   flight.add(newFlight);
	}

	conn.commit();
	rs.close();
	pst.close();
	conn.close();	
	return flight;
	}
}
