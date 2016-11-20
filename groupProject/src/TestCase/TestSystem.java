package TestCase;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import SourceCode.Appetizer;
import SourceCode.Calculation;
import SourceCode.Combination;
import SourceCode.Dessert;
import SourceCode.Drink;
import SourceCode.Food;
import SourceCode.ImportInformation;
import SourceCode.MainDish;
import SourceCode.Main;
import SourceCode.Food.foodType;
import static org.junit.Assert.*;

public class TestSystem {
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;
	
	//Test for Appetizer
	@Test
	public void testAppetizer01()
	{	
		
		Appetizer appetizer=new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		String name = appetizer.getFoodName();
		assertEquals(name,"Salad");
	}
	@Test
	public void testAppetizer02()
	{	
		Appetizer appetizer=new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		foodType foodType = appetizer.getFoodType();
		assertEquals(foodType,Food.foodType.APPETIZER);
	}
	@Test
	public void testAppetizer03()
	{	
		Appetizer appetizer=new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		String price = appetizer.getPrice();
		assertEquals(price,"55");
	}
	
	//Test for Dessert
	@Test
	public void testDessert01()
	{	
		Dessert dessert=new Dessert("Ice Cream",Food.foodType.DESSERT,"40");
		String name = dessert.getFoodName();
		assertEquals(name,"Ice Cream");
	}
	@Test
	public void testDessert02()
	{	
		Dessert dessert=new Dessert("Ice Cream",Food.foodType.DESSERT,"40");
		foodType foodType = dessert.getFoodType();
		assertEquals(foodType,Food.foodType.DESSERT);
	}
	@Test
	public void testDessert03()
	{	
		Dessert dessert=new Dessert("Ice Cream",Food.foodType.DESSERT,"40");
		String price = dessert.getPrice();
		assertEquals(price,"40");
	}
	
	//Test for Drink
	@Test
	public void testDrinks01()
	{	
		Drink drinks=new Drink("Water",Food.foodType.DRINKS,"12");
		String name = drinks.getFoodName();
		assertEquals(name,"Water");
	}
	@Test
	public void testDrinks02()
	{	
		Drink drinks=new Drink("Water",Food.foodType.DRINKS,"12");
		foodType foodType = drinks.getFoodType();
		assertEquals(foodType,Food.foodType.DRINKS);
	}
	@Test
	public void testDrinks03()
	{	
		Drink drinks=new Drink("Water",Food.foodType.DRINKS,"12");
		String price = drinks.getPrice();
		assertEquals(price,"12");
	}
	
	//Test for MainDish
	@Test
	public void testMainDish01()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Food.foodType.MAINDISH,"199");
		String name = mainDish.getFoodName();
		assertEquals(name,"Roast Piggen");
	}
	@Test
	public void testMainDish02()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Food.foodType.MAINDISH,"199");
		foodType foodType = mainDish.getFoodType();
		assertEquals(foodType,Food.foodType.MAINDISH);
	}
	@Test
	public void testMainDish03()
	{	
		MainDish mainDish=new MainDish("Roast Piggen",Food.foodType.MAINDISH,"199");
		String price = mainDish.getPrice();
		assertEquals(price,"199");
	}
	
	//Test for combination
	@Test
	public void testCombination01()
	{
		ArrayList<Food> foodCombination = new ArrayList<Food>();
		Appetizer appetizer=new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		foodCombination.add(appetizer);
		
		
		Combination mealCombination = new Combination(foodCombination);
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		mealCombination.getCombinationPrice();
		assertEquals("Salad:  $55 ",outContent.toString());

	}
	
	//Test for ImportInformation
	@Test
	public void testImportMenu01() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		menu.importMenu("Food_Data_Test1");
		assertEquals("Import completed!!",getOutput());
	}
	
	@Test
	public void testImportMenu02() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		menu.importMenu("Food_Data_Test2");
		assertEquals("Import completed!!", getOutput());
	}
	
	@Test
	public void testImportMenu03() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		menu.importMenu("Food_Data_Test3");
		assertEquals("Import completed!!",getOutput());
	}

	@Test
	public void testImportMenu04() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		menu.importMenu("Food_Data_Test4");
		assertEquals("Import completed!!",getOutput());
	}
	
	
	// Test for ImportUserInput

	public void testimportUserInput01()
	{
		ImportInformation menu = new ImportInformation();
		Map<String, String> userInput = new HashMap<String,String>();
		userInput.put("budget", "100.0" );
		userInput.put("drink", "true" );
		userInput.put("mainDish", "true" );
		userInput.put("appretizer", "true" );
		userInput.put("dessert", "true" );
		
		assertEquals(userInput, menu.importUserInput());
	}

	public void testimportUserInput02() throws Exception
	{
		//true true true true 100.0
		setOutput();
		ImportInformation menu = new ImportInformation();
		Map<String, String> userInput = new HashMap<String,String>();
		userInput=menu.importUserInput();
		assertEquals("Import user input Complete.",getOutput());
		
	}
	

	public void testimportUserInput03() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		Map<String, String> userInput = new HashMap<String,String>();
		userInput=menu.importUserInput();
		assertEquals("Invalid input, the bugget should be greater than one.",getOutput());
	}
	

	public void testimportUserInput04() throws Exception
	{
		setOutput();
		ImportInformation menu = new ImportInformation();
		menu.importUserInput();
		assertEquals("Invalid input, please choose at least one type of food.",getOutput());
	}
	
	//Test for calculateCombination

	//Test for calculatePrice

	@Test
	public void testCalculatePrice01() throws FileNotFoundException
	{
		
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		
		
	}
	
	

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString();
	}
	
	
}
