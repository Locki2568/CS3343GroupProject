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
	private static UserInput userInput = new UserInput();
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	private static ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
	private static ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
	private static ArrayList<? extends Food> drinkList = new ArrayList<Drink>();
	private static ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();

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
		System.out.println("Import completed!!");
	}

	public void importUserInput()
	{
		Scanner input = new Scanner(System.in);
		boolean appetizer;
		boolean mainDish;
		boolean drink;
		boolean dessert;
		double budget;

		System.out.println("Would you like to order appretizer?");
		appetizer = input.nextBoolean();
		System.out.println("Would you like to order main dish?");
		mainDish = input.nextBoolean();
		System.out.println("Would you like to order drink?");
		drink = input.nextBoolean();
		System.out.println("Would you like to order dessert?");
		dessert = input.nextBoolean();
		System.out.println("Please enter your budget");
		budget = input.nextDouble();

		userInput = new UserInput(String.valueOf(appetizer), String.valueOf(mainDish), 
				String.valueOf(drink), String.valueOf(dessert), budget);
	}	
		
	public void validateInput()
	{
		if(userInput.getAppetizer().equals("false") && userInput.getMainDish().equals("false") 
				&& userInput.getDrink().equals("false") && userInput.getDessert().equals("false"))
		{
			System.out.println("Invalid input, please choose at least one type of food.");
			System.exit(0);
		}
		else if (userInput.getBudget() <= 0)
		{
			System.out.println("Invalid input, the bugget should be greater than zero.");
			System.exit(0);
		}
		else
		{
			System.out.println("Import user input complete.");
		}
	}
	
	public void setupMenu()
	{
		if(userInput.getAppetizer().equals("true"))
			menu.add(appetizerList);
		if(userInput.getMainDish().equals("true"))
			menu.add(mainDishList);
		if(userInput.getDrink().equals("true"))
			menu.add(drinkList);
		if(userInput.getDessert().equals("true"))
			menu.add(dessertList);
	}

	public static UserInput getUserInput()
	{
		return userInput;
	}
	
	public static ArrayList<ArrayList<? extends Food>> getMenu()
	{
		return menu;
	}
	
	public static void resetAllInformation()
	{
		userInput = new UserInput();
		menu = new ArrayList<ArrayList<? extends Food>>();
		appetizerList = new ArrayList<Appetizer>();
		mainDishList = new ArrayList<MainDish>();
		drinkList = new ArrayList<Drink>();
		dessertList = new ArrayList<Dessert>();
	}

}