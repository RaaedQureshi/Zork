package com.bayviewglen.zork;

public class Algorithms {
	
	public int calculateHP(int VIT){
		int vit = VIT;
		
		int HP = 100 + (VIT*10);
		return HP;
	}
	
	public int calculateSP(int INT){
		int Int = INT;
		
		int SP = 50 + Int*5;
		return SP;
	}
	
	public int attack(int STR, int HP, boolean isPlayerTurn){
		int str = STR;
		int hp = HP;
		boolean isTargetEnemy = isPlayerTurn;
				
		int dmg = 10 + str*7;
		
		if (isTargetEnemy){
			
		}
		
		
	}

}
