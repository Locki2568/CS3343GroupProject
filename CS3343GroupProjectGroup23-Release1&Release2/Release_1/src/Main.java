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

	public static Map<String, String> userInput = new HashMap<String,String>();
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	private static ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
	private static ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
	private static ArrayList<? extends Food> drinkList = new ArrayList<Drinks>();
	private static ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();
	private static ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();
	private static ArrayList<Combination> tmpFoodCombinationList = new ArrayList<Combination>();
	private static double tempCombinationPrice = 0;

	public static void importUserInput()
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

		if(userInput.get("appretizer").equals("true"))
			menu.add(appetizerList);
		if(userInput.get("mainDish").equals("true"))
			menu.add(mainDishList);
		if(userInput.get("drink").equals("true"))
			menu.add(drinkList);
		if(userInput.get("dessert").equals("true"))
			menu.add(dessertList);

		calculatePrice(menu, userInput);

		for(Combination c :tmpFoodCombinationList)
		{
			c.getCombinationPrice();
			System.out.println();
		}
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
		double tempPrice = 0;
		ArrayList<Food> foodStorageList = new ArrayList<Food>();

		for (Food f: menu.get(0))
		{
			if (Double.parseDouble(f.getPrice()) > Double.parseDouble(userInput2.get("budget")))
			{
				continue;
			}
			else
			{
				tempCombinationPrice += Double.parseDouble(f.getPrice());
			}
			if (foodStorageList.isEmpty())
			{
				foodStorageList.add(f);
			}
			else
			{
				foodStorageList.clear();
				foodStorageList.add(f);
			}

			if(menu.size() == 0)
			{
				System.out.println("No combination found!!!");
			}
			if(menu.size() == 1)
			{
				if (tempCombinationPrice <= Double.parseDouble(userInput2.get("budget")) && tempPrice> 0)
				{
					tmpFoodCombinationList.add(new Combination(foodStorageList));
					continue;
				}
			}
			else
			{
				calculateCombination(currentMenuCounter, foodStorageList);
				foodStorageList = new ArrayList<Food>();
				tempPrice = 0;
			}
			tempCombinationPrice = 0;
		}
	}

	private static void calculateCombination(int currentMenuCounter, ArrayList<Food> foodStorageList) 
	{	
		if (currentMenuCounter+1 < menu.size()-1)
		{
			for(Food f2 :menu.get(currentMenuCounter+1))
			{
				tempCombinationPrice += Double.parseDouble(f2.getPrice());
				foodStorageList.add(f2);
				calculateCombination(currentMenuCounter+1, foodStorageList);
				foodStorageList.remove(f2);
				tempCombinationPrice -= Double.parseDouble(f2.getPrice());
			}
		}
		else
		{
			for(Food f3 :menu.get(currentMenuCounter+1))
			{
				//double tempPrice;
				tempCombinationPrice += Double.parseDouble(f3.getPrice());
				foodStorageList.add(f3);

				//tempPrice = tempCombinationPrice;

				if (tempCombinationPrice <= Double.parseDouble(userInput.get("budget")) && tempCombinationPrice> 0 && foodStorageList.size() == menu.size())
				{
					tmpFoodCombination.add(foodStorageList);
					ArrayList CopyOffoodStorageList = new ArrayList(foodStorageList);
					Combination combination = new Combination(CopyOffoodStorageList);
					tmpFoodCombinationList.add(combination);
				}

				tempCombinationPrice -= Double.parseDouble(f3.getPrice());
				foodStorageList.remove(f3);
			}
		}
	}
}
