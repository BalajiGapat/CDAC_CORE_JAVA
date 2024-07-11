package java8_date_time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import static java.time.LocalDate.now;
import static java.time.LocalDate.parse;

//import static java.time.LocalDate.*;


public class Test2 
{

	public static void main(String[] args) 
	{
		// accept date (string) from user n parse n display
		try(Scanner sc=new Scanner(System.in))
		{
			System.out.println("Enter DoB : yyyy-MM-dd");
			LocalDate dob=parse(sc.next()); // 1996-01-29
			System.out.println("DoB "+dob);
			
			LocalDate today=now();
			System.out.println(dob.isBefore(today)); //t
			System.out.println(dob.compareTo(today)); // -27 << 1996-2023
			
			System.out.println("Enter date in format : dd/M/yyyy  "); // dd/M/yyyy : pattern 
			LocalDate d1=LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/M/yyyy"));
			System.out.println("date:: "+d1);
			
		}//sc.close();

	}

}
