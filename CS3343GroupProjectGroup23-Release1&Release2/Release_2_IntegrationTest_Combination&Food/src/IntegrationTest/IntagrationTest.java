package IntegrationTest;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import SourceCode.Appetizer;
import SourceCode.Combination;
import SourceCode.Dessert;
import SourceCode.Drink;
import SourceCode.Food;
import SourceCode.Food.foodType;
import SourceCode.MainDish;

public class IntagrationTest {

	@Test //This is integration test & loop coverage test, 0 loop
	public void testImportInformation01() throws Exception
	{	
		ArrayList<Food> actualFoodList = new ArrayList<Food>();
		Combination actualCombination = new Combination(actualFoodList);
		
		String expectedOutput = "";
		assertEquals(expectedOutput, actualCombination.toString());
	}

	@Test //This is integration test & loop coverage test, 1 loop
	public void testImportInformation02() throws Exception
	{	
		ArrayList<Food> actualFoodList = new ArrayList<Food>();
		Food food = new Appetizer("Salad",foodType.APPETIZER,"55");
		actualFoodList.add(food);
		Combination actualCombination = new Combination(actualFoodList);
		
		String expectedOutput = "";
		expectedOutput += food.getFoodName() + ":  $"+food.getPrice() + " "; 
		assertEquals(expectedOutput, actualCombination.toString());
	}

	@Test //This is integration test & loop coverage test, >1 loops
	public void testImportInformation03() throws Exception
	{	
		ArrayList<Food> actualFoodList = new ArrayList<Food>();
		Food food1 = new Appetizer("Salad",foodType.APPETIZER,"55");
		Food food2 = new MainDish("Beef Enchailada",foodType.MAINDISH,"100");
		Food food3 = new Drink("Coka Cola",foodType.DRINKS,"10");
		Food food4 = new Dessert("Teja",foodType.DESSERT,"85");
		actualFoodList.add(food1);
		actualFoodList.add(food2);
		actualFoodList.add(food3);
		actualFoodList.add(food4);
		Combination actualCombination = new Combination(actualFoodList);
		
		String expectedOutput = "";
		expectedOutput += food1.getFoodName() + ":  $"+food1.getPrice() + " "; 
		expectedOutput += food2.getFoodName() + ":  $"+food2.getPrice() + " "; 
		expectedOutput += food3.getFoodName() + ":  $"+food3.getPrice() + " "; 
		expectedOutput += food4.getFoodName() + ":  $"+food4.getPrice() + " "; 
		assertEquals(expectedOutput, actualCombination.toString());
	}
}

