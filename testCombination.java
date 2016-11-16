import java.util.ArrayList;

public class testCombination {
	ArrayList<Food> foodCombination = new ArrayList<Food>();
	Appetizer appetizer=new Appetizer(Salad,APPETIZER,50);
	foodCombination.add(appetizer);
	
	Combination mealCombination = new Combination(foodCombination);
	
	assertequals(mealCombination.getCombinationPrice(),"Salad: $50 ");

}
