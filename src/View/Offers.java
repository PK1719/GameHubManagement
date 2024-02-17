package View;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import Controller.OfferController;
import Main.GameHub;
public class Offers {
	public static void userOffers() {
		Scanner sc=new Scanner(System.in);
		ResultSet rs=OfferController.getOffer();
		System.out.println("OfferCode	Offer Description		Offer Percentage");
		try {
			int flag=0;
				while(rs.next()) {
					String code=rs.getString("offer_code");
					String desc=rs.getString("description");
					int amount=rs.getInt("amount");
					System.out.println(code+"		"+desc+"		"+amount);
					flag=1;
				}				
				if(flag==0) {
					System.out.println("No offers exist currently.");
					System.out.println("Press 1 to go back");
					int c=sc.nextInt();
					if(c==1) {
						UserHome.displayHome();
					}					
				}
				else {
					System.out.println("Press 1 to go back");
					int c=sc.nextInt();
					if(c==1) {
						UserHome.displayHome();
					}
				}
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}	
	}
	public static void adminOffers() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<----------MANAGE OFFERS---------->");
		System.out.println("1. Add Offers");
		System.out.println("2. Delete Offers");
		System.out.println("3. Go back");
		int choice;
		do {
			choice=sc.nextInt();
			switch(choice) {
			case 1:
				addOffer();
				break;
			case 2:
				deleteOffer();
				break;
			case 3:
				AdminHome.displayHome();
				break;
			default:
				System.out.println("Invalid option. Enter correct option");
			}
		}while(choice==0 || choice >3);
	}
	public static void addOffer() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<----------ADD OFFERS---------->");
		System.out.println("Enter the Offer code(five letters):");
		String offerCode;
		do {
			offerCode=sc.next();
			if(offerCode.isEmpty()) {
				System.out.println("Offer code cannot be empty");
			}
			if(offerCode.length()!=5) {
				System.out.println("Offer code must be five letters");
			}
		}while(offerCode.isEmpty() || offerCode.length()!=5);
		System.out.println("Enter the Offer description");
		sc.nextLine();
		String offerDesc=sc.nextLine();
		System.out.println("Enter the offer Amount");
		int offerAmount=sc.nextInt();
		if(!OfferController.offerExist(offerCode)) {
			if(OfferController.createOffer(offerCode, offerDesc, offerAmount)) {
				System.out.println("Offer added successfully");
				System.out.println("Press 1 to go back");
				int c=sc.nextInt();
				if(c==1) {
					Offers.addOffer();
				}
			}
			
		}
		else {
			System.out.println("Offer code already exist");
			System.out.println("Press 1 to go back");
			int c=sc.nextInt();
			if(c==1) {
				Offers.addOffer();
			}
		}
	}
	public static void deleteOffer() {
		Scanner sc=new Scanner(System.in);
		ResultSet rs=OfferController.getOffer();
		System.out.println("OfferCode	Offer Description		Offer Percentage");
			try {
				if(rs.next()) {
					while(rs.next()) {
						String code=rs.getString("offer_code");
						String desc=rs.getString("description");
						int amount=rs.getInt("amount");
						System.out.println(code+"		"+desc+"		"+amount);
					}					
					System.out.println();
					String oc;
					do {
						System.out.println("Enter the offer code to Delete");
						oc=sc.next();
						if(oc.length()!=5) {
							System.out.println("Enter a valid offer code");
						}
						else {
							if(!OfferController.offerExist(oc)) {
								System.out.println("Offer doesn't exist");
								System.out.println("Press 1 to go back");
								int c=sc.nextInt();
								if(c==1) {
									Offers.deleteOffer();
								}
							}
						}
					}while(oc.length()!=5);
					if(OfferController.removeOffer(oc)) {
						System.out.println("Deleted Succesfully..");
						System.out.println("Press 1 to go back");
						int c=sc.nextInt();
						if(c==1) {
							Offers.adminOffers();
						}
						
					}
				}
				else {
					System.out.println("There are no offers to delete.");
					System.out.println("Press 1 to go back");
					int c=sc.nextInt();
					if(c==1) {
						Offers.adminOffers();
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
}
