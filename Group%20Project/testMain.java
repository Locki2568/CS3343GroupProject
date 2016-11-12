import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;


public class testMain {
	
	@Test
	public void testMain_01 (){
			class stubMain extends Main
			{
				
				private Map<String, String> userInput = new HashMap<String,String>();
				private ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
				private ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
				private ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
				private ArrayList<? extends Food> drinkList = new ArrayList<Drinks>();
				private ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();
				private ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();
				private ArrayList<Combination> tmpFoodCombinationList = new ArrayList<Combination>();
				private double tempCombinationPrice = 0;
				public void importUserInput(boolean appretizer,boolean mainDish,boolean drink,boolean dessert,double budget){
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
				
				}
				public void stubImportMenu() throws FileNotFoundException
				{
					ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
					ArrayList<MainDish> tempMainDishList = new ArrayList<MainDish>();
					ArrayList<Drinks> tempDrinkList = new ArrayList<Drinks>();
					ArrayList<Dessert> tempDessertList = new ArrayList<Dessert>();

					Scanner inFile = new Scanner(new File("Food_Data_Test.txt"));
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
				private void  StubCalculatePrice(ArrayList<ArrayList<? extends Food>> menu2, Map<String, String> userInput2) {
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
							 StubCalculateCombination(currentMenuCounter, foodStorageList);
							
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

				private void StubCalculateCombination(int currentMenuCounter, ArrayList<Food> foodStorageList) 
				{	
					for (int i = currentMenuCounter+1; i<menu.size();i++)
					{
						if (i < menu.size()-1)
						{
							for(Food f2 :menu.get(currentMenuCounter+1))
							{
								tempCombinationPrice += Double.parseDouble(f2.getPrice());
								foodStorageList.add(f2);
								 StubCalculateCombination(currentMenuCounter+1, foodStorageList);
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
			}
			
			stubMain run = new stubMain();
			try {
				run.stubImportMenu();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			run.importUserInput(true, true, true, true, 100);
			run.menu.add(run.appetizerList);
			run.menu.add(run.mainDishList);
			run.menu.add(run.drinkList);
			run.menu.add(run.dessertList);

			run.StubCalculatePrice(run.menu, run.userInput);
			
			for(Combination c :run.tmpFoodCombinationList)
			{
				c.getCombinationPrice();
				System.out.println();
			}

	}
	
	
}


