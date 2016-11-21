package SourceCode;
public abstract class Food 
{
	protected String foodName;
	protected foodType foodType;
	protected String price;
	
	public enum foodType
	{
		APPETIZER, DESSERT, DRINKS, MAINDISH
	}
	
	public Food(String foodName, foodType foodType, String price)
	{
		this.foodName = foodName;
		this.foodType = foodType;
		this.price = price;
	}
	
	public abstract String getFoodName();
	
	public abstract foodType getFoodType();
	
	public abstract String getPrice();
}
