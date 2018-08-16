package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bean.Passanger;

import dbUtility.DBStore;

public class PassangerDao {
	public static int insertPassanger(Passanger p) throws IOException, SQLException{

		
		 Connection conn = DBStore.getConnection();
		 int ret=0;
		 System.out.println("inserting");
			String insertIntoPassanger = "INSERT INTO Passanger(username,firstName, lastName, ssn, age, street,apartment_number, city, state, zip, tel_home, tel_office, email) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pst = conn.prepareStatement(insertIntoPassanger);
			pst.setString(1,p.getUsername());
			 System.out.println(p.getUsername());
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
			System.out.println("executing");
			ret=pst.executeUpdate();
			
			
			System.out.println("commit");
			pst.close();
			conn.commit();
			
			System.out.println("return");
			return ret;
			}
	
	public static int getPassangerId(String uname) throws SQLException, IOException{
		 
		
		Connection conn = DBStore.getConnection();
		ResultSet rs;
		int u = 0;
	String selectUser ="SELECT Passanger_id FROM Passanger WHERE username=?";
	try(
	PreparedStatement pst = conn.prepareStatement(selectUser);){
		pst.setString(1, uname);
		rs = pst.executeQuery();
		if(rs.next()){
		u= rs.getInt("Passanger_id");
		}
	}
	
	rs.close();
	   return u;
	}
}
