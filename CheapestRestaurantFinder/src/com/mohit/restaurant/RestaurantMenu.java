package com.mohit.restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RestaurantMenu {

	Map<Set<String>,Float> menuItems = new HashMap<Set<String>,Float>();

	public Map<Set<String>, Float> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Map<Set<String>, Float> menuItems) {
		this.menuItems = menuItems;
	}

	public void addMenuItem(Set<String> item,Float price){
		this.menuItems.put(item, price);

	}

}
