package com.bayviewglen.zork;

public class Player {
	
	private String name = Parser.playerName;
	private int playerHealth;
	
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
			System.out.println("Widowed a decade ago, the child’s mother seeked another profession.");
			pressAnyKeyToContinue();
			System.out.println("Her pompous hair seemed surreal when paired with her thin limbs and fragile body.");
			pressAnyKeyToContinue();
			System.out.println("Behind the veil of smoke from her pipe, her heavily caked-up face wore the same smile as usual.");
			
			
		} else{                          // Character is good
			
			System.out.println("In an obscure village lying in the forgotten plains, a child was born");
			pressAnyKeyToContinue();
			System.out.println("His Name");
			pressAnyKeyToContinue();
			System.out.println(Parser.playerName);
			pressAnyKeyToContinue();
			System.out.println("The village was, and his family was poor, but they were happy");
			pressAnyKeyToContinue();
			System.out.println("Him, his father, his mother, and little sister loved together "
					+ "with a few other families in peace");
			pressAnyKeyToContinue();
			System.out.println("Years passed as the child lived a normal life and grew up");
			pressAnyKeyToContinue();
			System.out.println("But everything changed when the empire attacked...");
			pressAnyKeyToContinue();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("You awake to your mother furiously shaking you");
			pressAnyKeyToContinue();
			System.out.println("Mother: You need to run");
			pressAnyKeyToContinue();
			System.out.println("Mother: Now!");
			pressAnyKeyToContinue();
			System.out.println("You hear the sound of screams and horses outside");
			pressAnyKeyToContinue();
			System.out.println("She leads you to the back door");
			pressAnyKeyToContinue();
			System.out.println("Mother: Go to the temple as fast as you can, hide until they leave");
			pressAnyKeyToContinue();
			System.out.println("Mother: Go!");
			pressAnyKeyToContinue();
			System.out.println("She runs off");
			pressAnyKeyToContinue();
			System.out.println("You make your way to the temple");
			pressAnyKeyToContinue();
			System.out.println();
			System.out.println();
			System.out.println("...");
			System.out.println();
			System.out.println();
			pressAnyKeyToContinue();
			System.out.println("Hours have passed since you began hiding");
			pressAnyKeyToContinue();
			System.out.println("The soldiers have set up camp in the village for the night "
					+ "and you cannot get past them until they leave");
			pressAnyKeyToContinue();
			System.out.println("Suddenly you hear a noise in the distance");
			pressAnyKeyToContinue();
			System.out.println("Footsteps!");
			pressAnyKeyToContinue();
			System.out.println("The soldiers have found you, they come closer");
			pressAnyKeyToContinue();
			System.out.println("You look around, there is nowehere to hide");
			pressAnyKeyToContinue();
			System.out.println("Fat Soldier: Well what do we have here");
			pressAnyKeyToContinue();
		}
	}
}
	
	
	


