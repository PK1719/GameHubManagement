package View;
import java.util.*;

import Controller.ConsoleController;
import Main.GameHub;
import java.sql.*;

public class ManageConsole {
	public static void adminCon() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<--------MANAGE CONSOLE-------->");
		System.out.println("1. Add Console");
		System.out.println("2. Remove Console");
		System.out.println("3. Go back");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				addConsoles();
				break;
			case 2:
				removeConsole();
				break;
			case 3:
				AdminHome.displayHome();
				break;
			default:
				System.out.println("Invalid option. Enter correct option");
			}
		}while(choice==0 || choice>3);
	}
	public static void addConsoles() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------ADD CONSOLE---------->");
		System.out.println("Enter the Console id:(3 letters)");
		String consoleID=sc.next();
		System.out.println("Select the Console type:");
		System.out.println("1. PS4");
		System.out.println("2. PS5");
		System.out.println("3. PC");
		int choice;
		String type="";
		do {
			choice=sc.nextInt();
			if(choice==1)
				type="PS4";
			else if(choice==2)
				type="PS5";
			else if(choice==3)
				type="PC";
			else
				System.out.println("Enter a valid option");
		}while(choice !=0 && choice>3);
		if(ConsoleController.addConsole(consoleID, type)){
			System.out.println("Console added successfully");
			System.out.println("Press 1 to go back");
			int ch=sc.nextInt();
			if(ch==1) {
				ManageConsole.adminCon();
			}
		}
	}
	public static void removeConsole() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Console ID   	Console type");
		ResultSet rs=ConsoleController.getConsoles();
			try {
				while(rs.next()) {
				System.out.println(rs.getString("consoleid")+"		"+rs.getString("type"));
				}
				System.out.println("1. Remove Console");
				System.out.println("2. Go Back");
				int choice;
				do {
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						System.out.println("Enter the Console Id to remove:");
						String id=sc.next();
						if(!ConsoleController.isExist(id)) {
							System.out.println("Console id either invalid or doesn't exist");
						}
						else {
							if(ConsoleController.deleteConsole(id)) {
								System.out.println("Successfully deleted");
							}
						}
						System.out.println("Press 1 to go back");
						int ch=sc.nextInt();
						if(ch==1) {
							adminCon();
						}
						break;
					case 2:
						adminCon();
						break;
					default:
						System.out.println("Invalid option. Enter correct option");
					}
				}while(choice==0 || choice>3);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}

