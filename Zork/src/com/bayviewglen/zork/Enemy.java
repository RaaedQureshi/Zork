package com.bayviewglen.zork;

public class Enemy {
	


	private static int enemyHP;
	private static int STR;
	private static int VIT;
	private static int LUCK;
	private static int INTELLECT;
	private String name = getEnemyName();
		
	
	
	public Enemy(String name, int strength, int vitality, int luck, int intellect, int enemyHp){
		Enemy.STR = strength;
		Enemy.VIT = vitality;
		Enemy.LUCK = luck;
		Enemy.INTELLECT = intellect;
		Enemy.enemyHP = enemyHp;
	}
	
	
	
	private String getEnemyName() {
		return name;
		
	}
	
	static int getEnemyHP(){
		return enemyHP;
	}



	public static void setEnemyHP(int enemyHP) {
		enemyHP = enemyHP;
		
	}



	public static int getEnemySTR() {
		return STR;
	}
	
	



	



	
	
	
	

}
