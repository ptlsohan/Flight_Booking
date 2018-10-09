package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.User;
import com.dbUtility.DBStore;
import com.exception.DBException;

public class UserDao {
	
	public static int insertUser(User u) throws DBException{
		 
		int ret=0;
			String insertIntoUser = "INSERT INTO User(username, password, usertype) "
			+ "VALUES (?,?,?);";
			try(Connection conn = DBStore.getConnection();	
			PreparedStatement pst = conn.prepareStatement(insertIntoUser);){
			pst.setString(1,u.getUsername());
			pst.setString(2,u.getPassword());
			pst.setString(3,u.getUsertype());
			
			ret=pst.executeUpdate();
			conn.commit();
			}catch (SQLException | IOException e) {
				
				throw new DBException("Unable to insert record in User table"+ e.getMessage());
			}
			
			
			return ret;
	}
	
	
	public static String selectUser(String uname, String pwd, String utype) throws  DBException{
		 
		String u=null;

	String selectUser ="SELECT * FROM User WHERE username=? AND password =? AND usertype=?";
	try(Connection conn = DBStore.getConnection();
	PreparedStatement pst = conn.prepareStatement(selectUser);){
		pst.setString(1, uname);
		pst.setString(2,pwd);
		pst.setString(3, utype);
		ResultSet rs = pst.executeQuery();
		if(rs.next()){
		u= rs.getString("username");
		}
		rs.close();
	}catch (SQLException | IOException e) {
		
		throw new DBException("Unable to fetch record from User table"+ e.getMessage());
	}

	   return u;
	}
}
