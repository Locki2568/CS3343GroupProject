package Selector;

import java.util.ArrayList;

public class filterFat implements filterCriteria{
	
	@Override
	public ArrayList<Food> filterByCriteria(ArrayList<Food> foodList , double inputRange) {
		// TODO Auto-generated method stub
		
		ArrayList<Food> newFoodList = new ArrayList<>();
		boolean validChoice;
		
		if(foodList.size() == 0)
			return foodList;
		
		for(Food f : foodList){
			
			boolean validOption = fatIsinRange(f , inputRange);
			
			if(validOption == true)
				newFoodList.add(f);
		}
		
		return newFoodList;
	}
	
	private boolean fatIsinRange(Food food , double inputRange){
		
		boolean valid; double foodFat;
		
		foodFat = food.getFat();
		
		if(foodFat <= inputRange)
			valid = true;
		else
			valid = false;
		
		return valid;
		
	}
}
