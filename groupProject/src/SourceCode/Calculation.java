package SourceCode;

import java.util.ArrayList;
import java.util.Map;

public class Calculation
{
	private static double tempCombinationPrice = 0;
	private static ArrayList<Combination> tmpFoodCombinationList = new ArrayList<Combination>();
	
	public void calculatePrice(ArrayList<ArrayList<? extends Food>> menu, Map<String, String> userInput2)
	{
		int currentMenuCounter=0;

		ArrayList<Food> foodStorageList = new ArrayList<Food>();

		for (Food f: menu.get(0))
		{
			if (Double.parseDouble(f.getPrice()) > Double.parseDouble(userInput2.get("budget")))
			{
				continue;
			}
			else
			{
				tempCombinationPrice=tempCombinationPrice+Double.parseDouble(f.getPrice());
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
			
			
			if(ImportInformation.getMenu().size() == 1)
			{
				if (tempCombinationPrice <= Double.parseDouble(userInput2.get("budget")))
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

			}

			tempCombinationPrice=0.0;
		}
	}

	public void calculateCombination(int currentMenuCounter, ArrayList<Food> foodStorageList) 
	{	
		for (int i = currentMenuCounter+1; i<ImportInformation.getMenu().size();i++)
		{
			if (i < ImportInformation.getMenu().size()-1)
			{
				for(Food f2 :ImportInformation.getMenu().get(currentMenuCounter+1))
				{
					tempCombinationPrice=tempCombinationPrice+ Double.parseDouble(f2.getPrice());
					foodStorageList.add(f2);
					calculateCombination(currentMenuCounter+1, foodStorageList);
					foodStorageList.remove(f2);
					tempCombinationPrice=tempCombinationPrice- Double.parseDouble(f2.getPrice());
				}
			}
			else
			{
				for(Food f3 :ImportInformation.getMenu().get(currentMenuCounter+1))
				{
					//double tempPrice;
					tempCombinationPrice=tempCombinationPrice+ Double.parseDouble(f3.getPrice());
					foodStorageList.add(f3);
					
					//tempPrice = tempCombinationPrice;
					
					if (tempCombinationPrice <= Double.parseDouble(ImportInformation.getUserInput().get("budget")) && tempCombinationPrice> 0 && foodStorageList.size() == ImportInformation.getMenu().size())
					{
						ImportInformation.addFoodCombination(foodStorageList);
						ArrayList CopyOffoodStorageList = new ArrayList(foodStorageList);
						Combination combination = new Combination(CopyOffoodStorageList);
						tmpFoodCombinationList.add(combination);
					}
					
					tempCombinationPrice=tempCombinationPrice- Double.parseDouble(f3.getPrice());
					foodStorageList.remove(f3);
				}
			}
		}
	}
	
	
	public void getResult()
	{
		for(Combination c :tmpFoodCombinationList)
		{
			c.getCombinationPrice();
			System.out.println();
		}
	}
	
	


}