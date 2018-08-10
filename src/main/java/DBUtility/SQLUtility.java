package DBUtility;
import java.io.IOException;
import java.io.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.bean.Airplane;
import com.bean.Flight;
import com.bean.Passanger;


public class SQLUtility {

	
	public static void insertPassanger(Passanger p) throws SQLException{
		Connection conn =null;	
		try{
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn =conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","Qwertyuiop1942");
			String insertIntoPassanger = "INSERT INTO Passanger(passanger_id,firstName, lastName, ssn, age, street,apartment_number, city, state, zip, tel_home, tel_office, email) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoPassanger);
			pst.setInt(1,p.getPassanger_id());
			pst.setString(2,p.getFirstName());
			pst.setString(3,p.getLastName());
			pst.setString(4,p.getSsn());
			pst.setInt(5,p.getAge());
			pst.setString(6,p.getStreet());
			pst.setInt(7,p.getApartment_number());
			pst.setString(8,p.getCity());
			pst.setString(9,p.getState());
			pst.setInt(10,p.getZip());
			pst.setString(11,p.getTel_home());
			pst.setString(12,p.getTel_office());
			pst.setString(13,p.getEmail());
			pst.execute();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			conn.close();
			}
	
	public static void insertAirplane(Airplane a) throws SQLException{
		Connection conn =null;	
		try{
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn =conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","Qwertyuiop1942");
			String insertIntoAirplane = "INSERT INTO Passanger((airplane_id, producer, type) "
			+ "VALUES (?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);
			pst.setInt(1,a.getAirplane_id());
			pst.setString(2,a.getProducer());
			pst.setInt(3,a.getType());
			
			pst.execute();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			conn.close();
			}
	public static void insertFlight(Flight f) throws SQLException{
		Connection conn =null;	
		try{
		
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn =conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","Qwertyuiop1942");
			String insertIntoPassanger = "INSERT INTO Flight(flight_number, arrival_time, arrival_date, departure_time,departure_date, destination, airplane_id, departure_city, arrival_city) "
			+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoPassanger);
			pst.setInt(1,f.getFlight_number());
			pst.setTime(2,f.getArrival_time());
			pst.setDate(3,f.getArrival_date());
			pst.setTime(4,f.getDeparture_time());
			pst.setDate(5,f.getDeparture_date());
			pst.setInt(6,f.getAirplane_id());
			pst.setString(7,f.getDeparture_city());
			pst.setString(8,f.getArrival_city());
			
			
			
			pst.execute();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			conn.close();
			}

}
