package food;
import controller.Main;
import controller.Main.foodType;

public class Drinks extends Food
{
	public Drinks(String foodName, Main.foodType foodType, String price)
	{
		super(foodName,foodType,price);
	}
	
	public String getFoodName()
	{
		return this.foodName;
	}
	
	public Main.foodType getFoodType()
	{
		return this.foodType;
	}
	
	public String getPrice()
	{
		return this.price;
	}
}
