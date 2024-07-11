package tester;

import static utils.ShowroomUtils.populateShowroom;
import static utils.VehicleValidationRules.parseAndValidateColor;
import static utils.VehicleValidationRules.parseAndValidateDate;
import static utils.VehicleValidationRules.validateAllInputs;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.app.core.Color;
import com.app.core.Vehicle;

import custom_exceptions.VehicleHandlingException;
import custom_ordering.VehicleDatePriceComparator;
import custom_ordering.VehiclePriceComparator;

public class ShowroomManagementSystem 
{

	public static void main(String[] args) 
	{
		try (Scanner sc = new Scanner(System.in)) 
		{
			//initialization phase --> create empty AL : to store vehicle references
			List<Vehicle> showroom = populateShowroom(); //size=8, initial capacity=10
			boolean exit = false;
			
			//client servicing phase
			while (!exit) 
			{
				System.out.println("Options 1. Add a Vehicle 2. Display all "
						+ "3. Get specific vehicle details 4. Apply discount  "
						+ "5. Delete vehicle details  by chasisNo 6. Delete vehicles by color "
						+ "7. Sort the vehicles as per chasisNo " + "8. Sort the vehicles as per price "
						+ "9. Sort the vehicles as per date n price " + "10. Sort the vehicles as per date 0. Exit");
				System.out.println("Choose an option");
				try 
				{
					switch (sc.nextInt()) 
					{
					case 1: // add a new vehicle
						System.out.println(
								"Enter vehicle details : chasisNo,  vehicleColor,  basePrice,  manufactureDate(yr-mon-day),  company");
						Vehicle validVehicle = validateAllInputs(sc.next(), sc.next(), sc.nextDouble(), sc.next(),
								sc.next(), showroom);
						showroom.add(validVehicle);
						System.out.println("vehicle added.....");
						break;
					case 2:
						System.out.println("Showroom contents : ");
						for (Vehicle v : showroom)
							System.out.println(v);
						break;
					case 3:
						System.out.println("Enter chasis no");
						// showroom : [v1,v2,v3...v10....]
						Vehicle vehicle = new Vehicle(sc.next());
						int index = showroom.indexOf(vehicle);// O(n)
						if (index == -1)
							throw new VehicleHandlingException("Invalid ch no , Vehicle not found!!!!!!!!!!!");
						// => vehicle found
						System.out.println(showroom.get(index));// toString : O(1)
						break;

					case 4:
						System.out.println("Enter date n discount amount");
						LocalDate date = parseAndValidateDate(sc.next());
						double discount = sc.nextDouble();
						// search by date (non PK based)
						for (Vehicle v : showroom)
							if (v.getManufactureDate().isBefore(date))
								v.setNetPrice(v.getNetPrice() - discount);
						System.out.println("discount applied....");
						break;
					case 5:
						System.out.println("Enter chasis no , to delete vehicle details");
						index = showroom.indexOf(new Vehicle(sc.next())); // finding index on PK
						if (index == -1)
							throw new VehicleHandlingException("Invalid ch no , Vehicle not found, can't be removed !!!!!");
						System.out.println("Removed " + showroom.remove(index));
						break;

					case 6:
						System.out.println("Enter color");
						Color chosenClr = parseAndValidateColor(sc.next());
						// => valid clr
						// non PK based
//						for (Vehicle v : showroom) //after removal : ConcurrentModificationException 
//							if (v.getVehicleColor() == chosenClr)
//								System.out.println("Removed " + showroom.remove(v));
//						
						// for loop
//						for (int i = 0; i < showroom.size(); i++)
//							if (showroom.get(i).getVehicleColor() == chosenClr)
//								System.out.println("Removed " + showroom.remove(i));

						// soln : attaching Iterator explicitly
						Iterator<Vehicle> itr = showroom.iterator();
						while (itr.hasNext())
							if (itr.next().getVehicleColor() == chosenClr)
								itr.remove();// remove() : removes the last elem reted by next()
						break;

					case 7:
						// Collections : public static void sort(List<T> list)
						Collections.sort(showroom); // use comparTo method (comparable<T> i/f) internally
						break;

					case 8:
						// API of Collections class : public static void sort(List<T> list,Comparator<T>)

						// Collections.sort(showroom, new VehiclePriceComparator()); // use compare
						// method (comparator<T> i/f) internally

						// OR by using Lambda expression
						Collections.sort(showroom, (v1, v2) -> {
							if (v1.getNetPrice() > v2.getNetPrice())
								return 1;
							if (v1.getNetPrice() < v2.getNetPrice())
								return -1;
							else
								return 0;
							
							//return (int)v1.getNetPrice()  - (int)v2.getNetPrice();
						});

						break;
					case 9:
						// sort the vehicles as per date and price
						//Collections.sort(showroom, new VehicleDatePriceComparator());

						// Or By Lambda expression
						Collections.sort(showroom, (v1, v2) ->{ //LocalDate is Comparable
							int ret = (v1.getManufactureDate().compareTo(v2.getManufactureDate()));
							if (ret == 0) 
							{
								if ((v1.getNetPrice()) > v2.getNetPrice())
									return 1;
								if ((v1.getNetPrice()) > v2.getNetPrice())
									return -1;
								else
									return 0;
							};
							
							return ret;
						});
						break;

					case 10: // custom ordering using ano innner class

						Collections.sort(showroom, new Comparator<Vehicle>() {
							@Override
							public int compare(Vehicle o1, Vehicle o2) {
								System.out.println("compare : date -ano inner cls");
								return o1.getManufactureDate().compareTo(o2.getManufactureDate());
							}
						});

						//OR By using Lambda expression
						Collections.sort(showroom, (v1, v2) -> {
							return v1.getManufactureDate().compareTo(v2.getManufactureDate());
						});
						break;
						
					case 0:
						exit = true;
						break;
					}
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
					// read off pending tokens form the scanner's buffer
					sc.nextLine();
				}
			}
		} // sc.clsoe() : JVM

	}

}
