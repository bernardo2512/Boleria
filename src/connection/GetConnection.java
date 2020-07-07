package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class GetConnection {

	public Connection getConnection () throws Exception {
		Connection conn = null;

		try {
			
			String url = "jdbc:postgresql://localhost/HelenaCakes";
			String username ="postgres";
			String password = "Bernardo@1";

			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, username, password); 

			System.out.println("Connected to database !");
			return conn;	
		} catch(Exception e) {
			System.out.println(e);		
		}

		return null;
	}
}
