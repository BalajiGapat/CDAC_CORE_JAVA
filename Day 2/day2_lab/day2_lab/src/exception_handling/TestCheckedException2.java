package exception_handling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TestCheckedException2 {

	public static void main(String[] args) throws ParseException
	{
			// prompt DoB to user (scanner) n parse string --> date n print it
			Scanner sc = new Scanner(System.in);
			// 1. create instance of java.text.SimpleDateFormat(String pattern)
			// y : year , M : month . d : date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			System.out.println("Enter DoB : year-mon-day");
			Date dob = sdf.parse(sc.next()); // convert string-date format into date format
			System.out.println("Date of birth : " + dob);
			sc.close();
			
			System.out.println("main over....");
	}
}
