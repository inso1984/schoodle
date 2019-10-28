package ch.schoodle.applicationdata;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tools {
	private static final SimpleDateFormat formater = new SimpleDateFormat("dd.MM.yyyy");
	
	public static String dateToString(Date date) {
		return formater.format(date);
	}
	
	public static Date dateFromString(String date) {
		try {
			return formater.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
