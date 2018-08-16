package controller;

import static org.junit.Assert.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.bean.Flight;

import dao.FlightDao;

@RunWith(PowerMockRunner.class)
@PrepareForTest(FlightDao.class)
public class AddFlightDetailTest {

	@Mock
	HttpServletRequest req;
	@Mock
	HttpServletResponse res;
	@Mock
	RequestDispatcher rd;
	@Before
	public void init() throws SQLException, IOException {
		PowerMockito.mockStatic(FlightDao.class);
		when(FlightDao.insertFlight(new Flight())).thenReturn(1);
		
	}
	
	@Test
	public void test() throws IOException, ServletException {
		when(req.getParameter("fno")).thenReturn("1");
		when(req.getParameter("atime")).thenReturn("10:30:34");
		when(req.getParameter("dtime")).thenReturn("10:30:34");
		when(req.getParameter("adate")).thenReturn("2018-08-19");
		when(req.getParameter("ddate")).thenReturn("2018-08-19");
		when(req.getParameter("air_id")).thenReturn("2");
		when(req.getParameter("a_city")).thenReturn("chicago");
		when(req.getParameter("d_city")).thenReturn("nyc");
		when(req.getRequestDispatcher(anyString())).thenReturn(rd);
		AddFlightDetail a= new AddFlightDetail();
		a.doPost(req, res);
		verify(req,times(1)).getRequestDispatcher("listFlight");
		
	}

}
