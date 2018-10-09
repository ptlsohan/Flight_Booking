package com.dao;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.bean.Airplane;
import com.dbUtility.DBStore;
import com.exception.DBException;


public class AirplaneDao {
	
	
	
	public static int insertAirplane(Airplane a) throws DBException {
			int ret=-1;
			String insertIntoAirplane = "INSERT INTO Airplane(Airplane_id, Producer, Type) "
				+ "VALUES (?,?,?);";
			try( Connection conn = DBStore.getConnection();
			
			PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);){
			pst.setInt(1,a.getAirplane_id());
			pst.setString(2,a.getProducer());
			pst.setInt(3,a.getType());
			
			ret=pst.executeUpdate();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to insert record in Airplane");
			}
			return ret;
			
			}
	
	
	public static Airplane getAirplane(int aid) throws  DBException{
		

		 String getAirplane ="SELECT * FROM Airplane WHERE Airplane_id=?";
		 Airplane airplane=null;
			try( Connection conn = DBStore.getConnection();
					PreparedStatement pst = conn.prepareStatement(getAirplane);){
			pst.setInt(1,aid);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				int airId= rs.getInt("Airplane_id");
				String p= rs.getString("Producer");
				
				int type= rs.getInt("Type");
				
				airplane = new Airplane(airId,p,type);
			}
			

			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to fetch record from Airplane"+ e.getMessage());
			}
			
			
			return airplane;
	}
	
	
	public static List<Airplane> selectAllAirplane() throws DBException{
		 
		List<Airplane> airplane=new ArrayList<>();
		 
			String selectAllAirplane ="select * from Airplane";
			try(Connection conn = DBStore.getConnection();
					PreparedStatement pst = conn.prepareStatement(selectAllAirplane);
			ResultSet rs = pst.executeQuery();){
			
			while(rs.next())
			{
				int airId= rs.getInt("Airplane_id");
				String p= rs.getString("Producer");
				
				int type= rs.getInt("Type");
				
				Airplane newAirplane = new Airplane(airId,p,type);
				airplane.add(newAirplane);
			}
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to fetch records from Airplane"+ e.getMessage());
			}
			
		
			return airplane;
	}
	
	
	
	public static boolean removeAirplane(int aid) throws DBException{
		
	 
	String removeAirplane ="DELETE from Airplane WHERE Airplane_id=?";
	try( Connection conn = DBStore.getConnection();
		PreparedStatement pst = conn.prepareStatement(removeAirplane);){
	pst.setInt(1, aid);
	pst.execute();
	conn.commit();
	}catch(SQLException | IOException e) {
		return false;
	}

	
		return true;
	
	}
	public static int updateAirplane(Airplane a) throws DBException{
		
		int ret =0;
		String insertIntoAirplane = "UPDATE Airplane SET Airplane_id=?,Producer=?,Type=? WHERE Airplane_id=?";
		try(Connection conn = DBStore.getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);){
			
			pst.setInt(1,a.getAirplane_id());
			
			pst.setString(2,a.getProducer());
			pst.setInt(3,a.getType());
			pst.setInt(4,a.getAirplane_id());
			
			
			
			ret =pst.executeUpdate();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to update record in Airplane"+ e.getMessage());
			}
			
			
			return ret;
		}
	


}
