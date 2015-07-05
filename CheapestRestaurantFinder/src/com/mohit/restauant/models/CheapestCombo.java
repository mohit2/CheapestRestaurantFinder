package com.mohit.restauant.models;

import java.util.List;
import java.util.Set;
/*
 * Class to contain response Combo object 
 *
 */
public class CheapestCombo {
	

		private float price;
		List<Set<String>> cheapestPriceCombo;
		private int totalComboSize;

		public CheapestCombo(float price, List<Set<String>> cheapestPriceCombo) {
			this.setPrice(price);
			this.cheapestPriceCombo = cheapestPriceCombo;
			for (Set<String> menuCombo : cheapestPriceCombo) {
				setTotalComboSize(getTotalComboSize() + menuCombo.size());
			}
		}

		@Override
		public String toString() {
			return cheapestPriceCombo + " - " + getPrice();
		}

		public float getPrice() {
			return price;
		}

		public void setPrice(float price) {
			this.price = price;
		}

		public int getTotalComboSize() {
			return totalComboSize;
		}

		public void setTotalComboSize(int totalComboSize) {
			this.totalComboSize = totalComboSize;
		}

	}

