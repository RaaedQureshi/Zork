package com.bayviewglen.zork;

import java.util.ArrayList;

public class Inventory {
	private static int currentIndex;
	private ArrayList<Item> inventory;
	private static int weight = 0;
	

	public Inventory() {
		inventory = new ArrayList<Item>(); // construct the object
	}

	// how to add an item to a inventory
	public void addItem(Item string) {
			inventory.add(string);
			
		
	}
	
	

	// how to remove an item
	public void removeItem(Item item) {
		currentIndex = inventory.indexOf(item);
		inventory.remove(currentIndex);
		
	}

	// the weight that you currently are carrying
	

	// getter for the inventory arraylist
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	// getter for the number of inventory
	public int getNumItems() {
		return inventory.size();
	}

	// print out the inventory you have
	public String print() {
		String words = "";
		for (int i = 0; i < inventory.size(); i++) {
			if (inventory.get(i) != null) {
				words += inventory.get(i).getDescription() + "\n";
			}
		}
		return words;
	}

	// get the max weight you can carry
	
}
