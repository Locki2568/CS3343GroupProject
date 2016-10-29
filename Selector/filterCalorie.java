package Selector;

import java.util.ArrayList;

public class filterCalorie implements filterCriteria{

	@Override
	public ArrayList<Food> filterByCriteria(ArrayList<Food> foodList , double inputRange) {
		// TODO Auto-generated method stub
		
		ArrayList<Food> newFoodList = new ArrayList<>();
		boolean validChoice;
		
		if(foodList.size() == 0)
			return foodList;
		
		for(Food f : foodList){
			
			boolean validOption = calorieIsinRange(f , inputRange);
			
			if(validOption == true)
				newFoodList.add(f);
		}
		
		return newFoodList;
	}
	
	private boolean calorieIsinRange(Food food , double inputRange){
		
		boolean valid; double foodCalorie;
		
		foodCalorie = food.getCalorie();
		
		if(foodCalorie <= inputRange)
			valid = true;
		else
			valid = false;
		
		return valid;
		
	}
}
