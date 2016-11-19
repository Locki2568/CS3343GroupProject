package controller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import food.Appetizer;
import food.Dessert;
import food.Drinks;
import food.Food;
import food.MainDish;

import menu.Menu;
import function.Calculate;

import exception.*;

public class Main 
{
	public enum foodType
	{
		APPETIZER, DESSERT, DRINKS, MAINDISH
	}

	private static Map<String, String> userInput = new HashMap<String,String>();
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	private static ArrayList<? extends Food> appetizerList = new ArrayList<Appetizer>();
	private static ArrayList<? extends Food> mainDishList = new ArrayList<MainDish>();
	private static ArrayList<? extends Food> drinkList = new ArrayList<Drinks>();
	private static ArrayList<? extends Food> dessertList = new ArrayList<Dessert>();
	private static ArrayList<ArrayList<Food>> tmpFoodCombination = new ArrayList<ArrayList<Food>>();
	private static ArrayList<Combination> tmpFoodCombinationList = new ArrayList<Combination>();
	private static double tempCombinationPrice = 0;
	
	public static void main(String arg[]) throws FileNotFoundException, InputMismatchException{
		
		Menu getInformation = new Menu();
			
		try {
			
			getInformation.importMenu();
			
			userInput=getInformation.importUserInput();

			if(userInput.get("appretizer").equals("true"))
				menu.add(appetizerList);
			if(userInput.get("mainDish").equals("true"))
				menu.add(mainDishList);
			if(userInput.get("drink").equals("true"))
				menu.add(drinkList);
			if(userInput.get("dessert").equals("true"))
				menu.add(dessertList);
				
			
			Calculate calculation = new Calculate();
			calculation.calculatePrice(menu, userInput);
			
			for(Combination c :tmpFoodCombinationList)
			{
				c.getCombinationPrice();
				System.out.println();
			}
			
		} 
		catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} 
		catch (InputMismatchException e) {
			System.out.println("Fuck You");
		}

	}

	public static Map<String, String> getUserInput()
	{
		return userInput;
	}

	public static ArrayList<ArrayList<? extends Food>> getMenu()
	{
		return menu;
	}

	public static void setAppetizerList(ArrayList<Appetizer> appList)
	{
		appetizerList = appList;	
	}
	public static void setMainDishList(ArrayList<MainDish> mainList)
	{
		mainDishList = mainList;	
	}
	public static void setDrinkList(ArrayList<Drinks> drList)
	{
		drinkList = drList;	
	}
	public static void setDessertList(ArrayList<Dessert> deList)
	{
		dessertList = deList;	
	}
	public static void addFoodCombination(ArrayList<Food> foodCombination)
	{
		tmpFoodCombination.add(foodCombination);	
	}
	public static void addFoodCombinationItem(Combination foodCombinationItem)
	{
		tmpFoodCombinationList.add(foodCombinationItem);	
	}
	public static void setCombinationPrice(Double combinationPrice)
	{
		tempCombinationPrice = combinationPrice;	
	}
	
	public static double getCombinationPrice()
	{
		return tempCombinationPrice;	
	}

}
