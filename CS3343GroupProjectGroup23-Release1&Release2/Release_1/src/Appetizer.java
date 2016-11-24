
public class Appetizer extends Food
{
	public Appetizer(String foodName, Main.foodType foodType, String price)
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
