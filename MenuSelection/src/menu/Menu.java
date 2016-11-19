package menu;

import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;

import food.*;
import controller.*;
import controller.Main.foodType;

import validate.*;


public class Menu
{

	public void importMenu() throws FileNotFoundException
	{
		ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
		ArrayList<MainDish> tempMainDishList = new ArrayList<MainDish>();
		ArrayList<Drinks> tempDrinkList = new ArrayList<Drinks>();
		ArrayList<Dessert> tempDessertList = new ArrayList<Dessert>();

		Scanner inFile;
			
		inFile = new Scanner(new File("Food_Data.txt"));
		
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
				tempDrinkList.add(new Drinks(inputArray[1],foodType.DRINKS,inputArray[2]));
			}
		}

		Main.setAppetizerList(tempAppetizerList);
		Main.setMainDishList(tempMainDishList);
		Main.setDrinkList(tempDrinkList);
		Main.setDessertList(tempDessertList);
		System.out.println("Import completed!!");

	}
	

	public Map<String, String> importUserInput() throws exception.InputMismatchException{
		
		Map<String, String> userInput = new HashMap<String,String>();
		Scanner input = new Scanner(System.in);
		
		String appretizer_str = "";
		String mainDish_str = "";
		String drink_str = "";
		String dessert_str = "";
		String budget_str = "";
		
		boolean appretizer;
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
		
		appretizer = Boolean.parseBoolean(appretizer_str);
		mainDish = Boolean.parseBoolean(mainDish_str);
		drink = Boolean.parseBoolean(drink_str);
		dessert = Boolean.parseBoolean(dessert_str);
		budget = Double.parseDouble(budget_str);

		userInput.put("appretizer",String.valueOf(appretizer));
		userInput.put("mainDish",String.valueOf(mainDish));
		userInput.put("drink",String.valueOf(drink));
		userInput.put("dessert",String.valueOf(dessert));
		userInput.put("budget", String.valueOf(budget));
		
		if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
							&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
		{
			System.out.println("Invalid input, please choose atleast one type of food.");
		}
		else if (Double.parseDouble(userInput.get("budget")) <= 0)
		{
			System.out.println("Invalid input, the bugget should be greater than one.");
		}
		else
		{
			System.out.println("Import user input Complete.");
		}
		
		return userInput;
	
	}

}
