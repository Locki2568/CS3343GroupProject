package SourceCode;
import java.util.ArrayList;

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
			System.out.print(f.foodName+":  $"+f.getPrice() + " ");
		}
	}
	
	public ArrayList<Food> getFoodCombination()
	{
		return this.foodCombination;
	}
}
