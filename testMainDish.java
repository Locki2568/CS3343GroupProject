
public class testMainDish
{
	public testMainDish01()
	{	
		MainDish mainDish=new MainDish(Roast Piggen,MAINDISH,199);
		string name = mainDish.getName();
		assertequals(name,"Roast Piggen");
	}
	
	public testMainDish02()
	{	
		MainDish mainDish=new MainDish(Roast Piggen,MAINDISH,199);
		string foodType = mainDish.getFoodType();
		assertequals(name,"MAINDISH");
	}

	public testMainDish03()
	{	
		MainDish mainDish=new MainDish(Roast Piggen,MAINDISH,199);
		double price = mainDish.getPrice();
		assertequals(price,199);
	}
}
