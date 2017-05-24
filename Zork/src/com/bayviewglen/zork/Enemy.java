package com.bayviewglen.zork;

public abstract class Enemy {
	


	private static int enemyHP;
	private static int STR;
	private static int VIT;
	
	public static int getEnemyHP(){
		int HP = Enemy.enemyHP;
		return HP;
	}
	
	public static int getEnemySTR(){
		int str = STR;
		
		return str;
	}
	
	public static void setEnemyHP(int HP){
		enemyHP = HP;
	}
	

}
