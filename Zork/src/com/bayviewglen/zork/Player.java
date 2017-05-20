package com.bayviewglen.zork;

public abstract class Player {
	
	private String name = Parser.playerName;
	private int playerHealth;
	private int strength = 0;
	private int vitality = 0;
	private int intellect = 0; 
	private int luck = 0;
	
	public Player(int strength, int vitality, int intellect, int luck){
		strength = strength;
		vitality = vitality;
		intellect = intellect;
		luck = luck;
		
		
	}
	
	
	
	private static void pressAnyKeyToContinue()
    { 
           
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }
	
	
	static boolean isEvil (int evil){
		evil = Game.evil;
		if (evil > 32){
		return true;
		}else
			return false;
		
	}

	
	static void intro(int evil){
		evil = Game.evil;
		if (isEvil(evil) == true){       //Character is evil
			System.out.println("In an obscure village lying in the forgotten plains, a child was born.");
		    pressAnyKeyToContinue();
			System.out.println("Widowed a decade ago, the child�s mother seeked another profession.");
			pressAnyKeyToContinue();
			System.out.println("Her pompous hair seemed surreal when paired with her thin limbs and fragile body.");
			pressAnyKeyToContinue();
			System.out.println("Behind the veil of smoke from her pipe, her heavily caked-up face wore the same smile as usual.");
			
			
		} else{                          // Character is good
			
		}
	}
}
	
	
	


