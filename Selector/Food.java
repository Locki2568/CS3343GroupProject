package Selector;

public class Food {
	
	private double price;
	private double calorie;
	private double fat;
	
	public Food(double inPrice, double inCalorie, double inFat){
		this.price = inPrice;
		this.calorie = inCalorie;
		this.fat = inFat;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public double getCalorie(){
		return this.calorie;
	}
	
	public double getFat(){
		return this.fat;
	}
	
}
