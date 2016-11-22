package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

import SourceCode.Food;
import SourceCode.Food.foodType;
import SourceCode.MainDish;

public class TestSourceCode {

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
	


}

