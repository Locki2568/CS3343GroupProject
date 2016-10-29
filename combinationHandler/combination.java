package combinationHandler;

import java.util.*;
//Import Food packages

public class combination {
	
	private Appretizer appetizer;
	private MainDish mains;
	private Dessert dessert;
	private Drink drink;
	
	public combination(Appretizer aptz, MainDish maind, Dessert dsrt, Drink drk){
		this.appetizer = aptz;
		this.mains = maind;
		this.dessert = dsrt;
		this.drink = drk;
	}
	
	public Appretizer getAppetizer(){
		return this.appetizer;
	}
	
	public MainDish getMainDish(){
		return this.mains;
	}
	
	public Dessert getDessert(){
		return this.dessert;
	}
	
	public Drink getDrink(){
		return this.drink;
	}
	
	
}
