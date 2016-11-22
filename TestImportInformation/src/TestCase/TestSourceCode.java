package TestCase;

import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import SourceCode.Appetizer;
import SourceCode.Combination;
import SourceCode.Food;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import java.util.ArrayList;
import SourceCode.Food.foodType;

public class TestSourceCode {

	PrintStream oldPrintStream;
	ByteArrayOutputStream bos;

	@Test
	public void testCombination01() throws Exception
	{
		

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

