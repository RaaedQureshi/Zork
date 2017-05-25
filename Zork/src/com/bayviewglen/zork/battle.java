package com.bayviewglen.zork;


public class battle extends Game{




	public static void battle() {
		boolean isBattleOver = false;
		int playerHP = Player.getPlayerHP();
		int enemyHP = Enemy.getEnemyHP();
		boolean isPlayerTurn;

		if(flipForTurn()==1){
			isPlayerTurn = true;
		}else{
			isPlayerTurn = false;
		}
		
		while(playerHP!=0||enemyHP!=0){
			
			if(!isPlayerTurn){
				attack(Enemy.getEnemySTR(), isPlayerTurn);
			}
				
			
		}
		
		
		

	}

}
