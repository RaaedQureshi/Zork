package com.bayviewglen.zork;

public abstract class Enemy {
	


	private static int enemyHP;
	private int[] stats = new int[2];
	
	public static int getEnemyHP(){
		int HP = Enemy.enemyHP;
		return HP;
	}
	
	public static void setEnemyHP(int HP){
		enemyHP = HP;
	}
	

}
