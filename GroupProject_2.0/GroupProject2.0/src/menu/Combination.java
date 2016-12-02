package menu;
import java.util.ArrayList;

import food.Food;

public class Combination {
	private ArrayList<Food> foodCombination = new ArrayList<Food>();

	public Combination(ArrayList<Food> foodCombination)
	{
		this.foodCombination = foodCombination;
	}

	public String toString()
	{
		String output = "";
		for(Food f : foodCombination)
		{
			output += f.getFoodName() + ":  $"+f.getPrice() + " ";
		}
		return output;
	}
}
