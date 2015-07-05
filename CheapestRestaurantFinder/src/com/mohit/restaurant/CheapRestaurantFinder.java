package com.mohit.restaurant;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.mohit.restauant.models.CheapestCombo;
import com.mohit.restaurant.utils.*;

public class CheapRestaurantFinder {

	public static void main(String[] args) {
		if (args[0]==null){
			System.out.println("No csv file name entered ! Exiting ");
			System.exit(0);
		} 
		
		float cheapestPrice=-1; 
		int cheapestRestaurantId=-1;
		CheapestCombo cheapestCombo = null;
		Set<String> orderItems=new HashSet<String>();
		/*
		 * Parse the Csv to get all Restaurant objects as a collection
		 */
		Collection<Restaurant> restaurants=CsvParser.parse(args[0]);
		
		//Prepare Order Items Set 
		for(int i=1;i<args.length;i++){
			orderItems.add(args[i]);
		}
		//Iterate all retaurants to fing cheapest combo
		for(Restaurant restaurant:restaurants){
			cheapestCombo = CheapestComboCalculator.getCheapestPrice(orderItems , restaurant.getMenu().getMenuItems());
			
			if (cheapestCombo==null) continue;

			if(cheapestPrice==-1 &&cheapestCombo.getPrice()>0){
				cheapestPrice=cheapestCombo.getPrice();
				cheapestRestaurantId=restaurant.getId();}
			if(cheapestCombo.getPrice()<cheapestPrice){ 
				cheapestPrice=cheapestCombo.getPrice();
				cheapestRestaurantId=restaurant.getId();
			}
		}
		/*
		 * Display result
		 */
		if(cheapestPrice==-1) System.out.println("Nil");
		else
			System.out.println(cheapestRestaurantId+" "+cheapestPrice);
	}
}


