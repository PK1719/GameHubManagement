package View;
import java.util.*;
import Controller.LoginSignupController;

public class AdminLogin {
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------ADMIN LOGIN---------->");
		String username,password;
		do {
			System.out.println("Enter your username:");
			username=sc.next();
			if(username.isEmpty()) {
				System.out.println("Username cannot be empty");
			}
		}while(username.isEmpty());
		do {
			System.out.println("Enter your password:");
			password=sc.next();
			if(password.isEmpty()) {
				System.out.println("Username cannot be empty");
			}
		}while(password.isEmpty());
		if(LoginSignupController.validateAdmin(username.trim(),password.trim())) {
			AdminHome.displayHome();
		}
		else {
			System.out.println("Admin doesn't exist");
			System.out.println("press 1 to go back");
			int choice=sc.nextInt();
			if(choice==1) {
				AdminLogin al=new AdminLogin();
				al.login();
			}
		}
	}
}
