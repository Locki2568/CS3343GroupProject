package SourceCode;

import java.util.ArrayList;
import java.util.Map;

public class Calculation
{
	private static double tempCombinationPrice = 0;
	private static ArrayList<Combination> tempFoodCombinationList = new ArrayList<Combination>();
	
	public void calculatePrice(ArrayList<ArrayList<? extends Food>> menu, Map<String, String> userInput)
	{
		int currentMenuCounter=0;

		ArrayList<Food> foodStorageList;

		for (Food f: menu.get(0))
		{
			foodStorageList = new ArrayList<Food>();
			foodStorageList.add(f);
			if (Double.parseDouble(f.getPrice()) > Double.parseDouble(userInput.get("budget")))
			{
				continue;
			}
			else
			{
				tempCombinationPrice=tempCombinationPrice+Double.parseDouble(f.getPrice());
			}
			if(ImportInformation.getMenu().size() == 1)
			{
				if (tempCombinationPrice <= Double.parseDouble(userInput.get("budget")))
				{
					tempFoodCombinationList.add(new Combination(foodStorageList));
					continue;
				}
			}
			else
			{
				calculateCombination(currentMenuCounter, foodStorageList);	
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
						tempFoodCombinationList.add(combination);
					}
					
					tempCombinationPrice=tempCombinationPrice- Double.parseDouble(f3.getPrice());
					foodStorageList.remove(f3);
				}
			}
		}
	}
	
	public ArrayList<Combination> getResult()
	{
		return tempFoodCombinationList;
	}
	
}