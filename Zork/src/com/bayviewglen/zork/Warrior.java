package com.bayviewglen.zork;

public class Warrior extends Player {
	private String playerName = Player.name;
	private int strength;
	private int vitality;
	private int intellect;
	private int luck;
	
	public Warrior(){
		super(4,5,2,2);
	}

}
