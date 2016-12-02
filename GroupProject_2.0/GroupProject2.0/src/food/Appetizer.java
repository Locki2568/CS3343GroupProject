package food;
public class Appetizer extends Food
{
	public Appetizer(String foodName, foodType foodType, String price)
	{
		super(foodName,foodType,price);
	}
	
	public String getFoodName()
	{
		return this.foodName;
	}
	
	public foodType getFoodType()
	{
		return this.foodType;
	}
	
	public String getPrice()
	{
		return this.price;
	}
}
