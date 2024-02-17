package View;
import Main.GameHub; 
import java.util.*;
import View.Billing;
import Controller.BillController;

public class UserHome {
	public static void displayHome() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------WELCOME PLAYER!!---------->");
		System.out.println("1. View the consoles available");
		System.out.println("2. Book a console");
		System.out.println("3. View the Offers");
		System.out.println("4. View the bill");
		System.out.println("5. Logout");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				ConsolesAvail.userCon();
				break;
			case 2:
				BookConsole.bookConsole();
				break;
			case 3:	
				Offers.userOffers();
				break;	
			case 4:
				Billing.displayBill();
				break;
			case 5:
				BillController.clearBill(Login.username);
				GameHub gh=new GameHub();
				gh.main(null);
				break;
			default:
				System.out.println("Invalid option. Enter correct option");
			}
		}while(choice==0 || choice >5);
		
	}
}
