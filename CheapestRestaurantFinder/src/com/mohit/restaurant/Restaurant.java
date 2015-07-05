package com.mohit.restaurant;

import java.util.Set;

public class Restaurant {
	private int id;
	private RestaurantMenu menu;
	
	public Restaurant(Integer restaurantId) {
		this.id=restaurantId;
		this.menu=new RestaurantMenu();
	}
	
	private void setId(int id) {
		this.id = id;
	}
	private void setMenu(RestaurantMenu menu) {
		this.menu = menu;
	}
	public int getId() {
		return id;
	}
	public RestaurantMenu getMenu() {
		return menu;
	}
	
	public void addItemsToMenu(){
		
	}
	public void addItemToMenu(Set<String> foodItems,Float price) {
		this.menu.addMenuItem(foodItems, price);
		
	}

}
