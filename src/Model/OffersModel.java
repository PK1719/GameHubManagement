package Model;

import java.sql.*;

public class OffersModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static boolean isExist(String code) {
		String query="Select * from offers where offer_code=?";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, code);
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
	public static boolean addOffer(String code,String desc,int amount) {
		String query="Insert into offers values(?,?,?)";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, code);
			ps.setString(2, desc);
			ps.setInt(3, amount);
			int rowsAffected=ps.executeUpdate();
			if(rowsAffected>0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static ResultSet retrieveOffers() {
		String query="select * from offers";
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
	public static boolean deleteOffer(String code) {
		String query="delete from offers where offer_code=?";
		try {
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, code);
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
		public static int getAmount(String code) {
	        int amount = -1; // Default value if no amount is found
	        try {
	            Statement stmt = conn.createStatement();
	            String query = "SELECT amount FROM offers WHERE offer_code='" + code + "'";
	            ResultSet rs = stmt.executeQuery(query);
	            if (rs.next()) {
	                amount = rs.getInt("amount");
	            }
	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	        }
	        return amount;
	    }
}
