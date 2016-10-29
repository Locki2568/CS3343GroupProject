import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main 
{
	public enum foodType
	{
		APPRETIZER, DESSERT, DRINKS, MAINDISH
	}
	
	private static Map<String, String> userInput = new HashMap<String,String>();
	private static ArrayList<ArrayList<Food>> menu = new ArrayList<ArrayList<Food>>();
	private static ArrayList<Food> appretizerList = new ArrayList<Food>();
	private static ArrayList<Food> mainDishList = new ArrayList<Food>();
	private static ArrayList<Food> drinkList = new ArrayList<Food>();
	private static ArrayList<Food> dessertList = new ArrayList<Food>();
	
	public static Map<String, String> getUserInput()
	{
		// Import user input
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
	
		return userInput;
	}
	
	public static void importMenu() throws FileNotFoundException
	{
		Scanner inFile = new Scanner(new File("Food_Data.txt"));
		while(inFile.hasNextLine())
		{
			String input = inFile.nextLine();
			input.trim();
			String[] inputArray = input.split(",");
			if (inputArray[0].equals(foodType.APPRETIZER.toString()))
			{
				appretizerList.add(new Appretizer(inputArray[1],foodType.APPRETIZER,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DESSERT.toString()))
			{
				dessertList.add(new Appretizer(inputArray[1],foodType.DESSERT,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.MAINDISH.toString()))
			{
				mainDishList.add(new Appretizer(inputArray[1],foodType.MAINDISH,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DRINKS.toString()))
			{
				drinkList.add(new Appretizer(inputArray[1],foodType.DRINKS,inputArray[2]));
			}
		}
		System.out.println("Import completed!!");
	}
	
	public static void main(String arg[]) 
	{
		
		try {
			importMenu();
		} catch (FileNotFoundException e) {
			System.out.println("File not found...exiting program...");
			System.exit(0);
		}
		getUserInput();
		
		menu.add(appretizerList);
		menu.add(mainDishList);
		menu.add(drinkList);
		menu.add(dessertList);
		
		//calculatePrice(menu, budget);
	}
	
}
