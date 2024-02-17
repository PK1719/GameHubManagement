package Controller;
import Model.LoginSignupModel;

public class LoginSignupController {

	public static boolean validateUser(String username, String password) {
		if(LoginSignupModel.checkUser(username,password)) {
			return true;
		}
		return false;
	}
	public static boolean addUser(String name,String uname,String email,String password) {
		if(LoginSignupModel.createUser(name, uname, email, password)) {
			return true;
		}
		return false;
	}
	public static boolean validateAdmin(String username, String password) {
		if(LoginSignupModel.checkAdmin(username,password)) {
			return true;
		}
		return false;
	}
	public static boolean ifExist(String username) {
		if(LoginSignupModel.isExist(username)) {
			return true;
		}
		return false;
	}
}
