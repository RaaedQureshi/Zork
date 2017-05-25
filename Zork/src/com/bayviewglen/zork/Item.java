package com.bayviewglen.zork;

import java.util.ArrayList;

public class Item {
	private String description;
	 private int mass;
	 
	 //create getters and setters
	 public String getDescription() {
	 return description;
	 }
	 public void setDescription(String description) {
	 this.description = description;
	 }
	 public int getMass() {
	 return mass;
	 }
	 public void setMass(int mass) {
	 this.mass = mass;
	 }
	 
	 public Item(String description, int mass) {
	 super();
	 this.description = description;
	 this.mass = mass;
	 }
	 public Item(String description) {
	 super();
	 this.description = description;
	 this.mass = 0;
	 }
	
	
	 private ArrayList<Item> items;
	    //construct the item you want in a room (you can add more if it is needed. e.g, Item itemFour)
	     public void setItems(Item itemOne, Item ItemTwo, Item itemThree){
	     items = new ArrayList<Item>();
	     items.add(itemOne);
	     items.add(ItemTwo);
	     items.add(itemThree);
	     }
	     //remove an item from the room
	     public void removeItem(Item item){
	     int currentIndex = items.indexOf(item);
	     items.remove(currentIndex);
	     }
	     // print the item you have in a room
	     public String printItems(){
	     String itemsDescription = "";
	     for (int i = 0; i < items.size(); i++){
	     if (items.get(i)!= null){
	     itemsDescription += items.get(i).getDescription()+" ";
	     }
	     }
	 return itemsDescription;
	     }
	     //getter for the arraylist
	     public ArrayList<Item> getItems(){
	     return items;
	     }
	//check whether a room has item
	    public boolean hasItems(){
	     boolean hasItems = true;
	     int count = 0;
	     for(int i = 0; i <items.size();i++){
	     if (items.get(i)==null){
	     count++;
	     }
	     }
	     if (count == items.size()){
	     hasItems = false;
	     }
	     return hasItems;
	    }
	    /**
	     * Return a long description of this room, on the form:
	     *     You are in the kitchen.
	     *     Exits: north west
	     */
	    //i also changed the way to display the description...
	    public String longDescription()
	    {
	      if(hasItems() == true){
	     return description.replaceAll("<br>", "\n")+ "\n"  + "The following items are avaliable: "+ printItems() + "\n" + toString();
	      }else{
	       return description.replaceAll("<br>", "\n")+ "\n"   + toString();
	      }
	     }

}
