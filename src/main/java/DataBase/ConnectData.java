package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectData {
	public static Connection getConnect() {
		Connection con = null;
		try {

			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/articles?useLegacyDatetimeCode=false&serverTimezone=Europe/Paris";
			String user = "root";
			String pass = "krystal141198";
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void closeConnect(Connection c) {
		try {
			if(c != null)
				c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
