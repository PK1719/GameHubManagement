package View;
import java.util.*;
import Controller.LoginSignupController;

public class SignUp {
	public static void signUp() {
		Scanner sc=new Scanner(System.in);
		System.out.println("<----------SIGNUP---------->");
		String name,username,password,cpassword,email;
		do {
			System.out.println("Enter your name:");
			name=sc.next();
			if(name.isEmpty()) {
				System.out.println("Name cannot be empty.");
			}
		}while(name.isEmpty());
		int flag=0;
		do {
			System.out.println("Enter a username:");
			username=sc.next();
			if(username.isEmpty()) {
				System.out.println("Username cannot be empty");
			}
			if(LoginSignupController.ifExist(username)) {
				flag=1;
				System.out.println("Username already taken. Enter different username");
			}
			else {
				flag=0;
			}
		}while(username.isEmpty() || flag==1);
		do {
			System.out.println("Enter your email:");
			email=sc.next();
			if(email.isEmpty()) {
				System.out.println("Email cannot be empty");
			}
		}while(email.isEmpty());
		do {
			System.out.println("Enter your password:");
			password=sc.next();
			System.out.println("Confirm your password");
			cpassword=sc.next();
			if(!password.trim().equals(cpassword.trim())) {
				System.out.println("Passwords doesn't match");	
			}
		}while(!password.equals(cpassword) &&password.isEmpty() &&cpassword.isEmpty());
		if(LoginSignupController.validateUser(username.trim(),password.trim())) {
			System.out.println("You already signed up.");
			System.out.println("Press 1 to login");
			int choice=sc.nextInt();
			if(choice==1) {
				Login l=new Login();
				l.login();
			}
		}
		else {
			if(LoginSignupController.addUser(name.trim(), username.trim(), email.trim(), password.trim())) {
				System.out.println("Successfully registered");
				System.out.println("Press 1 to login");
				int choice=sc.nextInt();
				if(choice==1) {
					Login l=new Login();
					l.login();
				}
			}
		}
	}
}
