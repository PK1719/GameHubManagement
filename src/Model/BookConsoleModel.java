package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookConsoleModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static boolean bookedPc(String id) {
		String query="update console set availability='no' where consoleid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, id);
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
	public static boolean unBook(String id) {
		String query="update console set availability='yes' where consoleid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, id);
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
	public static boolean checkPC(String id) {
		String query="Select * from console where consoleid=? and type like 'PC' ";
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
	public static boolean checkPS4(String id) {
		String query="Select * from console where consoleid=? and type like 'PS4' ";
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
	public static boolean checkPS5(String id) {
		String query="Select * from console where consoleid=? and type like 'PS5' ";
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
}
