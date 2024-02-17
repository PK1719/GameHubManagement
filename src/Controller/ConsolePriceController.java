package Controller;
import java.sql.*;
import Model.ConsolePriceModel;

public class ConsolePriceController {
	public static ResultSet getDetails() {
		return ConsolePriceModel.getConsolePrices();
	}
	public static boolean consoleExist(String name) {
		if(ConsolePriceModel.isExist(name)) {
			return true;
		}
		return false;
	}
	public static boolean changePrice(String name,int cost) {
		if(ConsolePriceModel.modifyPrice(name,cost)) {
			return true;
		}
		return false;
		
	}
}
