
public class testDessert
{
	public testDessert01()
	{	
		Dessert dessert=new Dessert(Ice Cream,DESSERT,40);
		string name = dessert.getName();
		assertequals(name,"Ice Cream");
	}
	
	public testDessert02()
	{	
		Dessert dessert=new Dessert(Ice Cream,DESSERT,40);
		string foodType = dessert.getFoodType();
		assertequals(name,"DESSERT");
	}

	public testDessert03()
	{	
		Dessert dessert=new Dessert(Ice Cream,DESSERT,40);
		double price = dessert.getPrice();
		assertequals(price,40);
	}
}
