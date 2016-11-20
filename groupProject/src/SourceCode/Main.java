package SourceCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Main 
{


	public static void main(String arg[]) 
	{
		ImportInformation getInformation = new ImportInformation();
		try {
			
			getInformation.importMenu("Food_Data");
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found...exiting program...");
			System.exit(0);
		}
			
		getInformation.importUserInput();
		
		Calculation calculation = new Calculation();
		calculation.calculatePrice(getInformation.getMenu(), getInformation.getUserInput());
		calculation.getResult();
		
	}

}
