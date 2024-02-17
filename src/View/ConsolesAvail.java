package View;
import java.util.*;

import Controller.ConsoleController;

import java.sql.*;

public class ConsolesAvail {
	public static void userCon() {
		Scanner sc=new Scanner(System.in);
		System.out.println("1. PC");
		System.out.println("2. PS4");
		System.out.println("3. PS5");
		System.out.println("4. Go back");
		System.out.println("Choose the console:");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				pcDisplay();
				break;
			case 2:
				ps4Display();
				break;
			case 3:
				ps5Display();
				break;
			case 4:
				UserHome.displayHome();
			default:
				System.out.println("Invalid option. Enter correct option");
			}
		}while(choice==0 || choice>4);
	}
	public static void pcDisplay() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PC-ID   Availability");
		ResultSet rs=ConsoleController.getPC();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
			System.out.println("1. Book a console");
			System.out.println("2. Go back");
			int ch=sc.nextInt();
			if(ch==1) {
				BookConsole.bookConsole();
			}
			else if(ch==2) {
				userCon();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ps4Display() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PS4-ID   Availability");
		ResultSet rs=ConsoleController.getPs4();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
			System.out.println("1. Book a console");
			System.out.println("2. Go back");
			int ch=sc.nextInt();
			if(ch==1) {
				BookConsole.bookConsole();
			}
			else if(ch==2) {
				userCon();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ps5Display() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PS5-ID   Availability");
		ResultSet rs=ConsoleController.getPs5();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
			System.out.println("1. Book a console");
			System.out.println("2. Go back");
			int ch=sc.nextInt();
			if(ch==1) {
				BookConsole.bookConsole();
			}
			else if(ch==2) {
				userCon();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
