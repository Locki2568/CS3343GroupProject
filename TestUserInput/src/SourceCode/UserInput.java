package SourceCode;

public class UserInput 
{
	private String appetizer;
	private String mainDish;
	private String drink;
	private String dessert;
	double budget = 0;
	
	public UserInput (String appetizer, String mainDish, String drink, String dessert, double budget)
	{
		this.appetizer = appetizer;
		this.mainDish = mainDish;
		this.drink = drink;
		this.dessert = dessert;
		this.budget = budget;
	} 
	
	public UserInput() {}

	public String getAppetizer()
	{
		return this.appetizer;
	}
	
	public String getMainDish()
	{
		return this.mainDish;
	}
	
	public String getDrink()
	{
		return this.drink;
	}
	
	public String getDessert()
	{
		return this.dessert;
	}
	
	public double getBudget()
	{
		return this.budget;
	}
}
