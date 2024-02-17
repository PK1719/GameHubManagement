package View;

import java.sql.ResultSet;
import java.util.Scanner;

import Controller.ConsolePriceController;
import Controller.OfferController;

public class ConsolePrice {
	public static void manageConsolePrice() {
		System.out.println("<---------MANAGE CONSOLE PRICES-------->");
		Scanner sc=new Scanner(System.in);
		ResultSet rs=ConsolePriceController.getDetails();
		System.out.println("Console Cost/hr");
		try {
				while(rs.next()) {
					String type=rs.getString("type");
					String cost=rs.getString("price");
					System.out.println(type+"   	  "+cost);
				}
				System.out.println("1.Modify console price");
				System.out.println("2. Go back");
				int c=sc.nextInt();
				if(c==1) {
					System.out.println("Enter the console name");
					String name=sc.next();
					if(!ConsolePriceController.consoleExist(name)) {
						System.out.println("Console doesn't exist");
						System.out.println("Press 1 to go back");
						int ch=sc.nextInt();
						if(ch==1) {
							manageConsolePrice();
						}
					}
					else {
						System.out.println("Enter the new price:");
						int newPrice=sc.nextInt();
						if(ConsolePriceController.changePrice(name, newPrice)) {
							System.out.println("Updated Successfully");
							System.out.println("Press 1 to go back");
							int ch=sc.nextInt();
							if(ch==1) {
								manageConsolePrice();
							}
						}
						else {
							System.out.println("There seems to be an error");
							System.out.println("Press 1 to go retry");
							int ch=sc.nextInt();
							if(ch==1) {
								ConsolePrice.manageConsolePrice();
							}
						}
					}
				}
				else if(c==2) {
					AdminHome.displayHome();
				}
		}
		catch(Exception e) {
			
		}
	}
}
