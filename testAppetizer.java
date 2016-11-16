
public class testAppetizer
{
	public testAppetizer01()
	{	
		Appetizer appetizer=new Appetizer(Salad,APPETIZER,55);
		string name = appetizer.getName();
		assertequals(name,"Salad");
	}
	
	public testAppetizer02()
	{	
		Appetizer appetizer=new Appetizer(Salad,APPETIZER,55);
		string foodType = appetizer.getFoodType();
		assertequals(name,"APPETIZER");
	}

		public testAppetizer03()
	{	
		Appetizer appetizer=new Appetizer(Salad,APPETIZER,55);
		double price = appetizer.getPrice();
		assertequals(price,55);
	}
}
