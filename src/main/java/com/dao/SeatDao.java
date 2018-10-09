package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.bean.Seat;
import com.dbUtility.DBStore;
import com.exception.DBException;

public class SeatDao {
	public static Seat getSeats(int fnum) throws DBException {
		 
		 int Fseat=0,Bseat=0,Eseat=0,version=-1;
		 Seat s=null;
		 String selectId ="select * from AvailableSeat WHERE Flight_number=?";
		 try(Connection conn = DBStore.getConnection();
				 PreparedStatement pst = conn.prepareStatement(selectId);){
					
					pst.setInt(1,fnum);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						Eseat= rs.getInt("Economy_seat");
						Fseat= rs.getInt("First_seat");
						Bseat= rs.getInt("Business_seat");
						version = rs.getInt("version");
						s=new Seat(fnum,Eseat,Fseat,Bseat,version);
					}
					rs.close();
					
					
		 }catch (SQLException | IOException e) {
				
				throw new DBException("Unable to fetch record from Seat"+ e.getMessage());
			}
		 return s;
	 }
	public static int insertSeat(Seat s) throws DBException{
		int ret=0;
		 
		String insertIntoAirplane = "INSERT INTO AvailableSeat(Flight_number,Economy_seat,First_seat,Business_seat) "
		+ "VALUES (?,?,?,?);";
		try(Connection conn = DBStore.getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoAirplane);){
		pst.setInt(1,s.getFlight_number());
		pst.setInt(2,s.getEconomy_seat());
		pst.setInt(3,s.getFirst_seat());
		pst.setInt(4,s.getBusiness_seat());
		
		
		ret=pst.executeUpdate();
		conn.commit();
		}catch (SQLException | IOException e) {
			
			throw new DBException("Unable to insert record in Seat"+ e.getMessage());
		}
		return ret;
	}
	public static int updateSeat(Seat s) throws DBException{
		
		int ret =0;
		int v= s.getVersion()+1;
		String insertIntoSeat = "UPDATE AvailableSeat SET Economy_seat=?,First_seat=?,Business_seat=?,version=? WHERE Flight_number=? and version=?";
		try(Connection conn = DBStore.getConnection();
				PreparedStatement pst = conn.prepareStatement(insertIntoSeat);){
			
			pst.setInt(1,s.getEconomy_seat());
			pst.setInt(2,s.getFirst_seat());
			pst.setInt(3,s.getBusiness_seat());
			pst.setInt(4, v);
			pst.setInt(5,s.getFlight_number());
			pst.setInt(6, s.getVersion());
			
			
			ret =pst.executeUpdate();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to update record"+ e.getMessage());
			}
		System.out.println("update status"+ret);
			
			
			return ret;
		}
	public static boolean removeSeat(int fno) throws IOException, SQLException{
		
	 
	String removeSeat ="DELETE from AvailableSeat WHERE Flight_number=?";
	try( Connection conn = DBStore.getConnection();
			PreparedStatement pst = conn.prepareStatement(removeSeat);){
	pst.setInt(1, fno);
	pst.execute();
	conn.commit();
	}catch(SQLException e) {
		return false;
	}

	
		return true;
	
	}
	
}
