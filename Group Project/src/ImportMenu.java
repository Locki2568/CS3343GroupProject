public class ImportMenu
{

	public void importMenu() throws FileNotFoundException
	{
		ArrayList<Appetizer> tempAppetizerList = new ArrayList<Appetizer>();
		ArrayList<MainDish> tempMainDishList = new ArrayList<MainDish>();
		ArrayList<Drinks> tempDrinkList = new ArrayList<Drinks>();
		ArrayList<Dessert> tempDessertList = new ArrayList<Dessert>();

		Scanner inFile = new Scanner(new File("Food_Data.txt"));
		while(inFile.hasNextLine())
		{
			String input = inFile.nextLine();
			input.trim();
			String[] inputArray = input.split(",");
			if (inputArray[0].equals(foodType.APPETIZER.toString()))
			{
				tempAppetizerList.add(new Appetizer(inputArray[1],foodType.APPETIZER,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DESSERT.toString()))
			{
				tempDessertList.add(new Dessert(inputArray[1],foodType.DESSERT,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.MAINDISH.toString()))
			{
				tempMainDishList.add(new MainDish(inputArray[1],foodType.MAINDISH,inputArray[2]));
			}
			else if (inputArray[0].equals(foodType.DRINKS.toString()))
			{
				tempDrinkList.add(new Drinks(inputArray[1],foodType.DRINKS,inputArray[2]));
			}
		}

		Main.setAppetizerList(tempAppetizerList);
		Main.setMainDishList(tempMainDishList);
		Main.setDrinkList(tempDrinkList);
		Main.setDessertList(tempDessertList);
		System.out.println("Import completed!!");

	}

}