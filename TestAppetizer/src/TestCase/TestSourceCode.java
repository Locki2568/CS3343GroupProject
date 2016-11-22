package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;
import SourceCode.Food;
import SourceCode.Appetizer;
import SourceCode.Food.foodType;

public class TestSourceCode {

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
	


}

