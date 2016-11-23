package SourceCode;

import java.util.ArrayList;

public class Output 
{
	public Output(){}

	public void showCombination(ArrayList<Combination> FoodCombinationList)
	{
		for (Combination c : FoodCombinationList)
		{
			for (Food f : c.getFoodCombination())
			{
				System.out.print(f.foodName+":  $"+f.getPrice() + " ");
			}
		}
	}
}
