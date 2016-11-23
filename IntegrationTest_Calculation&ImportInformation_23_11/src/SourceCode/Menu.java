package SourceCode;

import java.util.ArrayList;

public class Menu 
{
	private static ArrayList<ArrayList<? extends Food>> menu = new ArrayList<ArrayList<? extends Food>>();
	
	public Menu(){}
	
	public void addMenu(ArrayList<? extends Food> foodList)
	{
		menu.add(foodList);
	}
	
	public ArrayList<ArrayList<? extends Food>> getMenu()
	{
		return menu;
	}
}
