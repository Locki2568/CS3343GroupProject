package TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import SourceCode.Appetizer;
import SourceCode.Combination;
import SourceCode.Dessert;
import SourceCode.Drink;
import SourceCode.Food;
import SourceCode.ImportInformation;
import SourceCode.MainDish;
import SourceCode.Main;
import SourceCode.Main.foodType;
import static org.junit.Assert.*;

public class TestSystem {
	
	//Test for Appetizer
	@Test
	public void testAppetizer01()
	{	
		
		Appetizer appetizer=new Appetizer("Salad",Main.foodType.APPETIZER,"55");
		String name = appetizer.getFoodName();
		assertEquals(name,"Salad");
	}
	@Test
	public void testAppetizer02()
	{	
		Appetizer appetizer=new Appetizer("Salad",Main.foodType.APPETIZER,"55");
		foodType foodType = appetizer.getFoodType();
		assertEquals(foodType,Main.foodType.APPETIZER);
	}
	@Test
	public void testAppetizer03()
	{	
		Appetizer appetizer=new Appetizer("Salad",Main.foodType.APPETIZER,"55");
		String price = appetizer.getPrice();
		assertEquals(price,"55");
	}
	
	//Test for Dessert
	@Test
	public void testDessert01()
	{	
		Dessert dessert=new Dessert("Ice Cream",Main.foodType.DESSERT,"40");
		String name = dessert.getFoodName();
		assertEquals(name,"Ice Cream");
	}
	@Test
	public void testDessert02()
	{	
		Dessert dessert=new Dessert("Ice Cream",Main.foodType.DESSERT,"40");
		foodType foodType = dessert.getFoodType();
		assertEquals(foodType,Main.foodType.DESSERT);
	}
	@Test
	public void testDessert03()
	{	
		Dessert dessert=new Dessert("Ice Cream",Main.foodType.DESSERT,"40");
		String price = dessert.getPrice();
		assertEquals(price,"40");
	}
	
	//Test for Drink
	@Test
	public void testDrinks01()
	{	
		Drink drinks=new Drink("Water",Main.foodType.DRINKS,"12");
		String name = drinks.getFoodName();
		assertEquals(name,"Water");
	}
	@Test
	public void testDrinks02()
	{	
		Drink drinks=new Drink("Water",Main.foodType.DRINKS,"12");
		foodType foodType = drinks.getFoodType();
		assertEquals(foodType,Main.foodType.DRINKS);
	}
	@Test
	public void testDrinks03()
	{	
		Drink drinks=new Drink("Water",Main.foodType.DRINKS,"12");
		String price = drinks.getPrice();
		assertEquals(price,"12");
	}
	
	//Test for MainDish
	@Test
	public void testMainDish01()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Main.foodType.MAINDISH,"199");
		String name = mainDish.getFoodName();
		assertEquals(name,"Roast Piggen");
	}
	@Test
	public void testMainDish02()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Main.foodType.MAINDISH,"199");
		foodType foodType = mainDish.getFoodType();
		assertEquals(foodType,Main.foodType.MAINDISH);
	}
	@Test
	public void testMainDish03()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Main.foodType.MAINDISH,"199");
		String price = mainDish.getPrice();
		assertEquals(price,"199");
	}
	
	//Test for combination
	@Test
	public void testCombination01()
	{
		ArrayList<Food> foodCombination = new ArrayList<Food>();
		Appetizer appetizer=new Appetizer("Salad",Main.foodType.APPETIZER,"55");
		foodCombination.add(appetizer);
		
		
		Combination mealCombination = new Combination(foodCombination);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		mealCombination.getCombinationPrice();
		assertEquals("Salad:  $55 ",outContent.toString());

	}
	
	//Test for ImportInformation
	@Test
	public void testImportMenu01() throws FileNotFoundException
	{
		class SubImportInformation extends ImportInformation{
		
			String type;	
			
			@Override
			public void importMenu() throws FileNotFoundException
			{
				
				Scanner inFile = new Scanner(new File("Food_Data_test1.txt"));
				while(inFile.hasNextLine())
				{
					String input = inFile.nextLine();
					input.trim();
					String[] inputArray = input.split(",");
					if (inputArray[0].equals(foodType.APPETIZER.toString()))
					{
						type="Appetizer";
					}
					else if (inputArray[0].equals(foodType.DESSERT.toString()))
					{
						type="Dessert";
					}
					else if (inputArray[0].equals(foodType.MAINDISH.toString()))
					{
						type="MainDish";
					}
					else if (inputArray[0].equals(foodType.DRINKS.toString()))
					{
						type="Drinks";
					}
					else 
					{
						type="N/A";
					}
				}
			}
			
			public String getType()
			{
				return type;
			}
			
		}
		SubImportInformation menuImport = new SubImportInformation();
		menuImport.importMenu();
		assertEquals(menuImport.getType(),"Appetizer");
	}
	
	@Test
	public void testImportMenu02() throws FileNotFoundException
	{
		class SubImportInformation extends ImportInformation{
			
			String type;
			
			@Override
			public void importMenu() throws FileNotFoundException
			{
				
				Scanner inFile = new Scanner(new File("Food_Data_test2.txt"));
				while(inFile.hasNextLine())
				{
					String input = inFile.nextLine();
					input.trim();
					String[] inputArray = input.split(",");
					if (inputArray[0].equals(foodType.APPETIZER.toString()))
					{
						type="Appetizer";
					}
					else if (inputArray[0].equals(foodType.DESSERT.toString()))
					{
						type="Dessert";
					}
					else if (inputArray[0].equals(foodType.MAINDISH.toString()))
					{
						type="MainDish";
					}
					else if (inputArray[0].equals(foodType.DRINKS.toString()))
					{
						type="Drinks";
					}
					else 
					{
						type="N/A";
					}
				}
			}
			
			public String getType()
			{
				return type;
			}
			
		}
		SubImportInformation menuImport = new SubImportInformation();
		menuImport.importMenu();
		assertEquals(menuImport.getType(),"MainDish");
	}
	
	@Test
	public void testImportMenu03() throws FileNotFoundException
	{
		class SubImportInformation extends ImportInformation{
			
			String type;
			
			@Override
			public void importMenu() throws FileNotFoundException
			{
				
				Scanner inFile = new Scanner(new File("Food_Data_test3.txt"));
				while(inFile.hasNextLine())
				{
					String input = inFile.nextLine();
					input.trim();
					String[] inputArray = input.split(",");
					if (inputArray[0].equals(foodType.APPETIZER.toString()))
					{
						type="Appetizer";
					}
					else if (inputArray[0].equals(foodType.DESSERT.toString()))
					{
						type="Dessert";
					}
					else if (inputArray[0].equals(foodType.MAINDISH.toString()))
					{
						type="MainDish";
					}
					else if (inputArray[0].equals(foodType.DRINKS.toString()))
					{
						type="Drinks";
					}
					else 
					{
						type="N/A";
					}
				}
			}
			
			public String getType()
			{
				return type;
			}
			
		}
		SubImportInformation menuImport = new SubImportInformation();
		menuImport.importMenu();
		assertEquals(menuImport.getType(),"Dessert");
	}

	@Test
	public void testImportMenu04() throws FileNotFoundException
	{
		class SubImportInformation extends ImportInformation{
			
			String type;
			
			@Override
			public void importMenu() throws FileNotFoundException
			{
				
				Scanner inFile = new Scanner(new File("Food_Data_test4.txt"));
				while(inFile.hasNextLine())
				{
					String input = inFile.nextLine();
					input.trim();
					String[] inputArray = input.split(",");
					if (inputArray[0].equals(foodType.APPETIZER.toString()))
					{
						type="Appetizer";
					}
					else if (inputArray[0].equals(foodType.DESSERT.toString()))
					{
						type="Dessert";
					}
					else if (inputArray[0].equals(foodType.MAINDISH.toString()))
					{
						type="MainDish";
					}
					else if (inputArray[0].equals(foodType.DRINKS.toString()))
					{
						type="Drinks";
					}
					else 
					{
						type="N/A";
					}
				}
			}
			
			public String getType()
			{
				return type;
			}
			
		}
		SubImportInformation menuImport = new SubImportInformation();
		menuImport.importMenu();
		assertEquals(menuImport.getType(),"Drinks");
	}
	
	@Test
	public void testImportMenu05() throws FileNotFoundException
	{
		class SubImportInformation extends ImportInformation{
			
			String type;
			
			@Override
			public void importMenu() throws FileNotFoundException
			{
				
				Scanner inFile = new Scanner(new File("Food_Data_test5.txt"));
				while(inFile.hasNextLine())
				{
					String input = inFile.nextLine();
					input.trim();
					String[] inputArray = input.split(",");
					if (inputArray[0].equals(foodType.APPETIZER.toString()))
					{
						type="Appetizer";
					}
					else if (inputArray[0].equals(foodType.DESSERT.toString()))
					{
						type="Dessert";
					}
					else if (inputArray[0].equals(foodType.MAINDISH.toString()))
					{
						type="MainDish";
					}
					else if (inputArray[0].equals(foodType.DRINKS.toString()))
					{
						type="Drinks";
					}
					else 
					{
						type="N/A";
					}
				}
			}
			
			public String getType()
			{
				return type;
			}
			
		}
		SubImportInformation menuImport = new SubImportInformation();
		menuImport.importMenu();
		assertEquals(menuImport.getType(),"N/A");
	}
	
	// Test for ImportUserInput
	@Test
	public void testimportUserInput01()
	{
		class SubImportInformation extends ImportInformation{
			public String importUserInput(boolean appretizer,boolean mainDish,boolean drink,boolean dessert,double budget)
			{
				Map<String, String> userInput = new HashMap<String,String>();
				userInput.put("appretizer",String.valueOf(appretizer));
				userInput.put("mainDish",String.valueOf(mainDish));
				userInput.put("drink",String.valueOf(drink));
				userInput.put("dessert",String.valueOf(dessert));
				userInput.put("budget", String.valueOf(budget));
				String result = "";
				
				if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
									&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
				{
					result ="Invalid input, please choose atleast one type of food.";
				}
				else if (Double.parseDouble(userInput.get("budget")) <= 0)
				{
					
					result ="Invalid input, the bugget should be greater than one.";
				}
				else
				{
					result = "Import user input Complete.";
				}
				return result;
			}	
		}
		
		SubImportInformation userInput = new SubImportInformation();
		assertEquals(userInput.importUserInput(true, true, true, true, 100.0), "Import user input Complete.");

	}
	
	@Test
	public void testimportUserInput02()
	{
		class SubImportInformation extends ImportInformation{
			public String importUserInput(boolean appretizer,boolean mainDish,boolean drink,boolean dessert,double budget)
			{
				Map<String, String> userInput = new HashMap<String,String>();
				userInput.put("appretizer",String.valueOf(appretizer));
				userInput.put("mainDish",String.valueOf(mainDish));
				userInput.put("drink",String.valueOf(drink));
				userInput.put("dessert",String.valueOf(dessert));
				userInput.put("budget", String.valueOf(budget));
				String result = "";
				
				if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
									&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
				{
					result ="Invalid input, please choose atleast one type of food.";
				}
				else if (Double.parseDouble(userInput.get("budget")) <= 0)
				{
					
					result ="Invalid input, the bugget should be greater than one.";
				}
				else
				{
					result = "Import user input Complete.";
				}
				return result;
			}	
		}
		
		SubImportInformation userInput = new SubImportInformation();
		assertEquals(userInput.importUserInput(false, false, false, false, 100.0), "Invalid input, please choose atleast one type of food.");

	}
	
	@Test
	public void testimportUserInput03()
	{
		class SubImportInformation extends ImportInformation{
			public String importUserInput(boolean appretizer,boolean mainDish,boolean drink,boolean dessert,double budget)
			{
				Map<String, String> userInput = new HashMap<String,String>();
				userInput.put("appretizer",String.valueOf(appretizer));
				userInput.put("mainDish",String.valueOf(mainDish));
				userInput.put("drink",String.valueOf(drink));
				userInput.put("dessert",String.valueOf(dessert));
				userInput.put("budget", String.valueOf(budget));
				String result = "";
				
				if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
									&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
				{
					result ="Invalid input, please choose atleast one type of food.";
				}
				else if (Double.parseDouble(userInput.get("budget")) <= 0)
				{
					
					result ="Invalid input, the bugget should be greater than one.";
				}
				else
				{
					result = "Import user input Complete.";
				}
				return result;
			}	
		}
		
		SubImportInformation userInput = new SubImportInformation();
		assertEquals(userInput.importUserInput(true, true, true, true, 0.0), "Invalid input, the bugget should be greater than one.");

	}
	
	
	//Test for calculatePrice
	
	@Test
	public void testCalculatePrice01()
	{
		
		
	}
	
	
}
