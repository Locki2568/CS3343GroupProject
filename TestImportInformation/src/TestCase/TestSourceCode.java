package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import SourceCode.Combination;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import java.util.ArrayList;
import SourceCode.Food.foodType;

public class TestSourceCode {

	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	@Test
	public void testCombination01()
	{
		setOutput();
		ArrayList<Food> foodCombination = new ArrayList<Food>();
		Appetizer appetizer=new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		foodCombination.add(appetizer);
		
		Combination mealCombination = new Combination(foodCombination);
		mealCombination.getCombinationPrice();
		assertEquals("Salad:  $55 ",getOutput());

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

