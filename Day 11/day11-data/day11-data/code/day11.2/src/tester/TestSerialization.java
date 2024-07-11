package tester;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.shop.core.Category;
import com.shop.core.Product;
import static utils.ShopUtils.*;
import static utils.IOUtils.storeProductDetails;

public class TestSerialization 
{
	public static void main(String[] args) 
	{
		try(Scanner sc=new Scanner(System.in))
		{
			//get populated map of products from ShopUtils
			Map<Integer, Product> productMap = populateProductMap(populateProductList());
			
			System.out.println("Enter file name");
			storeProductDetails(sc.nextLine(), productMap);
			System.out.println("products stored.....");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("main over....");
	}

}
