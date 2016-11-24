package TestCase;

public class TestUserInput
{
	public void testUserInput01()
	{
		UserInput userInput = new UserInput("true","false","true","false","200");
		assertEquals("true",userInput.getAppetizer());
	}

	public void testUserInput02()
	{
		UserInput userInput = new UserInput("true","false","true","false","200");
		assertEquals("false",userInput.getMainDish());
	}

	public void testUserInput03()
	{
		UserInput userInput = new UserInput("true","false","true","false","200");
		assertEquals("true",userInput.getDrink());
	}

	public void testUserInput04()
	{
		UserInput userInput = new UserInput("true","false","true","false","200");
		assertEquals("false",userInput.getDessert());
	}

	public void testUserInput05()
	{
		UserInput userInput = new UserInput("true","false","true","false","200");
		assertEquals(200.0,userInput.getBudget());
	}	

}

