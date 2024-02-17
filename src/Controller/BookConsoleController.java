package Controller;

import Model.BookConsoleModel;

public class BookConsoleController {
	public static boolean checkBookPc(String id) {
		return BookConsoleModel.bookedPc(id);
	}
	public static boolean unbookConsole(String id) {
		return BookConsoleModel.unBook(id);
	}
	public static boolean isPC(String id) {
		return BookConsoleModel.checkPC(id);
	}
	public static boolean isPS4(String id) {
		return BookConsoleModel.checkPS4(id);
	}
	public static boolean isPS5(String id) {
		return BookConsoleModel.checkPS5(id);
	}
}
