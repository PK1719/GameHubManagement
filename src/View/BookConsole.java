package View;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*; 

import Controller.BookConsoleController;
import Controller.ConsoleController;

public class BookConsole {
	public static String finalId;
	public static void bookConsole() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<------------BOOK CONSOLE------------>");
		System.out.println("1. PC");
		System.out.println("2. PS4");
		System.out.println("3. PS5");
		System.out.println("4. Go back");
		System.out.println("Which console you want to play?");
		int ch;
		do {
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				bookPC();
				break;
			case 2:
				bookPS4();
				break;
			case 3:
				bookPS5();
				break;
			case 4:
				UserHome.displayHome();
				break;
			default:
				System.out.println("Invalid choice. Retry");
			}
		}while(ch<0 || ch>4);
		
	}
	public static void bookPC() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PC-ID   Availability");
		ResultSet rs=ConsoleController.getPC();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Enter the PC ID:");
		String id=sc.next();
		if(!BookConsoleController.isPC(id)) {
			System.out.println("Console ID is invalid.");
			System.out.println("Press 1 to go back");
			int ch=sc.nextInt();
			if(ch==1) {
				bookConsole();
			}
		}
		else {
			if(!BookConsoleController.checkBookPc(id)) {
				System.out.println("Something went wrong");
				System.out.println("Press 1 to go back");
				int ch=sc.nextInt();
				if(ch==1) {
					bookConsole();
				}
			}
			else {
				System.out.println("Booked Successfully.");
				finalId=id;
				afterBooked(id);
			}
		}
	}
	public static void afterBooked(String id) {
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Start Gaming");
		System.out.println("2. Go back (If you go back the console will be unbooked)");
		int ch;
		do {
			ch=sc.nextInt();
			switch(ch) {
			case 1:
				Process.startGame();
				break;
			case 2:
				BookConsoleController.unbookConsole(id);
				bookConsole();
				break;
			default:
				System.out.println("Invalid choice. Retry");
			}
		}while(ch<0 || ch>4);
	}
	public static void bookPS4() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PS4-ID   Availability");
		ResultSet rs=ConsoleController.getPs4();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter the PS4 ID:");
		String id=sc.next();
		if(!BookConsoleController.isPS4(id)) {
			System.out.println("Console ID is invalid.");
			System.out.println("Press 1 to go back");
			int ch=sc.nextInt();
			if(ch==1) {
				bookConsole();
			}
		}
		else {
			if(!BookConsoleController.checkBookPc(id)) {
				System.out.println("Something went wrong");
				System.out.println("Press 1 to go back");
				int ch=sc.nextInt();
				if(ch==1) {
					bookConsole();
				}
			}
			else {
				System.out.println("Booked Successfully.");
				finalId=id;
				afterBooked(id);
			}
		}
	}
	public static void bookPS5() {
		Scanner sc=new Scanner(System.in);
		System.out.println("PS5-ID   Availability");
		ResultSet rs=ConsoleController.getPs5();
		try {
			while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("availability"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Enter the PS5 ID:");
		String id=sc.next();
		if(!BookConsoleController.isPS5(id)) {
			System.out.println("Console ID is invalid.");
			System.out.println("Press 1 to go back");
			int ch=sc.nextInt();
			if(ch==1) {
				bookConsole();
			}
		}
		else {
			if(!BookConsoleController.checkBookPc(id)) {
				System.out.println("Something went wrong");
				System.out.println("Press 1 to go back");
				int ch=sc.nextInt();
				if(ch==1) {
					bookConsole();
				}
			}
			else {
				System.out.println("Booked Successfully.");
				finalId=id;
				afterBooked(id);
			}
		}
	
	}
}
