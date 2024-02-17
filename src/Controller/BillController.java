package Controller;

import Model.BillModel;
import java.sql.*;
import Model.ConsolePriceModel;
import View.BookConsole;

public class BillController {
	 public static double calculateAmount(int seconds) {
	        double hours = seconds / 3600.0; 
	        double chargePerHour = getConsoleCost();
	        double amount = hours * chargePerHour;
	        return amount;
	    }
	 public static int getConsoleCost() {
		 return ConsolePriceModel.getCost(BookConsole.finalId);
	 }
	 public static boolean createBill(String bid,String user,double cost) {
		 if(BillModel.addBill(bid,user,cost)) {
			 return true;
		 }
			 return false;
	 }
	 public static boolean clearBill(String username) {
		 if(BillModel.deleteBill(username)) {
			 return true;
		 }
		 return false;
	 }
	 public static boolean billExist(String user) {
		 return BillModel.isBillExist(user);
	 }
	 public static ResultSet retrieveBill(String user) {
		 return BillModel.getBill(user);
	 }
	 
	 public static boolean addPayment(String user,double cost,String billid,String payid) {
		 return BillModel.insertPayment(user,cost,billid,payid);
	 }
	 public static double addDiscount(String billid,int discount) {
		 double cost=getBillAmount(billid);
		 double discountAmount = (cost * discount) / 100.0;
         return (cost-discountAmount)<0?0.0:(cost-discountAmount);
	 }
	 public static double getBillAmount(String billid) {
		 return BillModel.getCost(billid);
	 }
	 public static boolean changeCost(String billid,double cost) {
		 return BillModel.updateCost(billid,cost);
	 }
	 public static ResultSet getPayments() {
		 return BillModel.retrievePayments();
	 }
}
