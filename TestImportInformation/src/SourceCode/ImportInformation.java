package SourceCode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import SourceCode.Food.foodType;


public class ImportInformation
{
	
	private static Map<String, String> userInput = new HashMap<String,String>();
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	private static ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
	private static ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
	private static ArrayList<? extends Food> drinkList = new ArrayList<Drink>();
	private static ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();
	private static ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();



	public void Print(String str) {
		System.out.print(str);
	}
	
	public void importMenu(String fileName) throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File(fileName+".txt"));	
		ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
		ArrayList<Dessert> tempDessertList= new ArrayList<Dessert>();
		ArrayList<MainDish> tempMainDishList= new ArrayList<MainDish>();
		ArrayList<Drink> tempDrinkList= new ArrayList<Drink>();
		while(inFile.hasNextLine())
		{
			String input = inFile.nextLine();
			input.trim();
			String[] inputArray = input.split(",");
			if (inputArray[0].equals(foodType.APPETIZER.toString()))
			{
				tempAppetizerList.add(new Appetizer(inputArray[1],foodType.APPETIZER,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DESSERT.toString()))
			{
				tempDessertList.add(new Dessert(inputArray[1],foodType.DESSERT,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.MAINDISH.toString()))
			{
				tempMainDishList.add(new MainDish(inputArray[1],foodType.MAINDISH,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DRINKS.toString()))
			{
				tempDrinkList.add(new Drink(inputArray[1],foodType.DRINKS,inputArray[2]));
			}
		}

		appetizerList=tempAppetizerList;
		mainDishList=tempMainDishList;
		drinkList=tempDrinkList;
		dessertList=tempDessertList;
		Print("Import completed!!");

	}

	public Map<String, String> importUserInput()
	{
		
		Scanner input = new Scanner(System.in);
		boolean appretizer;
		boolean mainDish;
		boolean drink;
		boolean dessert;
		double budget;

		System.out.println("Would you like to order appretizer?");
		appretizer = input.nextBoolean();
		System.out.println("Would you like to order main dish?");
		mainDish = input.nextBoolean();
		Print("Would you like to order drink?");
		drink = input.nextBoolean();
		System.out.println("Would you like to order dessert?");
		dessert = input.nextBoolean();
		System.out.println("Please enter your budget");
		budget = input.nextDouble();

		userInput.put("appretizer",String.valueOf(appretizer));
		userInput.put("mainDish",String.valueOf(mainDish));
		userInput.put("drink",String.valueOf(drink));
		userInput.put("dessert",String.valueOf(dessert));
		userInput.put("budget", String.valueOf(budget));
		
		if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
							&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
		{
			Print("Invalid input, please choose at least one type of food.");
			System.exit(0);
		}
		else if (Double.parseDouble(userInput.get("budget")) <= 0)
		{
			Print("Invalid input, the bugget should be greater than one.");
			System.exit(0);
		}
		else
		{
			if(userInput.get("appretizer").equals("true"))
				menu.add(appetizerList);
			if(userInput.get("mainDish").equals("true"))
				menu.add(mainDishList);
			if(userInput.get("drink").equals("true"))
				menu.add(drinkList);
			if(userInput.get("dessert").equals("true"))
				menu.add(dessertList);
			
			Print("Import user input Complete.");
		}

		return userInput;
	}
	
	public static Map<String, String> getUserInput()
	{
		return userInput;
	}

	public static ArrayList<ArrayList<? extends Food>> getMenu()
	{
		return menu;
	}

	public static void setAppetizerList(ArrayList<Appetizer> appList)
	{
		appetizerList = appList;	
	}
	public static void setMainDishList(ArrayList<MainDish> mainList)
	{
		mainDishList = mainList;	
	}
	public static void setDrinkList(ArrayList<Drink> drList)
	{
		drinkList = drList;	
	}
	public static void setDessertList(ArrayList<Dessert> deList)
	{
		dessertList = deList;	
	}
	public static void addFoodCombination(ArrayList<Food> foodCombination)
	{
		tmpFoodCombination.add(foodCombination);	
	}
	

}