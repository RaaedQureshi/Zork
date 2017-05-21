package com.bayviewglen.zork;

public abstract class Player {
	
	private static String name = Parser.playerName;
	private int playerHealth;
	private static int strength = 0;
	private static int vitality = 0;
	private static int intellect = 0; 
	private static int luck = 0;
	
	public Player(int strength, int vitality, int intellect, int luck){
		Player.strength = strength;
		Player.vitality = vitality;
		Player.intellect = intellect;
		Player.luck = luck;
		
		
	}
	
	public void displayPlayerStats() {
		System.out.println("Stats Total: ");
		System.out.println("Strength: " + strength);
		System.out.println("Vitality: " + vitality);
		System.out.println("Intellect: " + intellect);
		System.out.println("Luck: " + luck);
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
		    System.out.println("His name was " + name);
		    pressAnyKeyToContinue();
			System.out.println("Widowed a decade ago, the child’s mother seeked another profession.");
			pressAnyKeyToContinue();
			System.out.println("Her pompous hair seemed surreal when paired with her thin limbs and fragile body.");
			pressAnyKeyToContinue();
			System.out.println("Behind the veil of smoke from her pipe, her heavily caked-up face wore the same smile as usual.");
			pressAnyKeyToContinue();
			System.out.println("She never wanted him.");
			pressAnyKeyToContinue();
			System.out.println("He was simply another mouth to feed, another body to dress.");
			pressAnyKeyToContinue();
			System.out.println("He never asked for this.");
			pressAnyKeyToContinue();
			System.out.println("He hated the way people would look at them.");
			pressAnyKeyToContinue();
			System.out.println("For some, their eyes were filled with desire and lust. While for others, their peering eyes were clouded with shame and disgust.");
			pressAnyKeyToContinue();
			System.out.println("He was rejected by the village day care, the other children would abuse him because he had no one to defend him, he only saw his mother once a day for whatever food she has left for him from her clients. ");
			pressAnyKeyToContinue();
			System.out.println("He couldn’t take it anymore. ");
			pressAnyKeyToContinue();
			System.out.println("He abandoned his past and left the village.");
			pressAnyKeyToContinue();
			
			
		} else{                          // Character is good
			System.out.println("In an obscure village lying in the forgotten plains, a child was born.");
		    pressAnyKeyToContinue();
		    System.out.println("His name was " + name);
		    pressAnyKeyToContinue();
		    System.out.println("The village was small and his family was poor, but they were happy.");
		    pressAnyKeyToContinue();
		    System.out.println("He lived with his father, mother, and little sister lived together with a few other families in peace.");
		    pressAnyKeyToContinue();
		    System.out.println("Years passed as the child lived a normal life and grew up.");
		    pressAnyKeyToContinue();
		    System.out.println("But that all changed when the empire attacked...");
		    pressAnyKeyToContinue();
		    System.out.println("");
		    System.out.println("");
		    System.out.println("");
		    System.out.println("");
		    System.out.println("");
		    System.out.println("");
		    System.out.println("Mother: You need to run.");
		    pressAnyKeyToContinue();
		    System.out.println("You look around afraid");
		    pressAnyKeyToContinue();
		    System.out.println("Mother: Now.");
		    pressAnyKeyToContinue();
		    
		    
		}
	}
}
	
	
	


