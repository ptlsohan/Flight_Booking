package dbUtility;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class DBStoreTest {
	@Mock PropertyUtil obj;
	@Before
	public void init() throws IOException {
		MockitoAnnotations.initMocks(this);
		Properties p = new Properties();
		
		p.load(PropertyUtil.class.getResourceAsStream("/db_test.properties"));
	when(obj.readPropertyFile()).thenReturn(p);
	}
	
	@Test
	public void test() throws FileNotFoundException, SQLException, IOException, ClassNotFoundException {
		//assertNotNull(DBStore.getConnection());
		
	}

}
