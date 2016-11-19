package controller;
import java.util.ArrayList;

import food.Food;

public class Combination {
	private ArrayList<Food> foodCombination;
	public Combination(ArrayList<Food> foodCombination)
	{
		this.foodCombination = foodCombination;
	}
	
	public void getCombinationPrice()
	{
		for (Food f : this.foodCombination)
		{
			System.out.print(f.getFoodName() +":  $" + f.getPrice() + " ");
		}
	}
}
