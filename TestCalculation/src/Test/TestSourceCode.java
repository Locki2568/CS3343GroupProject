package Test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.junit.Test;

import SourceCode.Calculation;
import SourceCode.ImportInformation;

public class TestSourceCode {
	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;
	
	
	
	@Test
	public void testCalculatePrice01() throws Exception
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

