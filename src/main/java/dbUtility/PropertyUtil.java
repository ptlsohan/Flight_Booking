package dbUtility;

import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {
	public static Properties readPropertyFile() throws IOException {
		Properties p = new Properties();
	//	p.load(new FileReader("classpath:db.properties"));
		//p.load(this.getClass().getResourceAsStream("/db.properties"));
		p.load(PropertyUtil.class.getResourceAsStream("/db.properties"));
		return p;
	}
	public void print() {
		System.out.println(1);
	}
	
}
