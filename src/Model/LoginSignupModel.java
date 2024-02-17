package Model;
import java.sql.*;

public class LoginSignupModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static boolean checkUser(String username,String password) {
		String query="Select * from user where username=? and password=? ";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
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
	public static boolean createUser(String name,String username,String email, String password) {
		String query="Insert into user values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1,name);
			ps.setString(2,username);
			ps.setString(3, email);
			ps.setString(4, password);
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
	public static boolean checkAdmin(String username,String password) {
		String query="Select * from admin where username=? and password=? ";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, username);
			ps.setString(2, password);
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
	public static boolean isExist(String username) {
			String query="Select * from user where username=?";
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(query);
				ps.setString(1, username);
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
}
