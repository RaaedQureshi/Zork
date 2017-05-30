package com.bayviewglen.zork;

import java.util.Scanner;

public class Player {
	
	protected static String name = Parser.playerName;
	private static int playerHP;
	private static int playerSP;
	static int strength = 0;
    static int vitality = 0;
    static int intellect = 0; 
    static int luck = 0;
	private static Scanner keyboard = new Scanner (System.in);
	
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
	
	public static void setPlayerHP(int HP) {
		playerHP = HP;
		
	}
	
	public static int getPlayerSP(){
		int SP = Player.playerSP;
		
		return SP;
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
			System.out.println("In an obscure village lying in the forgotten plains, a child was born");
		    pressAnyKeyToContinue();
		    System.out.println("His name");
		    pressAnyKeyToContinue();
			System.out.println("" + name);
			pressAnyKeyToContinue();
			System.out.println("The village was small but prosperous. The place was a trading hub for herbs and medicine. The child was the youngest of the 7 children in the family. Their father took care of everything. He took care of the family’s income as an herb collector, as he had flexible work hours he would always be home to cook for the family and clean up after the children. Father was a generous man. He would treat the poor and needy with spare herbs at the end of each week.");
			pressAnyKeyToContinue();
			System.out.println("While collecting a rare specimen of medicine on the cliff side, he lost his footing and fell to his demise.");
			pressAnyKeyToContinue();
			System.out.println("The mother was left to raise all 7 children alone.");
			pressAnyKeyToContinue();
			System.out.println("She never had to do any work at home. She never needed to work.");
			pressAnyKeyToContinue();
			System.out.println("The family did not have many assets as they relied on herbs which were collected each season. The family soon ran out of herbs to sell. Their mother had no option to sell the family estate and live at the village inn.");
			pressAnyKeyToContinue();
			System.out.println("The family’s feeble amount of money could not satisfy the hunger of the 7 young children. Despite her husband’s generosity towards the villagers, they all turned a blind eye to the financial situation of the widowed lady and her children.");
			pressAnyKeyToContinue();
			System.out.println("Winter that year was hard. Mother could not afford to purchase warm clothing for the children. She took her own coat and made jackets for her two youngest children.She smiled as she watched her children move around in their warm winter coats.A blizzard had swept over the village. For days, the snowfall was so thick, no one could differ day from night.");
			pressAnyKeyToContinue();
			System.out.println("It was during this time, their mother fell ill. Her skin pale and shivering. The children tried to warm her up with their over coats as they thought she was shivering from the cold. For days, she had not moved or spoken. Eventually she stopped shivering. She had passed away.");
			pressAnyKeyToContinue();
			System.out.println("Locked in by the snow, the children had no way of getting help. The child watched as his siblings pass away one by one.");
			pressAnyKeyToContinue();
			System.out.println("SISTER:" + name + ", you have to carry on the family name.");
			pressAnyKeyToContinue();
			System.out.println("BROTHER: We have set aside enough rations for you to survive the snow storm.");
		    pressAnyKeyToContinue();
		    System.out.println("SISTER: Don’t worry " + name + ", we are not hungry. We are older, our bodies do not need as much food.");
		    pressAnyKeyToContinue();
			System.out.println("Only after they had passed away along with the blizzard, had the young child realized what his siblings had done for him. There had not been enough food for all of them to get through the storm, only one of them could make it. His brothers and sisters had cut off their own rations to ensure the survival of their youngest sibling...");
			pressAnyKeyToContinue();
			System.out.println("YOU: it was all their fault. The people of this earth are scums. They bowed and showed respect simply because of father’s medicine. Where were they when mother had to raise all of us on their own? WHERE WERE THEY WHEN I HAD TO WATCH MY SIBLINGS DIE IN FRONT OF MY OWN EYES?!");
			pressAnyKeyToContinue();
			System.out.println("Sun rises after the storm had passed. You test the door, the sunlight had melted the ice and snow. With all your strength, you shoved open the door.");
			pressAnyKeyToContinue();
			System.out.println("YOU: I will avenge my family. These scums will come to know the pain of not being able to do anything while their own family die in front of their very eyes.");
			pressAnyKeyToContinue();
			System.out.println("You hear a voice. You look around, there is no one but your dead brothers and sisters lying limp on the ground.");
			pressAnyKeyToContinue();
			System.out.println("UNKNOWN VOICE: The people of this village knew of your situation yet they chose to sit idly in the comfort of their homes. How do you make sense of this? What has humanity become? Tsk.. tsk.. Tsk..");
			pressAnyKeyToContinue();
			System.out.println("Your eyes are filled with rage, hot stream of tears flowed down your frostbitten cheeks.");
			pressAnyKeyToContinue();
			System.out.println("UNKNOWN VOICE: I am here to form a contract, boy. I grant shall grant you my unlimited reserve of power, if you will allow me to use your body as a vessel.");
			pressAnyKeyToContinue();
			System.out.println("You are confused, clouded by rage. All you wished for was power and vengeance.");
			pressAnyKeyToContinue();
			System.out.println("You feel a strange feeling over take you, your head felts like it was being cooked from the inside out.");
			pressAnyKeyToContinue();
			System.out.println("UNKNOWN VOICE: Do not fight it, boy. If thou accept my offer, embrace my presence. My name, is Asura, from this day forth, I will be with you");
			pressAnyKeyToContinue();
			System.out.println("Your head begins to throb");
			pressAnyKeyToContinue();
			System.out.println("ASURA: I art thou, thou art I, with this, a pact is formed. I am reborn, as are you.");
			pressAnyKeyToContinue();
			System.out.println("You have made your way to the town square. No one had bother to ask where your siblings were, they just carried on with their goings.");
			pressAnyKeyToContinue();
			System.out.println("ASURA: Now, show me what you can do!");
			pressAnyKeyToContinue();
			System.out.println("In a fit of rage you screamed and screamed. As you opened your eyes, the whole town square and the villagers had been set ablaze. The villagers had been charred alive. All around you were blazing flames, yet it felt so cold… The breeze felt calming, so peaceful…");
			pressAnyKeyToContinue();
			System.out.println("You laugh hysterically as you witness the feat you have accomplished with a newly acquired power.");
			pressAnyKeyToContinue();
			System.out.println("ASURA: Now listen here kid, I’ve shut off the power for a moment, there’s no use in getting all angry and wasting your energy.");
			pressAnyKeyToContinue();
			System.out.println("ASURA: listen carefully, first thing first grab a weapon from the blacksmith's workshop.");
			pressAnyKeyToContinue();
			System.out.println("You scavenge through the burnt blacksmith shop and see two weapons...");
			pressAnyKeyToContinue();
			System.out.println("A simple looking long sword lies to your left, it’s nothing special but it will prove its durability in combat.");
			pressAnyKeyToContinue();
			System.out.println("A pair of sharp daggers stuck in the mud to your left, there is a certain charm to them beyond their sharp looking aesthetics.");
			pressAnyKeyToContinue();
			System.out.println("ASURA: Which will you choose, boy? ");
			String secondWord = keyboard.nextLine();
			Command command = new Command ("equip", secondWord );
			Game.weaponChoice(command);
		
			
			
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
		    System.out.println("Tall: You little prick, you’re gonna pay for that.");
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
		    String secondWord = keyboard.nextLine();
			Command command = new Command ("equip", null );
			Game.weaponChoice(command);
			
		    
		    
		    
		}
	}

	
}
	
	
	


