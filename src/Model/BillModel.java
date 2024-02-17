package Model;

import java.sql.*;

public class BillModel {
	private static DatabaseConnection db=new DatabaseConnection();
	private static Connection conn=db.createConnection();
	public static boolean addBill(String bid,String name,double cost) {
		String query="Insert into bill values(?,?,?)";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1, bid);
			ps.setString(2, name);
			ps.setDouble(3, cost);
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
	public static boolean deleteBill(String user) {
		String query = "DELETE FROM bill where cust_name=?";
		PreparedStatement ps;
		 try {
			 ps=conn.prepareStatement(query);
				ps.setString(1, user);
				int rowsAffected=ps.executeUpdate();
				if(rowsAffected>0) {
					return true;
				}
				else {
					return false;
				}
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Return false if an exception occurs during deletion
	            return false;
	        }
	}
	public static boolean isBillExist(String user) {
		 Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT COUNT(*) FROM bill where cust_name='"+user+"'");
			rs.next();
			int rowCount = rs.getInt(1);
			if(rowCount==0) {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	public static ResultSet getBill(String user) {
		String query="select * from bill where cust_name='"+user+"'";
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
	public static boolean insertPayment(String user,double cost,String billid,String payid) {
		String query="Insert into payment values(?,?,?,?)";
		PreparedStatement ps;
		try {
			ps=conn.prepareStatement(query);
			ps.setString(1,payid);
			ps.setString(2,billid);
			ps.setString(3, user);
			ps.setDouble(4, cost);
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
	public static double getCost(String billId) {
        double cost = -1.0; // Default value if no cost is found
        try {
            Statement stmt = conn.createStatement();
            String query = "SELECT cost FROM bill WHERE billid='" + billId + "'";
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                cost = rs.getDouble("cost");
            }
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle exception
        }
        return cost;
    }
	 public static boolean updateCost(String billId, double cost) {
	        try {
	            String query = "UPDATE bill SET cost=? WHERE billid=?";
	            PreparedStatement pstmt = conn.prepareStatement(query);
	            pstmt.setDouble(1, cost);
	            pstmt.setString(2, billId);
	            int rowsUpdated = pstmt.executeUpdate();
	            pstmt.close();
	            return rowsUpdated > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            // Handle exception
	            return false;
	        }
	    }
	 public static ResultSet retrievePayments() {
		 String query="select * from payment";
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
