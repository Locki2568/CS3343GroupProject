package SystemTest;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Test;

import SourceCode.Combination;
import SourceCode.Dessert;
import SourceCode.Drink;
import SourceCode.Food;
import SourceCode.Appetizer;
import SourceCode.Main;
import SourceCode.MainDish;

public class SystemTest {
	
	@Test //This is system test
	public void systemTest01() throws Exception
	{	
		// User input : true, true, true, false, 5
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "InvalidFileName";
		Main.main(fileName);
		//No combination found
		String expectedOutput = "File not found...exiting program...";
		assertEquals(true, getOutput().contains(expectedOutput));
	}

	@Test //This is system test
	public void systemTest02() throws Exception
	{	
		// User input : true, false, false, false, 10
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		
		//No combination found	
		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test, Bugs discovered!
	public void systemTest03() throws Exception
	{	
		// User input : false, true, false, false, 100
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output
		
		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput += "Beef Enchailada:  $100";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}
	
	@Test //This is system test, Bugs discovered!
	public void systemTest04() throws Exception
	{	
		// User input : false, false, true, false, 25
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output

		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput += "Coka Cola:  $10";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}
	
	@Test //This is system test, , Bugs discovered!
	public void systemTest05() throws Exception
	{	
		// User input : false, false, false, true, 100
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output

		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput += "Teja:  $85";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test
	public void systemTest06() throws Exception
	{	
		// User input : false, false, true, true, 200
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output

		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput += "Coka Cola:  $10 ";
		expectedOutput += "Teja:  $85";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test
	public void systemTest07() throws Exception
	{	
		// User input : true, true, true, true, 500
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output

		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Import user input complete.";
		expectedOutput += "Salad:  $55 ";
		expectedOutput += "Beef Enchailada:  $100 ";
		expectedOutput += "Coka Cola:  $10 ";
		expectedOutput += "Teja:  $85";
		expectedOutput.trim();
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test
	public void systemTest08() throws Exception
	{	
		// User input : true, true, true, true, 180
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output
		
		//No combination found	
				String expectedOutput = "";
				expectedOutput += "Import completed!!";
				expectedOutput += "Would you like to order appretizer?";
				expectedOutput += "Would you like to order main dish?";
				expectedOutput += "Would you like to order drink?";
				expectedOutput += "Would you like to order dessert?";
				expectedOutput += "Please enter your budget";
				expectedOutput += "Import user input complete.";
				expectedOutput.trim();
				assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}
	
	@Test //This is system test
	public void systemTest09() throws Exception
	{	
		// User input : true, true, false, false 50
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output
		
		//No combination found	
				String expectedOutput = "";
				expectedOutput += "Import completed!!";
				expectedOutput += "Would you like to order appretizer?";
				expectedOutput += "Would you like to order main dish?";
				expectedOutput += "Would you like to order drink?";
				expectedOutput += "Would you like to order dessert?";
				expectedOutput += "Please enter your budget";
				expectedOutput += "Import user input complete.";
				expectedOutput.trim();
				assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test
	public void systemTest10() throws Exception
	{	
		// User input : false, false, false, false, 300
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output
		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Invalid input, please choose atleast one type of food.";
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@Test //This is system test
	public void systemTest11() throws Exception
	{	
		// User input : false, false, true, false, 0
		setOutput();
		String[] fileName = new String[1];
		fileName[0] = "Food_Data_Test1";
		Main.main(fileName);
		// compare the expected String output and the actual output
		String expectedOutput = "";
		expectedOutput += "Import completed!!";
		expectedOutput += "Would you like to order appretizer?";
		expectedOutput += "Would you like to order main dish?";
		expectedOutput += "Would you like to order drink?";
		expectedOutput += "Would you like to order dessert?";
		expectedOutput += "Please enter your budget";
		expectedOutput += "Invalid input, the bugget should be greater than zero.";
		assertEquals(expectedOutput, getOutput().replaceAll("\r\n", ""));
	}

	@After
	public void after() throws Exception
	{
		System.out.println("Running: tearDown");
		Main.reset();
		clearOutput();
	}

	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	private void setOutput() throws Exception {
		oldPrintStream = System.out;
		bos = new ByteArrayOutputStream();
		System.setOut(new PrintStream(bos));
	}

	private void clearOutput()
	{
		oldPrintStream = null;
		bos = null;
	}

	private String getOutput() { // throws Exception
		System.setOut(oldPrintStream);
		return bos.toString().trim();
	}
}

