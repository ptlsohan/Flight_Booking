package dbUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBStore {
 BasicDataSource ds;
static DBStore dbs;
Properties p;
PropertyUtil obj= new PropertyUtil();
	public DBStore() throws IOException {
		p = obj.readPropertyFile();
		ds= new BasicDataSource();
		ds.setDriverClassName(p.getProperty("DB_Driver"));
		ds.setUrl(p.getProperty("DB_URL"));
		ds.setPassword(p.getProperty("DB_Password"));
		ds.setUsername(p.getProperty("DB_User"));
		ds.setMaxTotal(200);//load testing get connection :(2sec) close the connection
		ds.setMaxIdle(20);
		ds.setMaxOpenPreparedStatements(180);
		ds.setMinIdle(20);
		ds.setMaxWaitMillis(2000);//2sec
		//Class.forName("com.mysql.jdbc.Driver");
		//ds.setEnableAutoCommitOnReturn(false);
		// Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","Qwertyuiop1942");
		 //conn.setAutoCommit(false);
		ds.setDefaultAutoCommit(false);
	
	}



		
	public static  Connection getConnection() throws IOException, SQLException {
		if(dbs==null) {
			dbs=new DBStore();
		}
		// Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/db?autoReconnect=true&useSSL=false","root","Qwertyuiop1942");
		 //conn.setAutoCommit(false);
		return dbs.ds.getConnection();
		// return conn;
	}
	
}
