package com.bayviewglen.zork;

public abstract class Enemy {
	
<<<<<<< HEAD
	private int enemyHP;
	private int[] stats = new int[2];
	
	public int getEnemyHP(String Enemy){
		int HP = this.enemyHP;
=======
	private static int enemyHP;
	private int[] stats = new int[2];
	
	public static int getEnemyHP(){
		int HP = Enemy.enemyHP;
>>>>>>> refs/remotes/origin/master
		return HP;
	}
	

}
