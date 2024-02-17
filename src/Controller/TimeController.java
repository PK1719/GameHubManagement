package Controller;
import java.util.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TimeController {
	public static String setStartTime() {
		Date date=new Date();
		int hours=date.getHours();
		int seconds=date.getSeconds();
		int minutes=date.getMinutes();
		String startTime=""+Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(seconds);
		return startTime;
	}
	public static String setEndTime() {
		Date date=new Date();
		int hours=date.getHours();
		int seconds=date.getSeconds();
		int minutes=date.getMinutes();
		String endTime=""+Integer.toString(hours)+":"+Integer.toString(minutes)+":"+Integer.toString(seconds);
		return endTime;
	}
	public static int calculateTime(String sTime,String eTime) {
		String a[]=sTime.split(":");
		String b[]=eTime.split(":");
		int sh=Integer.parseInt(a[0]),sm=Integer.parseInt(a[1]),ss=Integer.parseInt(a[2]);
		int eh=Integer.parseInt(b[0]),em=Integer.parseInt(b[1]),es=Integer.parseInt(b[2]);
		int totalStartSeconds=(sh*3600)+(sm*60)+ss;
		int totalEndSeconds=(eh*3600)+(em*60)+es;
		int diff=totalEndSeconds-totalStartSeconds;
		return diff;
	}
}
