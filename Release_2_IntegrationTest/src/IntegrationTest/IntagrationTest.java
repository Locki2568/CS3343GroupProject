package IntegrationTest;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import SourceCode.Calculation;
import SourceCode.Combination;
import SourceCode.Dessert;
import SourceCode.Drink;
import SourceCode.Food;
import SourceCode.Appetizer;
import SourceCode.ImportInformation;
import SourceCode.MainDish;

public class IntagrationTest {

	private PrintStream oldPrintStream;
	private ByteArrayOutputStream bos;

	@Test //This is integration test
	public void testCalculatePrice01() throws Exception
	{	
		// User input : true, false, false, false, 10
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		information.validateInput();
		information.setupMenu();
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		
		ArrayList<Combination> actualCombinationList = calcPrice.getCombinationList();
		assertEquals(exspectedCombinationList, actualCombinationList);
		
		char[] charArr = new char[4];
	}

	@Test //This is integration test
	public void testCalculatePrice02() throws Exception
	{	
		// User input : false, true, false, false, 100
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		information.validateInput();
		information.setupMenu();
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new MainDish("Beef Enchailada",Food.foodType.MAINDISH, "100"));
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));

		int combinationCounter = 0;
		ArrayList<Combination> actualCombinationList = calcPrice.getCombinationList();
		for(Combination actualCombination : actualCombinationList)
		{
			assertEquals(exspectedCombinationList.get(combinationCounter).toString(), actualCombination.toString());
			combinationCounter++;
			//for debug only	System.out.println(actualCombination.toString());
		}
	}

	@Test //This is integration test
	public void testCalculatePrice03() throws Exception
	{	
		// User input : false, false, true, true, 200
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		information.validateInput();
		information.setupMenu();
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Drink("Coka Cola",Food.foodType.DRINKS, "10"));	
		exspectedFoodList.add(new Dessert("Teja",Food.foodType.DESSERT, "85"));
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));

		int combinationCounter = 0;
		ArrayList<Combination> actualCombinationList = calcPrice.getCombinationList();
		for(Combination actualCombination : actualCombinationList)
		{
			assertEquals(exspectedCombinationList.get(combinationCounter).toString(), actualCombination.toString());
			combinationCounter++;
			//for debug only	actualCombination.toString();
		}
	}

	@Test //This is integration test
	public void testCalculatePrice04() throws Exception
	{	
		// User input : true, true, true, true, 500
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		information.validateInput();
		information.setupMenu();
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		// compare the object itself and its side effects instead of String output, the string output can be done in main.
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Appetizer("Salad",Food.foodType.APPETIZER, "55"));
		exspectedFoodList.add(new MainDish("Beef Enchailada",Food.foodType.MAINDISH, "100"));	
		exspectedFoodList.add(new Drink("Coka Cola",Food.foodType.DRINKS, "10"));	
		exspectedFoodList.add(new Dessert("Teja",Food.foodType.DESSERT, "85"));
		ArrayList<Combination> exspectedCombinationList = new ArrayList<Combination>();
		exspectedCombinationList.add(new Combination(exspectedFoodList));

		int combinationCounter = 0;
		ArrayList<Combination> actualCombinationList = calcPrice.getCombinationList();
		for(Combination actualCombination : actualCombinationList)
		{
			assertEquals(exspectedCombinationList.get(combinationCounter).toString(), actualCombination.toString());
			combinationCounter++;
		//for debug only actualCombination.toString();
		}
	}
	
	@Test //This is integration test
	public void testCalculatePrice05() throws Exception
	{	
		// User input : false, false, false, false, 300
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		String expectedOutput = "Invalid input, please choose at least one type of food.";
		setOutput();
		information.validateInput();
		assertEquals(expectedOutput, getOutput());
	}
	
	@Test //This is integration test
	public void testCalculatePrice06() throws Exception
	{	
		// User input : false, false, true, false, 0
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		String expectedOutput = "Invalid input, the bugget should be greater than zero.";
		setOutput();
		information.validateInput();
		assertEquals(expectedOutput, getOutput());
	}
	
	@Test //This is integration test
	public void testCalculatePrice07() throws Exception
	{	
		// User input : false, false, false, true, 1000
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		String expectedOutput = "Import user input complete.";
		setOutput();
		information.validateInput();
		assertEquals(expectedOutput, getOutput());
	}

	@After
	public void after() throws Exception
	{
		System.out.println("Running: tearDown");
		ImportInformation.resetAllInformation();
	}

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}
	
	private void clearOutput()
	{
		oldPrintStream = null;
		bos = null;
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString().trim();
	}
}

