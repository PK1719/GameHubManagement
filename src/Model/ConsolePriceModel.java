package Model;
import java.sql.*;
public class ConsolePriceModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static ResultSet getConsolePrices() {
		String query="select * from consoleprice";
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
	public static boolean isExist(String name) {
		String query="Select * from consoleprice where type=?";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, name);
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
	public static boolean modifyPrice(String name,int cost) {
		String query="update consoleprice set price=? where type=?";
			try {
				PreparedStatement ps=conn.prepareStatement(query);
				ps.setInt(1, cost);
				ps.setString(2, name);
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
	public static String getType(String id) {
		String query="select type from console where consoleid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getString("type");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
	public static int getCost(String id) {
		String type=getType(id);
		String query="select price from consoleprice where type=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, type);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				return rs.getInt("price");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
}
