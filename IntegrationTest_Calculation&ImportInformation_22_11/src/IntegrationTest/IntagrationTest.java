package IntegrationTest;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import SourceCode.Calculation;
import SourceCode.Combination;
import SourceCode.Food;
import SourceCode.Appetizer;
import SourceCode.ImportInformation;

public class IntagrationTest {
	
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	@Test //This is integration test
	public void testCalculatePrice01() throws Exception
	{		
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();	
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		setOutput();
		calcPrice.getResult();
		assertEquals("Salad:  $55 Beef Enchailada:  $100 " ,getOutput().toString());
	}
	
	@Test //This is integration test
	public void testCalculatePrice02() throws Exception
	{	
		// User input : true, false, false, false, 55
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();	
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Appetizer("Salad",Food.foodType.APPETIZER, "55"));
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));
		
		int combinationCounter = 0;
		int foodCounter = 0;
		for(Combination actualCombination : calcPrice.getResult())
		{
			for(Food actualFood : actualCombination.getFoodCombination())
			{
				assertEquals(exspectedCombinationList.get(combinationCounter).getFoodCombination().get(foodCounter).getFoodName(), actualFood.getFoodName());
				foodCounter++;
			}
			combinationCounter++;
		}
	}
	
	@Test //This is integration test
	public void testCalculatePrice03() throws Exception
	{	
		// User input : false, false, true, true, 55
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();	
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Appetizer("Salad",Food.foodType.APPETIZER, "55"));
		exspectedFoodList.add(new Appetizer("Beef Enchailada",Food.foodType.MAINDISH, "100"));	
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));
		
		int combinationCounter = 0;
		int foodCounter = 0;
		for(Combination actualCombination : calcPrice.getResult())
		{
			for(Food actualFood : actualCombination.getFoodCombination())
			{
				assertEquals(exspectedCombinationList.get(combinationCounter).getFoodCombination().get(foodCounter).getFoodName(), actualFood.getFoodName());
				foodCounter++;
			}
			combinationCounter++;
		}
	}
	
	@Test //This is integration test
	public void testCalculatePrice04() throws Exception
	{	
		// User input : true, true, true, true, 55
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();	
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Appetizer("Salad",Food.foodType.APPETIZER, "55"));
		exspectedFoodList.add(new Appetizer("Beef Enchailada",Food.foodType.MAINDISH, "100"));	
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));
		
		int combinationCounter = 0;
		int foodCounter = 0;
		for(Combination actualCombination : calcPrice.getResult())
		{
			for(Food actualFood : actualCombination.getFoodCombination())
			{
				assertEquals(exspectedCombinationList.get(combinationCounter).getFoodCombination().get(foodCounter).getFoodName(), actualFood.getFoodName());
				foodCounter++;
			}
			combinationCounter++;
		}
	}
	
	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString().trim();
	}
}

