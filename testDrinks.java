
public class testDrinks
{
	public testDrinks01()
	{	
		Drinks drinks=new Drinks(Water,DRINKS,12);
		string name = drinks.getName();
		assertequals(name,"Water");
	}
	
	public testDrinks02()
	{	
		Drinks drinks=new Drinks(Water,DRINKS,12);
		string foodType = drinks.getFoodType();
		assertequals(name,"DRINKS");
	}

	public testDrinks03()
	{	
		Drinks drinks=new Drinks(Water,DRINKS,12);
		double price = drinks.getPrice();
		assertequals(price,12);
	}
}
