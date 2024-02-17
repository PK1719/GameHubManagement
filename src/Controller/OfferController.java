package Controller;
import Model.OffersModel;
import java.sql.*;

public class OfferController {
	public static boolean offerExist(String code) {
		if(OffersModel.isExist(code)) {
			return true;
		}
		return false;
	}
	public static boolean createOffer(String code,String desc,int amount) {
		if(OffersModel.addOffer(code,desc,amount)) {
			return true;
		}
		return false;
	}
	public static ResultSet getOffer() {
		return OffersModel.retrieveOffers();
	}
	public static boolean removeOffer(String code) {
		if(OffersModel.deleteOffer(code)) {
			return true;
		}
		return false;
	}
	public static int getDiscount(String code) {
		return OffersModel.getAmount(code);
	}
}
