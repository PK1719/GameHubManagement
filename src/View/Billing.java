package View;
import java.util.*; 
import Controller.BillController;
import Controller.OfferController;

import java.sql.*;

import Controller.TimeController;

public class Billing {
	private static double fcost;
	private static String BillID;
	private static boolean couponApplied=false;
	public static void addBill(String st,String et)	 {
		int playedtime=TimeController.calculateTime(st, et);
		double cost=BillController.calculateAmount(playedtime);
		String formattedNumber = String.format("%.2f", cost);
		cost=Double.parseDouble(formattedNumber);
		String billId=generateBillId();
		BillController.createBill(billId,Login.username,cost);
		fcost=cost;
		BillID=billId;
	}
	public static void displayBill() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<------------BILL------------->");
	    if(!BillController.billExist(Login.username)) {
	    	System.out.println("No Current Bills");
			System.out.println("1. Go back");
	    	int choice;
			do {
				choice=sc.nextInt();
				switch(choice) {
					case 1:
						UserHome.displayHome();
						break;
					default:
						System.out.println("Invalid option Retry");
				}
			}while(choice==0 || choice>1);
	    }
	    else {
	    	ResultSet rs=BillController.retrieveBill(Login.username);
	    	System.out.println("Bill-ID		UserName	Cost");
				try {
					while (rs.next()) {
						String billId;
						billId = rs.getString("billid");
						String username = rs.getString("cust_name");
						double cost = rs.getDouble("cost");
						System.out.println(billId+"		  "+username+"		"+cost);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			System.out.println("1. Pay Bill");
			System.out.println("2. Add Coupon Code");
			System.out.println("3. Go back");
			int choice;
			do {
				choice=sc.nextInt();
				switch(choice) {
					case 1:
						payBill();
						break;
					case 2:
						discount();
						break;
					case 3:
						UserHome.displayHome();
						break;
					default:
						System.out.println("Invalid option Retry");
				}
			}while(choice==0 || choice>3);
	    }
	}
	private static String generateBillId() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 3);
        return uuid.toUpperCase();
    }
	private static String generatePaymentId() {
        String uuid = UUID.randomUUID().toString().replace("-", "").substring(0, 5);
        return uuid.toUpperCase();
    }
	public static void payBill() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------PAYMENT----------->");
		System.out.println("1.Send Payment");
		System.out.println("2. Go Back");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					if(BillController.addPayment(Login.username,fcost,BillID,generatePaymentId())){
						System.out.println("Bill Successfully paid");
						System.out.println("Press 1 to go back");
						int ch=sc.nextInt();
						if(ch==1) {
							UserHome.displayHome();
						}
					}
					break;
				case 2:
					displayBill();
					break;
				default:
					System.out.println("Invalid option Retry");
			}
		}while(choice==0 || choice>2);	
	}
	public static void discount() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<----------DISCOUNT----------->");
		System.out.println("1. Coupon code");
		System.out.println("2. Go Back");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
				case 1:
					System.out.println("Enter Coupon Code:");
					String code;
					do {
						code=sc.next();
					}while(code.length()!=5);
					if(!OfferController.offerExist(code)) {
						System.out.println("Coupon code doesn't exist");
						int ch=sc.nextInt();
						if(ch==1) {
							discount();
						}
					}
					else {
						int disc=OfferController.getDiscount(code);
						if(!couponApplied) {
							double totalCost=BillController.addDiscount(BillID,disc);
							if(BillController.changeCost(BillID,totalCost)){
								System.out.println("Coupon successfully applied");
								couponApplied=true;
								displayBill();
							}							
						}
						else {
							System.out.println("Already coupon applied");
							displayBill();
						}
					}
					break;
				case 2:
					displayBill();
					break;
				default:
					System.out.println("Invalid option Retry");
			}
		}while(choice==0 || choice>2);
	}
	public static void paymentHistory() {
		Scanner sc=new Scanner(System.in);
		ResultSet rs=BillController.getPayments();
		System.out.println("Payment-ID       BillID      Username       Amount");
		try {
			int flag=0;
				while(rs.next()) {
					String code=rs.getString("paymentid");
					String desc=rs.getString("billid");
					String user=rs.getString("username");
					int amount=rs.getInt("cost");
					System.out.println(code+"	   	  "+desc+"	     "+user+"		 "+amount);
					flag=1;
				}				
				if(flag==0) {
					System.out.println("No Payments  currently.");
					System.out.println("Press 1 to go back");
					int c=sc.nextInt();
					if(c==1) {
						UserHome.displayHome();
					}					
				}
				else {
					System.out.println();
					System.out.println("Press 1 to go back");
					int c=sc.nextInt();
					if(c==1) {
						AdminHome.displayHome();
					}
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
	}
}
