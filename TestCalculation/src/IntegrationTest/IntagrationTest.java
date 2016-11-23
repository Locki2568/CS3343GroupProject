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
		setOutput();
		calcPrice.getResult();
		assertEquals("Salad:  $55 Beef Enchailada:  $100 " ,getOutput().toString());
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

