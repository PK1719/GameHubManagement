package Controller;

import Model.ConsoleModel;

import java.io.Console;
import java.sql.*;

public class ConsoleController {
	public static boolean addConsole(String consoleID, String type) {
		if(ConsoleModel.consoleAdd(consoleID, type)) {
			return true;
		}
		return false;
	}
	public static ResultSet getConsoles() { 
		return ConsoleModel.retrieveConsoles();
	}
	public static boolean isExist(String id) {
		if(ConsoleModel.checkId(id)) {
			return true;
		}
		return false;
	}
	public static boolean deleteConsole(String id) {
		if(ConsoleModel.removeConsole(id)) {
			return true;
		}
		return false;
	}
	public static ResultSet getPC() {
		return ConsoleModel.retrievePc();
	}
	public static ResultSet getPs4() {
		return ConsoleModel.retrievePs4();
	}
	public static ResultSet getPs5() {
		return ConsoleModel.retrievePs5();
	}
	
}
