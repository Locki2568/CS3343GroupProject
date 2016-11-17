public class Calculation
{
	private void calculatePrice(ArrayList<ArrayList<? extends Food>> menu, Map<String, String> userInput2)
	{
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
				Main.setCombinationPrice(Main.getCombinationPrice()+Double.parseDouble(f.getPrice()));
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
			if(Main.getMenu().size() == 1)
			{
				if (Main.getCombinationPrice() <= Double.parseDouble(userInput2.get("budget")) && tempPrice> 0)
				{
					Main.addFoodCombinationItem(new Combination(foodStorageList));
					continue;
				}
			}
			else
			{
				calculateCombination(currentMenuCounter, foodStorageList);
				
				if (Main.getCombinationPrice < 0)
				{
					System.out.println("Shit happens!!!");
				}
				foodStorageList = new ArrayList<Food>();
				tempPrice = 0;
			}

			Main.setCombinationPrice(0);
		}
	}

	private void calculateCombination(int currentMenuCounter, ArrayList<Food> foodStorageList) 
	{	
		for (int i = currentMenuCounter+1; i<Main.getMenu().size();i++)
		{
			if (i < Main.getMenu().size()-1)
			{
				for(Food f2 :Main.getMenu().get(currentMenuCounter+1))
				{
					Main.setCombinationPrice(Main.getCombinationPrice()+ Double.parseDouble(f2.getPrice()));
					foodStorageList.add(f2);
					calculateCombination(currentMenuCounter+1, foodStorageList);
					foodStorageList.remove(f2);
					Main.setCombinationPrice(Main.getCombinationPrice()- Double.parseDouble(f2.getPrice()));
				}
			}
			else
			{
				for(Food f3 :Main.getMenu().get(currentMenuCounter+1))
				{
					//double tempPrice;
					Main.setCombinationPrice(Main.getCombinationPrice()+ Double.parseDouble(f3.getPrice()));
					foodStorageList.add(f3);
					
					//tempPrice = tempCombinationPrice;
					
					if (Main.getCombinationPrice() <= Double.parseDouble(userInput.get("budget")) && Main.getCombinationPrice()> 0 && foodStorageList.size() == Main.getMenu().size())
					{
						Main.addFoodCombination(foodStorageList);
						ArrayList CopyOffoodStorageList = new ArrayList(foodStorageList);
						Combination combination = new Combination(CopyOffoodStorageList);
						Main.addFoodCombinationItem(combination);
					}
					
					Main.setCombinationPrice(Main.getCombinationPrice()- Double.parseDouble(f3.getPrice()));
					foodStorageList.remove(f3);
				}
			}
		}
	}


}