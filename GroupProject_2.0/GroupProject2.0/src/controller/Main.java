package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import function.Calculation;
import menu.Combination;


public class Main 
{
	public static void main(String arg[]) 
	{
		ImportInformation information = new ImportInformation();
		try {
			information.importMenu("Food_Data");
			
			information.importUserInput();
			information.validateInput();
			information.setupMenu();
			
			Calculation calculation = new Calculation();
			calculation.calculatePrice(information.getMenu(), information.getUserInput());
			
			if(calculation.getCombinationList().size() > 0)
			{
				for(Combination c : calculation.getCombinationList())
				{
					System.out.println(c.toString());
				}
			}
			else 
			{
				System.out.println("Sorry, no combination statisfy the requirements.");
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found...exiting program...");
			System.exit(0);
		} catch (exception.InputMismatchException e){
			System.out.println(e.getMessage());
		}
		

	}
}
