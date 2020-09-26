package utility;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionManager {
	public static Connection getConnection() throws ClassNotFoundException, SQLException, IOException {
		
		Properties p = loadPropertiesFile();
		Connection con  = null;
		Class.forName(p.getProperty("driver"));
		con = DriverManager.getConnection(p.getProperty("url"));
		return con;
		
	}
	

	private static Properties loadPropertiesFile() throws IOException {
	
		
		Properties p = new Properties();
		
		InputStream in = ConnectionManager.class.getClassLoader().getResourceAsStream("jdbc.properties"); 
		p.load(in);
		in.close();
		return p;
		}
}
