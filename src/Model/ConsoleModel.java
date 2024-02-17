package Model;
import java.sql.*;

public class ConsoleModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static boolean consoleAdd(String consoleID,String type) {
		String avail="yes";
		String query="insert into console values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, consoleID);
			ps.setString(2, type);
			ps.setString(3, avail);
			int rowsAffected=ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static ResultSet retrieveConsoles() {
		String query="Select * from console";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static boolean checkId(String id) {
		String query="Select * from console where consoleid=?";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				return true;
			}
			else {
				return false;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public static boolean removeConsole(String id) {
		String query="delete from console where consoleid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, id);
			int rowsAffected=ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static ResultSet retrievePc() {
		String query="Select * from console where type='PC'";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet retrievePs5() {
		String query="Select * from console where type='PS5'";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet retrievePs4() {
		String query="Select * from console where type='PS4'";
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
