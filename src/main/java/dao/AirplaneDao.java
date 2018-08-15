package dao;
import java.io.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import com.bean.Airplane;
import com.bean.Flight;
import com.bean.Passanger;
import com.bean.User;

import dbUtility.DBStore;


public class AirplaneDao {
	
	
	
	public static void insertAirplane(Airplane a) throws SQLException, IOException{
			
			 Connection conn = DBStore.getConnection();
			String insertIntoAirplane = "INSERT INTO Airplane(Airplane_id, Producer, Type) "
			+ "VALUES (?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);
			pst.setInt(1,a.getAirplane_id());
			pst.setString(2,a.getProducer());
			pst.setInt(3,a.getType());
			
			pst.execute();
			conn.commit();
			pst.close();
			conn.close();
			}
	


}
