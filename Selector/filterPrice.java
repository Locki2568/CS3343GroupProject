package Selector;

import java.util.ArrayList;

public class filterPrice implements filterCriteria {

	@Override
	public ArrayList<Food> filterByCriteria(ArrayList<Food> foodList , double inputRange) {
		// TODO Auto-generated method stub
		
		ArrayList<Food> newFoodList = new ArrayList<>();
		boolean validChoice;
		
		if(foodList.size() == 0)
			return foodList;
		
		for(Food f : foodList){
			
			boolean validOption = priceIsinRange(f , inputRange);
			
			if(validOption == true)
				newFoodList.add(f);
		}
		
		return newFoodList;
	}
	
	private boolean priceIsinRange(Food food , double inputRange){
		
		boolean valid; double foodPrice;
		
		foodPrice = food.getPrice();
		
		if(foodPrice <= inputRange)
			valid = true;
		else
			valid = false;
		
		return valid;
		
	}

}
