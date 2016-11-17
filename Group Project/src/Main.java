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
	private static ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();
	private static ArrayList<Combination> tmpFoodCombinationList = new ArrayList<Combination>();
	private static double tempCombinationPrice = 0;
	public static void main(String arg[]) 
	{

		try {

			ImportMenu getMenu = new ImportMenu();
			getMenu.importMenu();

		} catch (FileNotFoundException e) {
			System.out.println("File not found...exiting program...");
			System.exit(0);
		}

		ImportUserInput getUserInput = new ImportUserInput();
		userInput=getUserInput.importUserInput();

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
				
				if (tempCombinationPrice < 0)
				{
					System.out.println("Shit happens!!!");
				}
				foodStorageList = new ArrayList<Food>();
				tempPrice = 0;
			}
			tempCombinationPrice = 0;
		}
	}

	private static void calculateCombination(int currentMenuCounter, ArrayList<Food> foodStorageList) 
	{	
		for (int i = currentMenuCounter+1; i<menu.size();i++)
		{
			if (i < menu.size()-1)
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

	public void setAppetizerList(ArrayList<Appetizer> appList)
	{
		this.appetizerList = appList;	
	}
	public void setMainDishList(ArrayList<MainDish> mainList)
	{
		this.mainDishList = mainList;	
	}
	public void setDrinkList(ArrayList<Drinks> drList)
	{
		this.drinkList = drList;	
	}
	public void setDessertList(ArrayList<Dessert> deList)
	{
		this.dessertList = deList;	
	}

}
