package combinationHandler;

import java.util.*;

import Selector.Food;

public class join {
	
	public static ArrayList<combination> JoinArList(ArrayList<Food> appetizerList , ArrayList<Food> mainsList,
														ArrayList<Food> dessertList, ArrayList<Food> drinkList , Map<String,String> userC){
		
		ArrayList<combination> combinationList = new ArrayList<combination>;
		
		double remaining_budget = Double.parseDouble((userC.get("budget")));
		combination combinationItem = new combination();
		
		for(Food appetizer : appetizerList){
			
			remaining_budget = remaining_budget - appetizer.getPrice();
			if(remaining_budget > 0){
				combinationItem.setAppetizer(appetizer);
				
				for(Food mains : mainsList){
					
					remaining_budget = remaining_budget - mains.getPrice();
					if(remaining_budget > 0){
						combinationItem.setMains(mains);
						
						for(Food dessert : dessertList){
							
							remaining_budget = remaining_budget - dessert.getPrice();
							if(remaining_budget > 0){
								combinationItem.setDessert(dessert);
								
								for(Food drinks : drinkList){
									
									remaining_budget = remaining_budget - drinks.getPrice();
									if(remaining_budget > 0){
										combinationItem.setDrinks(drinks);
									}
									else
										combinationItem.setDrinks(null);
								}
							
							}
							else
								combinationItem.setDessert(null);
						}
						
					
					}
					else
						combinationItem.setMains(null);
				
				}
		
			}
			else
				combinationItem.setAppetizer(null);
			
		combinationList.add(combinationItem);
		}
		
		return combinationList;
		
	}
	
	
	/*private static ArrayList<ArrayList<Food>> menuJoin;
	private static int menuSize;
	
	public static combination JoinArList(ArrayList<ArrayList<Food>> menu){
		int counter = 0;
		menuJoin = menu;
		menuSize = menu.size();
		for (Food f: menu.get(counter))
		{
			calculation(f,counter);	
			counter ++;
		}
		
	}

	private static void calculation(Food food, int currentIndex) 
	{
		double tempPrice = 0;
		tempPrice = food.getPrice();
			for (int i = 0; i<menuJoin.size(); i++)
			{
				if (i != currentIndex)
				{
					for(Food f : menuJoin.get(i))
					{
						tempPrice += f.getPrice();
						if (tempPrice <= usrC.getBudget() && currentIndex==0)
						{
							new combination(menuJoin.get(currentIndex) )
						}
					}
				}
				tempPrice = food.getPrice();
			}
	}*/
	
}
