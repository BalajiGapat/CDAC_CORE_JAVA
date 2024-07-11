package utils;
//import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DBUtils 
{
	//static data member : Connection => fixed_connectivity
	private static Connection cn;

	//add static method to open the database connection
	public static Connection openConnection() throws /*ClassNotFoundException*/ SQLException 
	{
		//load JDBC driver class in method area
		//Class.forName("com.mysql.cj.jdbc.Driver");
		 
		
		//establish database connection
		String dbURL = "jdbc:mysql://localhost:3306/advjava ?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
		cn = DriverManager.getConnection(dbURL, "root", "root");
		
		return cn;
	}
}
