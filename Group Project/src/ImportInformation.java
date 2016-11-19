package SourceCode;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import SourceCode.Main.foodType;

public class ImportInformation
{

	public void importMenu() throws FileNotFoundException
	{
		ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
		ArrayList<MainDish> tempMainDishList = new ArrayList<MainDish>();
		ArrayList<Drink> tempDrinkList = new ArrayList<Drink>();
		ArrayList<Dessert> tempDessertList = new ArrayList<Dessert>();

		Scanner inFile = new Scanner(new File("Food_Data.txt"));
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

		Main.setAppetizerList(tempAppetizerList);
		Main.setMainDishList(tempMainDishList);
		Main.setDrinkList(tempDrinkList);
		Main.setDessertList(tempDessertList);
		System.out.println("Import completed!!");

	}

	public Map<String, String> importUserInput()
	{
		Map<String, String> userInput = new HashMap<String,String>();
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
		System.out.println("Would you like to order drink?");
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
			System.out.println("Invalid input, please choose atleast one type of food.");
		}
		else if (Integer.parseInt(userInput.get("budget")) <= 0)
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
