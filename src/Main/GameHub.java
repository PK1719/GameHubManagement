package Main;
import java.util.*;

import Controller.TimeController;
import View.AdminLogin;
import View.Login;
import View.SignUp;
import Model.DatabaseConnection;
public class GameHub {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("<----------Welcome to Digital PlayGround---------->");
		int choice;
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. AdminLogin");
		do{
			choice=sc.nextInt();
			switch(choice) { 
			case 1:
				Login login=new Login();
				login.login();
				break;
			case 2:
				SignUp sup=new SignUp();
				sup.signUp();
				break;
			case 3:
				AdminLogin al=new AdminLogin();
				al.login();
				break;
			default:
				System.out.println("Invalid Option.Enter correct choice");
				continue;
			}
		}while(choice==0 || choice >3);
		
	}
}
