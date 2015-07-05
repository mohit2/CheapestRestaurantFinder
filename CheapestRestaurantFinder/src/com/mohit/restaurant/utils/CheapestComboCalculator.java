package com.mohit.restaurant.utils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mohit.restauant.models.CheapestCombo;

public class CheapestComboCalculator {
	/* Method to calculate cheapest price combo
     * Get the Power Set (in this case, a Set<Set<Set<String>>>) of the menu items (see the getAllMenuCombos method)
     * Iterate over the set and check each set if it contains all the ordered items.
     * If it does contain all the ordered items, check if that set is cheaper than the 
     * current "best solution". If it is, then overwrite the "best solution" with that set.
	 */

	public static CheapestCombo getCheapestPrice(Set<String> orderItems , Map<Set<String>,Float> menuItems) {

		CheapestCombo cheapestCombo = null;

		for (Set<Set<String>> menuCombos : getAllMenuCombos(menuItems.keySet())) {
			float price = 0;
			int size = 0;
			Set<String> menuCombosUnion = new HashSet<String>();
			for (Set<String> menuCombo : menuCombos) {
				menuCombosUnion.addAll(menuCombo);
				price += menuItems.get(menuCombo);
				size += menuCombo.size();
			}

			Set<String> orderIntersection = new HashSet<String>(orderItems);
			orderIntersection.retainAll(menuCombosUnion);

			if (orderIntersection.size() == orderItems.size() && 
					(cheapestCombo == null 
					|| cheapestCombo.getPrice() > price 
					|| (cheapestCombo.getPrice() == price && cheapestCombo.getTotalComboSize() < size))) {
					cheapestCombo = new CheapestCombo(price, new ArrayList<Set<String>>(menuCombos));
				}
		}

		return cheapestCombo;

	}

	private static Set<Set<Set<String>>> getAllMenuCombos(Set<Set<String>> menuItems) {
		Set<Set<Set<String>>> allMenuCombos = new HashSet<Set<Set<String>>>();

		if (menuItems.isEmpty()) {
			Set<Set<String>> empty = new HashSet<>();
			allMenuCombos.add(empty);
		} else {
			List<Set<String>> menuItemsList = new ArrayList<>(menuItems);
			Set<String> comboStart = menuItemsList.get(0);
			Set<Set<String>> remaining = new HashSet<>(menuItemsList.subList(1, menuItemsList.size()));
			for (Set<Set<String>> menuCombo : getAllMenuCombos(remaining)) {
				Set<Set<String>> newSet = new HashSet<>();
				newSet.add(comboStart);
				newSet.addAll(menuCombo);
				allMenuCombos.add(newSet);
				allMenuCombos.add(menuCombo);
			}
		}

		return allMenuCombos;
	}

}

