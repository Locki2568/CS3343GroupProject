public class ImportUserInput
{
	public Map<String, String> importUserInput()
	{
		Map<String, String> userInput = new HashMap<String,String>();
		Scanner input = new Scanner(System.in);
		boolean appretizer;
		boolean mainDish;
		boolean drink;
		boolean dessert;
		double budget;

		System.out.println("Would you like to order appretizer?");
		appretizer = input.nextBoolean();
		System.out.println("Would you like to order main dish?");
		mainDish = input.nextBoolean();
		System.out.println("Would you like to order drink?");
		drink = input.nextBoolean();
		System.out.println("Would you like to order dessert?");
		dessert = input.nextBoolean();
		System.out.println("Please enter your budget");
		budget = input.nextDouble();

		userInput.put("appretizer",String.valueOf(appretizer));
		userInput.put("mainDish",String.valueOf(mainDish));
		userInput.put("drink",String.valueOf(drink));
		userInput.put("dessert",String.valueOf(dessert));
		userInput.put("budget", String.valueOf(budget));
		
		if(userInput.get("appretizer").equals("false") && userInput.get("mainDish").equals("false") 
							&& userInput.get("drink").equals("false") && userInput.get("dessert").equals("false"))
		{
			System.out.println("Invalid input, please choose atleast one type of food.");
		}
		else if (Integer.parseInt(userInput.get("budget")) <= 0)
		{
			System.out.println("Invalid input, the bugget should be greater than one.");
		}
		else
		{
			System.out.println("Import user input Complete.");
		}
		
		return userInput;
		
	}







}