package View;
import java.util.*;
import Controller.LoginSignupController;

public class Login {
	public static String username;
	public static void login() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<-----------LOGIN---------->");
		String password;
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
		if(LoginSignupController.validateUser(username.trim(),password.trim())) {
			UserHome uh=new UserHome();
			uh.displayHome();
		}
		else {
			System.out.println("User doesn't exist");
			System.out.println("press 1 to Sign up");
			SignUp sup=new SignUp();
			sup.signUp();
		}
	}
}
