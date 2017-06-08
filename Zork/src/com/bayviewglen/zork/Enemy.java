package com.bayviewglen.zork;

public class Enemy {
	


	private static int enemyHP;
	private static int STR;
	private static int VIT;
	private String name = getEnemyName();
		
	
	
	public Enemy(String name, int strength, int vitality, int enemyHp){
		Enemy.STR = strength;
		Enemy.VIT = vitality;
		Enemy.enemyHP = enemyHp;
	}
	
	
	
	private String getEnemyName() {
		return name;
		
	}
	
	static int getEnemyVIT(){
		return VIT;
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
