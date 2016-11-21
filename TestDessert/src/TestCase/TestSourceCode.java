package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

import SourceCode.Appetizer;
import SourceCode.Food.foodType;

public class TestSourceCode {

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
	


}

