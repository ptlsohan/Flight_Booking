package DBUtility;

import java.sql.SQLException;

import com.bean.Passanger;

public class test {

	public static void main(String[] args) {
		Passanger p =new Passanger(1,"Sohan","patil","12345",25,"King dr",19,"chicago","IL",12234,"1234567","12345678","abc");
		try {
			SQLUtility.insertPassanger(p);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
