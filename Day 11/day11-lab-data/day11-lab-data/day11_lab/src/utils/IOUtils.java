package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import com.myorg.Employee;

public interface IOUtils {
	
	//add a static method to store emp details i.e serialization object to binary
	static void storeEmpDetails(Map<String, Employee> emps, String fileName) throws IOException 
	{
		// I/O strms : serialization
		//Java App--ObjectOutputStream-->FileOutputStream-->Binary File
		//Java App ---->OOS--> FOS---> BIn File
		
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) 
		{
			
			out.writeObject(emps); // serialization
		}
	}
	
	

	//add a static method to restore emp details i.e de-serialization binary to object
	@SuppressWarnings("unchecked")
	static Map<String, Employee> restoreEmpDetails(String fileName) 
	{
		// de ser strms : Java App<----OIS <-----FIS <--- bin file
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) 
		{
			return (Map<String, Employee>)in.readObject(); // de-serialization
		} 
		
		catch (Exception e) 
		{
			System.out.println("err during de-serial " + e);
			return new HashMap<>();
		}
	}
}
