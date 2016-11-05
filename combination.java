package combinationHandler;

import java.util.*;
//Import Food packages

public class combination {
	
	private Appetizer appetizer;
	private MainDish mains;
	private Dessert dessert;
	private Drink drink;
	
	public combination(){
		this.appetizer = null;
		this.mains = null;
		this.dessert = null;
		this.drink = null;
	}
	
	public combination(Appetizer aptz, MainDish maind, Dessert dsrt, Drink drk){
		this.appetizer = aptz;
		this.mains = maind;
		this.dessert = dsrt;
		this.drink = drk;
	}
	
	public Appetizer getAppetizer(){
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
	
	public void setAppetizer(Appetizer apt){
		this.appetizer = apt;
	}
	
	public void setMain(MainDish main){
		this.mains = main;
	}
	
	public void setAppetizer(Dessert dessert){
		this.dessert = dessert;
	}
	
	public void setAppetizer(Drink drinks){
		this.drink = drinks;
	}
	
}
