package com.dao;
import java.io.*;
import java.sql.*;


import com.bean.Airplane;
import com.dbUtility.DBStore;
import com.exception.DBException;


public class AirplaneDao {
	
	
	
	public static void insertAirplane(Airplane a) throws DBException {
			
			String insertIntoAirplane = "INSERT INTO Airplane(Airplane_id, Producer, Type) "
				+ "VALUES (?,?,?);";
			try( Connection conn = DBStore.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);){
			pst.setInt(1,a.getAirplane_id());
			pst.setString(2,a.getProducer());
			pst.setInt(3,a.getType());
			
			pst.execute();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to insert record in Airplane");
			}
			
			}
	


}
