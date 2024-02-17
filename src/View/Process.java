package View;
import java.util.*;

import Controller.TimeController;

public class Process {
	public static void startGame() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<---------TIME STARTED---------->");
		System.out.println("You started Playing");
		String startTime=TimeController.setStartTime();
		System.out.println("Start time: "+startTime);
		System.out.println("Press 1 to End");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.println("Successfully Ended");
			String endTime=TimeController.setEndTime();
			System.out.println("End time: "+endTime);
			Billing.addBill(startTime, endTime);
			System.out.println("1. View Bill");
			System.out.println("2. Go back");
			int choice;
			do {
				choice=sc.nextInt();
				switch(choice) {
					case 1:
						Billing.displayBill();
						break;
					case 2:
						UserHome.displayHome();
						break;
					default:
						System.out.println("Invalid option Retry");
				}
			}while(choice==0 || choice>2);
		}
	}
}
