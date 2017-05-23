package com.bayviewglen.zork;

public abstract class Player {
	
	private static String name = Parser.playerName;
	private static int playerHP;
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
	
	public static int getPlayerHP(){
		int HP = Player.playerHP;
		
		return HP;
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
		    System.out.println("You hear the sound of screams and horses outside, understanding the situation you follow her orders.");
		    pressAnyKeyToContinue();
		    System.out.println("She leads you to the back door and is about to send you off");
		    pressAnyKeyToContinue();
		    System.out.println("Mother: Go to the temple as fast as you can, hide until they leave.");
		    pressAnyKeyToContinue();
		    System.out.println("You grab her when she turns to leave");
		    pressAnyKeyToContinue();
		    System.out.println("Mother: Go!");
		    pressAnyKeyToContinue();
		    System.out.println("She runs off");
		    pressAnyKeyToContinue();
		    System.out.println("You leave make your way to the temple.");
		    pressAnyKeyToContinue();
		    System.out.println("…");
		    pressAnyKeyToContinue();
		    System.out.println("Hours have passed as you sit in the temple, to afraid to sleep");
		    pressAnyKeyToContinue();
		    System.out.println("The soldiers have set up camp in the village for the night and you cannot get past them until they leave");
		    pressAnyKeyToContinue();
		    System.out.println("Suddenly you hear a noise in the distance");
		    pressAnyKeyToContinue();
		    System.out.println("Footsteps!");
		    pressAnyKeyToContinue();
		    System.out.println("The soldiers have found you!");
		    pressAnyKeyToContinue();
		    System.out.println("They come closer and closer");
		    pressAnyKeyToContinue();
		    System.out.println("You look around but there is nowhere to hide");
		    pressAnyKeyToContinue();
		    System.out.println("Fat Soldier: Well what do we have here");
		    pressAnyKeyToContinue();
		    System.out.println("You try to run but the Tall soldier grabs you by the collar.");
		    pressAnyKeyToContinue();
		    System.out.println("Tall Soldier: Where you running to?");
		    pressAnyKeyToContinue();
		    System.out.println("Fat Soldier: Let’s take ‘im back to to the cart with the other kids");
		    pressAnyKeyToContinue();
		    System.out.println("Tall Soldier: wait a minute, this one looks kind of similar to-");
		    pressAnyKeyToContinue();
		    System.out.println("Fat Soldier: That woman!");
		    pressAnyKeyToContinue();
		    System.out.println("Tall Soldier: Hehe, you hear that kid, your mother was quite accommodating to us, we weren’t expecting that from some plains savages");
		    pressAnyKeyToContinue();
		    System.out.println("Out of anger you kick the soldier in the groin, he reels in pain.");
		    pressAnyKeyToContinue();
		    System.out.println("Tall: You little fucker, you’re gonna pay for that.");
		    pressAnyKeyToContinue();
		    System.out.println("He throws you against the wall, you fall to the ground and cough up blood");
		    pressAnyKeyToContinue();
		    System.out.println("As you try to regain your breath he picks you up and puts you against the wall");
		    pressAnyKeyToContinue();
		    System.out.println("Tall Soldier: I changed my mind, I’m gonna kill this one");
		    pressAnyKeyToContinue();
		    System.out.println("He pulls out a knife");
		    pressAnyKeyToContinue();
		    System.out.println("You close your eyes and prepare for the end");
		    pressAnyKeyToContinue();
		    System.out.println("He thrusts the knife forward a--");
		    pressAnyKeyToContinue();
		    System.out.println("Suddenly time freezes, staring at the tip of the knife you hear another noise");
		    pressAnyKeyToContinue();
		    System.out.println("A voice this time");
		    pressAnyKeyToContinue();
		    System.out.println("Unknown Voice: Hahaha, it seems you’re in quite the situation boy");
		    pressAnyKeyToContinue();
		    System.out.println("Unknown Voice: It seems you are finally ready to forge a contract");
		    pressAnyKeyToContinue();
		    System.out.println("Unknown Voice: My name, is Raiden, from this day forth, I will be with you");
		    pressAnyKeyToContinue();
		    System.out.println("Your head begins to throb");
		    pressAnyKeyToContinue();
		    System.out.println("Raiden: I art thou, thou art I, with this, a pact is formed");
		    pressAnyKeyToContinue();
		    System.out.println("Time restarts and the two soldiers are blown away from you by a giant force");
		    pressAnyKeyToContinue();
		    System.out.println("They both smash against the altar and are impaled by stone shards");
		    pressAnyKeyToContinue();
		    System.out.println("Lightning crackles around you");
		    pressAnyKeyToContinue();
		    System.out.println("Remembering the rest of your village you rush out to the village square");
		    pressAnyKeyToContinue();
		    System.out.println("A group of soldiers sit around a fire with dead bodies of men and women littered all around");
		    pressAnyKeyToContinue();
		    System.out.println("Raiden: Now, show me what you can do");
		    pressAnyKeyToContinue();
		    System.out.println("In a fit of rage you send streams of lightning at them all, killing them instantly");
		    pressAnyKeyToContinue();
		    System.out.println("Suddenly another soldier returns from the forest to find the scene");
		    pressAnyKeyToContinue();
		    System.out.println("He draws his sword and positions to fight you");
		    pressAnyKeyToContinue();
		    System.out.println("You try to do the same to him as the others but the power won’t come");
		    pressAnyKeyToContinue();
		    System.out.println("Raiden: Now listen here kid, I’ve shut off the power for a moment, there’s no use in getting all angry and wasting your energy");
		    pressAnyKeyToContinue();
		    System.out.println("Raiden: listen carefully, first thing first grab a weapon from off the ground.");
		    pressAnyKeyToContinue();
		    System.out.println("You look around and see two weapons");
		    pressAnyKeyToContinue();
		    System.out.println("A simple looking long sword lies to your left, it’s nothing special but it will stand in combat");
		    pressAnyKeyToContinue();
		    System.out.println("A pair of sharp daggers stuck in the mud to your left, there is a certain charm to them beyond aesthetics");
		    pressAnyKeyToContinue();
		    System.out.println("Raiden: Which will you choose?");
		    
		    
		    
		}
	}
}
	
	
	


