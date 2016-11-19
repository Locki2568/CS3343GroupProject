package SourceCode;
public abstract class Food 
{
	protected String foodName;
	protected Main.foodType foodType;
	protected String price;
	
	public Food(String foodName, Main.foodType foodType, String price)
	{
		this.foodName = foodName;
		this.foodType = foodType;
		this.price = price;
	}
	
	public abstract String getFoodName();
	
	public abstract Main.foodType getFoodType();
	
	public abstract String getPrice();
}
