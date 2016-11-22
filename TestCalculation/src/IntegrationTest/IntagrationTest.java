package IntegrationTest;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.Test;

import SourceCode.Appetizer;
import SourceCode.Calculation;
import SourceCode.Combination;
import SourceCode.Food;
import SourceCode.Food.foodType;
import SourceCode.ImportInformation;
import SourceCode.MainDish;

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
		Food appetizer = new Appetizer("Salad",Food.foodType.APPETIZER,"55");
		Food mainDish = new MainDish("Beef Enchailada",Food.foodType.MAINDISH,"100");
		exspectedFoodList.add(appetizer);
		exspectedFoodList.add(mainDish);
		exspectedResult.add(new Combination(exspectedFoodList));
		assertEquals(exspectedResult ,calcPrice.getResult());
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

