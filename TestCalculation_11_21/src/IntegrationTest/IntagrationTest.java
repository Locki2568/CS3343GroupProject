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
		// compare the object list itself instead of String output, the string output can be done in main.
		ArrayList<Combination> exspectedResult = new ArrayList<Combination>();
		ArrayList<Food> exspectedFoodList = new ArrayList<Food>();
		exspectedFoodList.add(new Food(//food in the text file));
		exspectedFoodList.add(new Food(//food in the text file));
		exspectedResult.add(new Combination(exspectedFoodList));
		assertEquals(exspectedResult ,calcPrice.getResult());
	}
	
	@Test
	public void testCalculatePrice02() throws Exception
	{
		
		ImportInformation information = new ImportInformation();
		information.importMenu("Food_Data_Test1");
		information.importUserInput();
		
		Calculation calcPrice = new Calculation();
		calcPrice.calculatePrice(information.getMenu(),information.getUserInput());
		calcPrice.getResult();
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

