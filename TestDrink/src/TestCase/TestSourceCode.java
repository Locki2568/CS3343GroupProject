package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

import SourceCode.Food;
import SourceCode.Drink;
import SourceCode.Food.foodType;

public class TestSourceCode {

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
	


}

