package combinationHandler;

import java.util.*;
import Selector.Food;

public class menuReader {
		
	private ArrayList<Food> appetizerList = null;
	private ArrayList<Food> mainsList = null;
	private ArrayList<Food> dessertList = null;
	private ArrayList<Food> drinkList =null;
	
	private Map<String, String> userChoice;
	
	private ArrayList<combination> Combinations;
		
	private static menuReader instance = new menuReader(ArrayList<ArrayList<Food>> menu , Map<String, String> usrC);
	
	private menuReader(ArrayList<ArrayList<Food>> menu , Map<String, String> usrC){
		
		this.userChoice = usrC;
			
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
		
	public void createCombinations(){
		//generate the combinations
		Combinations = join.JoinArList(this.appetizerList, this.mainsList, this.dessertList, this.drinkList, this.userChoice);
	}
	
	public combination getCombinations(){
		return this.Combinations;
	}
}
