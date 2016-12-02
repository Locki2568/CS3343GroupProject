package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import food.Appetizer;
import food.Dessert;
import food.Drink;
import food.Food;
import food.MainDish;
import food.Food.foodType;


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
			else
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

	public void importUserInput() throws exception.InputMismatchException
	{
		Scanner input = new Scanner(System.in);
		
		String appretizer_str = "";
		String mainDish_str = "";
		String drink_str = "";
		String dessert_str = "";
		String budget_str = "";
		
		boolean appetizer;
		boolean mainDish;
		boolean drink;
		boolean dessert;
		double budget;

boolean valid;
		
		System.out.println("Would you like to order appretizer?");
		appretizer_str = input.next();
		valid = validate.ValidateInput.validBooleanInput(appretizer_str);
		if(valid == false)
			throw new exception.InputMismatchException();
		
		System.out.println("Would you like to order main dish?");
		mainDish_str = input.next();
		valid = validate.ValidateInput.validBooleanInput(mainDish_str);
		if(valid == false)
			throw new exception.InputMismatchException();
		
		System.out.println("Would you like to order drink?");
		drink_str = input.next();
		valid = validate.ValidateInput.validBooleanInput(drink_str);
		if(valid == false)
			throw new exception.InputMismatchException();
		
		System.out.println("Would you like to order dessert?");
		dessert_str = input.next();
		valid = validate.ValidateInput.validBooleanInput(dessert_str);
		if(valid == false)
			throw new exception.InputMismatchException();
		
		System.out.println("Please enter your budget");
		budget_str = input.next();
		valid = validate.ValidateInput.validNumericInput(budget_str);
		if(valid == false)
			throw new exception.InputMismatchException();
		
		appetizer = Boolean.parseBoolean(appretizer_str);
		mainDish = Boolean.parseBoolean(mainDish_str);
		drink = Boolean.parseBoolean(drink_str);
		dessert = Boolean.parseBoolean(dessert_str);
		budget = Double.parseDouble(budget_str);

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