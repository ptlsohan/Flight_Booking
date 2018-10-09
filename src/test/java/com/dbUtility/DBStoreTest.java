package com.dbUtility;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.sql.SQLException;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.dbUtility.DBStore;
import com.dbUtility.PropertyUtil;


@RunWith(PowerMockRunner.class)
@PrepareForTest(PropertyUtil.class)
public class DBStoreTest {
	@Mock PropertyUtil obj;
	@Before
	public void init() throws IOException {
		PowerMockito.mockStatic(PropertyUtil.class);
		Properties p = new Properties();
		
		p.load(this.getClass().getResourceAsStream("/db_test.properties"));
	when(PropertyUtil.readPropertyFile()).thenReturn(p);
	}
	
	@Test
	public void test() throws FileNotFoundException, SQLException, IOException, ClassNotFoundException {

		assertNotNull(DBStore.getConnection());
		
	}

}
