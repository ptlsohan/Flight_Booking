package com.dao;

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
import com.dbUtility.DBStore;
import com.exception.DBException;

public class FlightDao {
	public static int insertFlight(Flight f) throws DBException{
		 
		 int ret=0;
			String insertIntoFlight = "INSERT INTO Flight(flight_number, arrival_time, arrival_date, departure_time,departure_date, destination, airplane_id, departure_city, arrival_city) "
			+ "VALUES (?,?,?,?,?,?,?,?,?);";
			try(Connection conn = DBStore.getConnection();
			PreparedStatement pst = conn.prepareStatement(insertIntoFlight);){
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
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to insert record in Flight"+ e.getMessage());
			}
			
			
			return ret;
	}
	public static Flight getFlight(int fid) throws  DBException{
		

		 String getFlight ="SELECT * FROM Flight WHERE Flight_number=?";
		 Flight flight=null;
			try( Connection conn = DBStore.getConnection();
					PreparedStatement pst = conn.prepareStatement(getFlight);){
			pst.setInt(1,fid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int fno= rs.getInt("flight_number");
				Time atime= rs.getTime("arrival_time");
				Date adate= rs.getDate("arrival_date");
				Time dtime= rs.getTime("departure_time");
				Date ddate= rs.getDate("departure_date");
				int air_id= rs.getInt("airplane_id");
				String d_city= rs.getString("departure_city");
				String a_city= rs.getString("arrival_city");
				flight = new Flight(fno,atime,adate,dtime,ddate,air_id,d_city,a_city);
			}
			

			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to fetch record from flight"+ e.getMessage());
			}
			
			
			return flight;
	}
	
	
	public static List<Flight> selectAllFlight() throws DBException{
		 
		List<Flight> flight=new ArrayList<>();
		 
			String selectAllFlights ="select * from Flight";
			try(Connection conn = DBStore.getConnection();
					PreparedStatement pst = conn.prepareStatement(selectAllFlights);
			ResultSet rs = pst.executeQuery();){
			
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
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to fetch records from flight"+ e.getMessage());
			}
			
		
			return flight;
	}
	
	public static List<Flight> selectFlight(Date d, String dep_city, String arr_city) throws DBException{
		 
	List<Flight> flight=new ArrayList<>();
	
	String selectAllFlights ="SELECT * FROM Flight WHERE departure_date=? AND departure_city =? AND arrival_city=?";
	try(Connection conn = DBStore.getConnection();
			PreparedStatement pst = conn.prepareStatement(selectAllFlights);){
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
	}catch (SQLException | IOException e) {
		
		throw new DBException("Unable to fetch records from flight"+ e.getMessage());
	}
	
		
	return flight;
	}
	
	public static boolean removeFlight(int fno) throws DBException{
		
	 
	String removeflight ="DELETE from Flight WHERE Flight_number=?";
	try( Connection conn = DBStore.getConnection();
		PreparedStatement pst = conn.prepareStatement(removeflight);){
	pst.setInt(1, fno);
	pst.execute();
	conn.commit();
	}catch(SQLException | IOException e) {
		return false;
	}

	
		return true;
	
	}
	public static int updateFlight(Flight f) throws DBException{
		
		int ret =0;
		String insertIntoFlight = "UPDATE Flight SET Arrival_time=?,Arrival_date=?,Departure_time=?,Departure_date=?,Airplane_id=?,Departure_city=?,Arrival_city=? WHERE Flight_number=?";
		try(Connection conn = DBStore.getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoFlight);){
			
			pst.setTime(1,f.getArrival_time());
			pst.setDate(2,f.getArrival_date());
			pst.setTime(3,f.getDeparture_time());
			pst.setDate(4,f.getDeparture_date());
			pst.setInt(5,f.getAirplane_id());
			pst.setString(6,f.getDeparture_city());
			pst.setString(7,f.getArrival_city());
			pst.setInt(8,f.getFlight_number());
			
			
			
			ret =pst.executeUpdate();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to update record in flight"+ e.getMessage());
			}
			
			
			return ret;
		}
}
