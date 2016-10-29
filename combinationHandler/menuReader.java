package combinationHandler;

import java.util.*;
import Selector.Food;

public class menuReader {
		
	private ArrayList<Food> appetizerList;
	private ArrayList<Food> mainsList;
	private ArrayList<Food> dessertList;
	private ArrayList<Food> drinkList;
	
	private combination Combinations;
		
	private static menuReader instance = new combinations(ArrayList<ArrayList<Food>> menu);
	
	private menuReader(ArrayList<ArrayList<Food>> menu){
			
		for(ArrayList<Food> m : menu){
				
			//get the first element for type checking
			Food type = m.get(0);
				
			if(String.valueOf(type.getClass()) == "Appetizer")
				this.appetizerList = m;
			else if (String.valueOf(type.getClass()) == "MainDish")
				this.mainsList = m;
			else if (String.valueOf(type.getClass()) == "Dessert")
				this.dessertList = m;
			else if (String.valueOf(type.getClass()) == "Drink")
				this.drinkList = m;
				//error handling
		}
	} 
		
	public menuReader getInstance(){
		return this.instance;
	}
		
	public static void createCombinations(){
		//generate the combinations
		Combinations = join.JoinArList(this.appetizer, this.mains, this.dessert, this.drink);
	}
	
	public combination getCombinations(){
		return this.Combinations;
	}
}
