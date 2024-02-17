package View;
import Main.GameHub;
import java.util.*;

public class AdminHome {
	public static void displayHome() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------WELCOME ADMIN!!---------->");
		System.out.println("1. Manage Console");
		System.out.println("2. Manage Gamehub Offers");
		System.out.println("3. Modify Console prices");
		System.out.println("4. View Payment history");
		System.out.println("5. Logout");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				ManageConsole mc=new ManageConsole();
				mc.adminCon();
				break;
			case 2:
				Offers.adminOffers();
				break;
			case 3:
				ConsolePrice.manageConsolePrice();
				break;
			case 4:
				Billing.paymentHistory();
				break;
			case 5:
				GameHub.main(null);
				break;
			default:
				System.out.println("Invalid option. Enter correct option");
			}
		}while(choice==0 || choice >5);
		
	}
}
