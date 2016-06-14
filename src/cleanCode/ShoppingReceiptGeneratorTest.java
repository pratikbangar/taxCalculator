package cleanCode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;

public class ShoppingReceiptGeneratorTest {
	
   @org.junit.Test
   public void test1()
	{
		List<String> shoppingList = new ArrayList<String>(0);
		shoppingList.add("1 book at 12.49");
		shoppingList.add("1 music CD at 14.99");
		shoppingList.add("1 chocolate bar at 0.85");	
		
		List<String> receiptDetailsExpected = new ArrayList<String>(0);
		receiptDetailsExpected.add("1 book: 12.49");
		receiptDetailsExpected.add("1 music CD: 16.49");
		receiptDetailsExpected.add("1 chocolate bar: 0.85");	
		receiptDetailsExpected.add("Sales Taxes: 1.5");
		receiptDetailsExpected.add("Total: 29.83");
		
		List<String> receiptDetailsActual = ShoppingReceiptGenerator.generateReceipt(shoppingList);
		
		Assert.assertTrue(receiptDetailsExpected.get(0).equals(receiptDetailsActual.get(0)));
		Assert.assertTrue(receiptDetailsExpected.get(1).equals(receiptDetailsActual.get(1)));
		Assert.assertTrue(receiptDetailsExpected.get(2).equals(receiptDetailsActual.get(2)));
		Assert.assertTrue(receiptDetailsExpected.get(3).equals(receiptDetailsActual.get(3)));
		Assert.assertTrue(receiptDetailsExpected.get(4).equals(receiptDetailsActual.get(4)));
	}
   
   @org.junit.Test
   public void test2()
	{
		List<String> shoppingList = new ArrayList<String>(0);
		shoppingList.add("1 imported box of chocolates at 10.00");
		shoppingList.add("1 imported bottle of perfume at 47.50");
		
		List<String> receiptDetailsExpected = new ArrayList<String>(0);
		receiptDetailsExpected.add("1 imported box of chocolates: 10.5");
		receiptDetailsExpected.add("1 imported bottle of perfume: 54.65");
		receiptDetailsExpected.add("Sales Taxes: 7.65");	
		receiptDetailsExpected.add("Total: 65.15");
		
		List<String> receiptDetailsActual = ShoppingReceiptGenerator.generateReceipt(shoppingList);
		
		Assert.assertTrue(receiptDetailsExpected.get(0).equals(receiptDetailsActual.get(0)));
		Assert.assertTrue(receiptDetailsExpected.get(1).equals(receiptDetailsActual.get(1)));
		Assert.assertTrue(receiptDetailsExpected.get(2).equals(receiptDetailsActual.get(2)));
		Assert.assertTrue(receiptDetailsExpected.get(3).equals(receiptDetailsActual.get(3)));
	}
   
   @org.junit.Test
   public void test3()
	{
		List<String> shoppingList = new ArrayList<String>(0);
		shoppingList.add("1 imported bottle of perfume at 27.99");
		shoppingList.add("1 bottle of perfume at 18.99");
		shoppingList.add("1 packet of headache pills at 9.75");
		shoppingList.add("1 box of imported chocolates at 11.25");
		
		List<String> receiptDetailsExpected = new ArrayList<String>(0);
		receiptDetailsExpected.add("1 imported bottle of perfume: 32.19");
		receiptDetailsExpected.add("1 bottle of perfume: 20.89");
		receiptDetailsExpected.add("1 packet of headache pills: 9.75");	
		receiptDetailsExpected.add("1 box of imported chocolates: 11.85");
		receiptDetailsExpected.add("Sales Taxes: 6.7");	
		receiptDetailsExpected.add("Total: 74.68");
		
		List<String> receiptDetailsActual = ShoppingReceiptGenerator.generateReceipt(shoppingList);
		
		Assert.assertTrue(receiptDetailsExpected.get(0).equals(receiptDetailsActual.get(0)));
		Assert.assertTrue(receiptDetailsExpected.get(1).equals(receiptDetailsActual.get(1)));
		Assert.assertTrue(receiptDetailsExpected.get(2).equals(receiptDetailsActual.get(2)));
		Assert.assertTrue(receiptDetailsExpected.get(3).equals(receiptDetailsActual.get(3)));
		Assert.assertTrue(receiptDetailsExpected.get(4).equals(receiptDetailsActual.get(4)));
		Assert.assertTrue(receiptDetailsExpected.get(5).equals(receiptDetailsActual.get(5)));
	}
   
   @org.junit.Test
   public void test4()
	{
		List<String> shoppingList = new ArrayList<String>(0);
		shoppingList.add("1 book at 100.0");
		shoppingList.add("2 music CD at 200.0");
		shoppingList.add("2 chocolate bar at 100.0");	
		
		List<String> receiptDetailsExpected = new ArrayList<String>(0);
		receiptDetailsExpected.add("1 book: 100.0");
		receiptDetailsExpected.add("2 music CD: 220.0");
		receiptDetailsExpected.add("2 chocolate bar: 100.0");	
		receiptDetailsExpected.add("Sales Taxes: 20.0");
		receiptDetailsExpected.add("Total: 420.0");
		
		List<String> receiptDetailsActual = ShoppingReceiptGenerator.generateReceipt(shoppingList);
		
		Assert.assertTrue(receiptDetailsExpected.get(0).equals(receiptDetailsActual.get(0)));
		Assert.assertTrue(receiptDetailsExpected.get(1).equals(receiptDetailsActual.get(1)));
		Assert.assertTrue(receiptDetailsExpected.get(2).equals(receiptDetailsActual.get(2)));
		Assert.assertTrue(receiptDetailsExpected.get(3).equals(receiptDetailsActual.get(3)));
		Assert.assertTrue(receiptDetailsExpected.get(4).equals(receiptDetailsActual.get(4)));
	}

}
