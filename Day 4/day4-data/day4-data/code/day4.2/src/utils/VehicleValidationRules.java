package utils;

import java.time.LocalDate;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.VehicleHandlingException;

public class VehicleValidationRules 
{
	
	//add a static method to invoke all validation rules
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, double basePrice, String manufactureDate, String company, Vehicle[] vehicles) throws VehicleHandlingException 
	{
		checkForDuplicate(chasisNo, vehicles);
		Color validColor = parseAndValidateColor(vehicleColor);
		double netPrice = basePrice + validColor.getColorCost();
		LocalDate validDate = parseAndValidateDate(manufactureDate);
		
		// => all valid inputs-->wrap these details in Vehicle class instance n return the reference to the caller
		return new Vehicle(chasisNo, validColor, netPrice, validDate, company);
	}

	
	//add a static method to parse n validate color
	public static Color parseAndValidateColor(String clr) 
	{
		return Color.valueOf(clr.toUpperCase());
	}
	
	
	// add a static method to parse n validate manu. date
	public static LocalDate parseAndValidateDate(String date) throws VehicleHandlingException 
	{
		LocalDate d1 = LocalDate.parse(date); // parsing >>>if parsing successful ---proceed to validation : curnt year
		//create LocaDate instance : beginning of the year
		LocalDate beginYear = LocalDate.of(LocalDate.now().getYear(), 1, 1);
		if (d1.isAfter(beginYear))
			return d1;
		throw new VehicleHandlingException("Vehicle manufacture date must be after 1st Jan of the curnt year");
	}

	
	
	//check for duplicates
	public static void checkForDuplicate(String newChasisNo, Vehicle[] vehicles) throws VehicleHandlingException 
	{
		Vehicle newVehicle=new Vehicle(newChasisNo); // wrapping  PK
		for (Vehicle v : vehicles)
			if (v != null)
				if (v.equals(newVehicle))
					throw new VehicleHandlingException("Dup Chasis No!!!!!!!!!!!");
		System.out.println("no dup found!!!!");
	}
}
