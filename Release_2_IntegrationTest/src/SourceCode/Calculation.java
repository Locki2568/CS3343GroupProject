package SourceCode;

import java.util.ArrayList;
import java.util.Map;

public class Calculation
{
	private double tempCombinationPrice = 0;
	private ArrayList<Combination> tempFoodCombinationList = new ArrayList<Combination>();
	private static ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();

	public void calculatePrice(ArrayList<ArrayList<? extends Food>> menu, UserInput userInput)
	{
		int currentMenuCounter=0;

		ArrayList<Food> foodStorageList = new ArrayList<Food>();

		for (Food f: menu.get(0))
		{
			foodStorageList = new ArrayList<Food>();
			foodStorageList.add(f);
			if (Double.parseDouble(f.getPrice()) > userInput.getBudget())
			{
				continue;
			}
			else
			{
				tempCombinationPrice=tempCombinationPrice+Double.parseDouble(f.getPrice());
			}

			if(menu.size() == 1)
			{
				if (tempCombinationPrice <= userInput.getBudget())
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
		if ( (currentMenuCounter+1) < ImportInformation.getMenu().size()-1)
		{
			for(Food f2 :ImportInformation.getMenu().get(currentMenuCounter+1))
			{
				tempCombinationPrice = tempCombinationPrice + Double.parseDouble(f2.getPrice());
				foodStorageList.add(f2);
				calculateCombination(currentMenuCounter+1, foodStorageList);
				foodStorageList.remove(f2);
				tempCombinationPrice = tempCombinationPrice - Double.parseDouble(f2.getPrice());
			}
		}
		else
		{
			for(Food f3 :ImportInformation.getMenu().get(currentMenuCounter+1))
			{
				tempCombinationPrice=tempCombinationPrice+ Double.parseDouble(f3.getPrice());
				foodStorageList.add(f3);

				if (tempCombinationPrice <= ImportInformation.getUserInput().getBudget() && foodStorageList.size() == ImportInformation.getMenu().size())
				{
					tmpFoodCombination.add(foodStorageList);
					ArrayList CopyOffoodStorageList = new ArrayList(foodStorageList);
					Combination combination = new Combination(CopyOffoodStorageList);
					tempFoodCombinationList.add(combination);
				}

				tempCombinationPrice = tempCombinationPrice - Double.parseDouble(f3.getPrice());
				foodStorageList.remove(f3);
			}
		}
	}

	public ArrayList<Combination> getCombinationList()
	{
		return tempFoodCombinationList;
	}
}