import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main 
{
	public enum foodType
	{
		APPETIZER, DESSERT, DRINKS, MAINDISH
	}
	
	private static Map<String, String> userInput = new HashMap<String,String>();
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	private static ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
	private static ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
	private static ArrayList<? extends Food> drinkList = new ArrayList<Drinks>();
	private static ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();
	
	public static Map<String, String> importUserInput()
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
		if(appretizer)
		userInput.put("appretizer",String.valueOf(appretizer));
		if(mainDish)
		userInput.put("mainDish",String.valueOf(mainDish));
		if(drink)
		userInput.put("drink",String.valueOf(drink));
		if(dessert)
		userInput.put("dessert",String.valueOf(dessert));
		userInput.put("budget", String.valueOf(budget));
	
		return userInput;
	}
	
	public static void importMenu() throws FileNotFoundException
	{
		ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
		ArrayList<MainDish> tempMainDishList = new ArrayList<MainDish>();
		ArrayList<Drinks> tempDrinkList = new ArrayList<Drinks>();
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
				tempDrinkList.add(new Drinks(inputArray[1],foodType.DRINKS,inputArray[2]));
			}
		}
		
		appetizerList = tempAppetizerList;
		dessertList = tempDessertList;
		mainDishList = tempMainDishList;
		drinkList = tempDrinkList;
		
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
		importUserInput();
		
		menu.add(appetizerList);
		menu.add(mainDishList);
		menu.add(drinkList);
		menu.add(dessertList);
		
		//calculatePrice(menu, userInput);
	}
	
	public Map<String, String> getUserInput()
	{
		return userInput;
	}
	
	public ArrayList<ArrayList<? extends Food>> getMenu()
	{
		return menu;
	}
	

	private static void calculatePrice(ArrayList<ArrayList<? extends Food>> menu2, Map<String, String> userInput2) {
		int currentMenuCounter=0;
		int currentFoodListCounter=0;
		for (ArrayList<? extends Food> arrayListOfFood : menu2)
		{
			for (Food f: arrayListOfFood)
			{
				calculateCombination(f,currentMenuCounter,currentFoodListCounter);
				currentFoodListCounter++;
			}
			currentMenuCounter++;
		}
	}

	private static void calculateCombination(Food f, int curretCounter, int currentFoodListCounter) 
	{
		double tempPrice = 0;
		for (int i = 0; i<menu.size();i++)
		{
			if (i != curretCounter)
			{
				tempPrice += Double.parseDouble(menu.get(i).get(currentFoodListCounter).getPrice());
			}
		}
		if (tempPrice <= Double.parseDouble(userInput.get("budget")))
		{
			Set<String> keySet = userInput.keySet();
			keySet.remove("budget");
			Object[] keys = keySet.toArray();
			
			if (keys.length == 2)
				System.out.println(keys[0].toString());
				//System.out.println(keys[0].toString());
			else if (keys.length == 3)
				System.out.println(keys[0].toString()+ " " +keys[1].toString());
			else if (keys.length == 4)
				System.out.println(keys[0].toString()+ " " + keys[1].toString()+" " + keys[2].toString());
			else if (keys.length == 5)
				System.out.println(keys[0].toString()+ " " + keys[1].toString()+" " + keys[2].toString() + " "+ keys[3].toString());
			else
				System.out.println("NO combination here.");
		}
	}
	
}
