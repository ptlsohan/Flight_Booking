package dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import static org.powermock.api.mockito.PowerMockito.*;

import org.powermock.core.classloader.annotations.PowerMockIgnore;
//import static org.;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Passanger;

import dbUtility.DBStore;
import dbUtility.PropertyUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest({PropertyUtil.class,DBStore.class})
@PowerMockIgnore("javax.management.*")
public class PassangerTest {

	@BeforeClass
	public static void init() throws ClassNotFoundException, SQLException, IOException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		p.load(PassangerTest.class.getResourceAsStream("/db_test.properties"));
		String CreateQuery="CREATE TABLE Passanger(\n" + 
				"Passanger_id INT NOT NULL AUTO_INCREMENT,\n" + 
				"username VARCHAR(20),\n" + 
				"FirstName VARCHAR(45) NOT NULL,\n" + 
				"LastName VARCHAR(45) ,\n" + 
				"SSN VARCHAR(9),\n" + 
				"Age INT,\n" + 
				"Street VARCHAR(45) NOT NULL,\n" + 
				"Apartment_number INT NOT NULL,\n" + 
				"City VARCHAR(45) NOT NULL,\n" + 
				"State VARCHAR(45) NOT NULL,\n" + 
				"Zip INT NOT NULL,\n" + 
				"Tel_home VARCHAR(45),\n" + 
				"Tel_office VARCHAR(45),\n" + 
				"Email VARCHAR(45),\n" + 
				"PRIMARY KEY (Passanger_id)\n" + 
				"\n" + 
				");" ;
		when(PropertyUtil.readPropertyFile()).thenReturn(p);
		Connection conn=DBStore.getConnection();
		PreparedStatement createPreparedStatement = conn.prepareStatement(CreateQuery);
		createPreparedStatement.executeUpdate();
	
	
	}
	@Test
	public void test() throws IOException, SQLException {
		Passanger p =new Passanger(null,"Sohan","P","3345",25,"St Charles",1000,"St Charles","IL",12345,"12345","456789","abc@abc.com");
		
		assertEquals(1,PassangerDao.insertPassanger(p));
	}

}
