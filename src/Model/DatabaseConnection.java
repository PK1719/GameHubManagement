package Model;
import java.sql.*;

public class DatabaseConnection {
		public static Connection createConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gamehub","root","Jaya@1105");
				return conn;
			}
			catch(Exception e) {
				System.out.println(e.toString());
			}
			return null;
		}
}
