package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author: Michael Kolling Version: 1.1 Date: March 2000
 * 
 * This class is the main class of the "Zork" application. Zork is a very
 * simple, text based adventure game. Users can walk around some scenery. That's
 * all. It should really be extended to make it more interesting!
 * 
 * To play this game, create an instance of this class and call the "play"
 * routine.
 * 
 * This main class creates and initialises all the others: it creates all rooms,
 * creates the parser and starts the game. It also evaluates the commands that
 * the parser returns.
 */

class Game {
	private Parser parser;
	private static Player player;
	private static Scanner keyboard = new Scanner(System.in);
	private static Room currentRoom;
	static int evil = 0;
	private static String[] replies = { "What the hell?", "Wrong language", "Please say something that makes sense",
			"L" };

	// This is a MASTER object that contains all of the rooms and is easily
	// accessible.
	// The key will be the name of the room -> no spaces (Use all caps and
	// underscore -> Great Room would have a key of GREAT_ROOM
	// In a hashmap keys are case sensitive.
	// masterRoomMap.get("GREAT_ROOM") will return the Room Object that is the
	// Great Room (assuming you have one).
	private HashMap<String, Room> masterRoomMap;
	private static Inventory playerInventory;

	private void initRooms(String fileName) throws Exception {
		masterRoomMap = new HashMap<String, Room>();
		Scanner roomScanner;
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();
			roomScanner = new Scanner(new File(fileName));
			while (roomScanner.hasNext()) {
				Room room = new Room();
				// Read the Name
				String roomName = roomScanner.nextLine();
				room.setRoomName(roomName.split(":")[1].trim());
				// Read the Description
				String roomDescription = roomScanner.nextLine();
				room.setDescription(roomDescription.split(":")[1].replaceAll("<br>", "\n").trim());
				// Read the Exits
				String roomExits = roomScanner.nextLine();
				// An array of strings in the format E-RoomName
				String[] rooms = roomExits.split(":")[1].split(",");
				HashMap<String, String> temp = new HashMap<String, String>();
				for (String s : rooms) {
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}

				exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ", "_"), temp);

				// This puts the room we created (Without the exits in the
				// masterMap)
				masterRoomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ", "_"), room);

				// Now we better set the exits.
			}

			for (String key : masterRoomMap.keySet()) {
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()) {
					// s = direction
					// value is the room.

					String roomName2 = tempExits.get(s.trim());
					Room exitRoom = masterRoomMap.get(roomName2.toUpperCase().replaceAll(" ", "_"));
					roomTemp.setExit(s.trim().charAt(0), exitRoom);

				}

			}

			roomScanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int calculateHP(int VIT) {
		int vit = VIT;

		int HP = 100 + (VIT * 10);
		return HP;
	}

	public int calculateSP(int INT) {
		int Int = INT;

		int SP = 50 + Int * 5;
		return SP;
	}

	public static int attack(int STR, boolean isPlayerTurn) {
		int str = STR;
		boolean isTargetEnemy = isPlayerTurn;

		int dmg = 10 + str * 7;

		if (isTargetEnemy) {
			Enemy.setEnemyHP(Enemy.getEnemyHP() - dmg);
		} else {
			Player.setPlayerHP(Player.getPlayerHP() - dmg);
		}

		return dmg;

	}

	public static int flipForTurn() {
		int turn = (int) (Math.random() * 2) + 1;

		return turn;
	}

	
	static Player weaponChoice(Command command){
		
	    System.out.println("Type the weapon you want (sword or dagger).");
    	String choice = keyboard.nextLine(); 
    	while (choice.length() == 0){
    		System.out.println("Please enter something.");
    		choice = keyboard.nextLine();
    	}
    	while (choice.compareTo("sword") != 0 && choice.compareTo("dagger") != 0){
    		System.out.println("Please enter a weapon");
    		choice = keyboard.nextLine();
    		
    	}
    	if(choice.compareTo("sword") == 0){
       	  player = new Player(3,5,2,2);
       	 System.out.println("You chose to be a Warrior.");
       	System.out.println("Please, equip the sword. (Type equip and then Sword)");
    	}
	
       	else if (choice.compareTo("dagger") == 0){
       			player = new Player(5,2,3,4);
          		 System.out.println("Well then, you chose to be an Assassin.");	
          		 System.out.println("Please, equip the dagger. (Type equip and then Dagger)");
       		}
       		 
       	


	
		return player;
}

    	
    		
    

    
   
    
    public static void pressAnyKeyToContinue()
    { 
           
           try
           {
               System.in.read();
           }  
           catch(Exception e)
           {}  
    }


	

	

	/**
	 * Create the game and initialize its internal map.
	 */
	public Game() {
		try {
			initRooms("data/Rooms.dat");
			playerInventory = new Inventory();
			currentRoom = masterRoomMap.get("TOWN_SQUARE");
			currentRoom.getRoomInventory().addItem(new Item("sword"));
			currentRoom.getRoomInventory().addItem(new Item("dagger"));

			Room tempRoom = masterRoomMap.get("MARKET");

			tempRoom.getRoomInventory().addItem(new Item("knights longsword"));
			tempRoom.getRoomInventory().addItem(new Item("claymore"));
			tempRoom.getRoomInventory().addItem(new Item("kitetsu"));
			tempRoom.getRoomInventory().addItem(new Item("dragons bane"));
			tempRoom.getRoomInventory().addItem(new Item("assassins daggers"));
			tempRoom.getRoomInventory().addItem(new Item("kitchen knives"));
			tempRoom.getRoomInventory().addItem(new Item("kukri"));
			tempRoom.getRoomInventory().addItem(new Item("yin and yang"));
			
		    tempRoom = masterRoomMap.get("GRAND_BAZAAR");
			tempRoom.getRoomInventory().addItem(new Item("worn shirt"));
			tempRoom.getRoomInventory().addItem(new Item("leather breastplate"));
			tempRoom.getRoomInventory().addItem(new Item("dark armour"));
			tempRoom.getRoomInventory().addItem(new Item("durable pants"));
			tempRoom.getRoomInventory().addItem(new Item("enchanted leggings"));

			
			tempRoom.getRoomInventory().addItem(new Item("steel plated boots"));
			tempRoom.getRoomInventory().addItem(new Item("jordan carhartt x eminem"));
			
		    tempRoom = masterRoomMap.get("SATANIC_TEMPLE");
			tempRoom.getRoomInventory().addItem(new Item("warm coffee"));
			tempRoom.getRoomInventory().addItem(new Item("satanic bible"));
			


			


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser = new Parser();
	}

	/**
	 * Main play routine. Loops until end of play.
	 * 
	 * @throws InterruptedException
	 */
	public void play() throws InterruptedException {
		printWelcome();
		printBirth();

		// Enter the main command loop. Here we repeatedly read commands and
		// execute them until the game is over.

		boolean finished = false;
		while (!finished) {
			Command command = parser.getCommand();
			finished = processCommand(command);
		}
		System.out.println("Thank you for playing.  Good bye.");
	}

	/**
	 * Print out the opening message for the player.
	 * 
	 * @throws InterruptedException
	 */
	private void printWelcome() throws InterruptedException {
		System.out.println();
		System.out.println("Long ago, the 4 kingdoms of Elysia were at war.");
		pressAnyKeyToContinue();
		System.out.println(
				"The four countries: Cambalandia, Algaia, Derelicht, Rodrom engaged in a blood bath that lasted for a hundred years. ");
		pressAnyKeyToContinue();
		System.out.println("Hundreds of thousands of lives were lost.");
		pressAnyKeyToContinue();
		System.out.println(
				"Until one day, a hero was born, in a fifth country, much smaller than all the rest and placed inbetween them.");
		pressAnyKeyToContinue();
		System.out.println(
				"Blessed by and granted the power of the Ancient Gods of Elysia, this hero fought off the legions of the four other countries in a grand final battle dubbed the red night.");
		pressAnyKeyToContinue();
		System.out.println(
				"When the battle was done, all the remaining peoples of the land of elyssa were ready to bow down to this hero as king, but he refused, and diappeared.");
		pressAnyKeyToContinue();
		System.out.println("Thus a peace treaty was signed, and the war ended.");
		pressAnyKeyToContinue();
		System.out.println("As time passed, the story of this hero faded into myth, and was eventually forgotten.");
		pressAnyKeyToContinue();
		System.out.println("But one day, the spirit of the hero will be reborn into another.");
		pressAnyKeyToContinue();
	}

	private void printBirth() throws InterruptedException {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("Unknown voice: You, yes, you.");
		pressAnyKeyToContinue();
		System.out.println(
				"[looking around you stand on a blue platform, floating in the middle of a black emptiness stretching as far as the eye can see]");
		pressAnyKeyToContinue();
		System.out.println("Unknown voice: Quit standing so far away come closer, I don’t have all day");
		pressAnyKeyToContinue();
		System.out.println("[You approach, there is a short man in a black suit sitting at a small desk.]");
		pressAnyKeyToContinue();
		System.out.println("[He is writing something in a large book with a feather quill]");
		pressAnyKeyToContinue();
		System.out.println("Unknown voice: So you’re the one huh?");
		pressAnyKeyToContinue();
		System.out.println("[He stares at you]");
		pressAnyKeyToContinue();
		System.out.println("Unknown voice: My name is Mukhtar, and you, are about to be born.");
		pressAnyKeyToContinue();
		System.out.println("Mukhtar: But before that, we must finalize a few details.");
		pressAnyKeyToContinue();
		System.out.println("Mukhtar: What is your name?");
		Parser.getPlayerName();
		System.out.println(Parser.playerName + ", I see, I have a few questions for you.");

		pressAnyKeyToContinue();
		System.out.println("Mukhtar: What are you most afraid of?");
		System.out.println("1. Losing the ones close to you");
		System.out.println("2. Getting old");
		System.out.println("3. Being useless");
		System.out.println("4. Dying a virgin");
		Parser.quiz(evil);
		System.out.println("Mukhtar: Interesting.");
		pressAnyKeyToContinue();
		System.out.println("What is most important to you?");
		System.out.println("1. Friendship");
		System.out.println("2. Freedom");
		System.out.println("3. The truth");
		System.out.println("4. Fame and riches");
		Parser.quiz(evil);
		System.out.println("Muktar: Hmmm...");
		System.out.println("How do you feel about lying?");
		System.out.println("1. Lying is dishonorable, I NEVER LIE!");
		System.out.println("2. I do my best to avoid it");
		System.out.println("3. It depends on the situation");
		System.out.println("4. I constantly catch myself lying");
		Parser.quiz(evil);
		System.out.println("Is that right.");
		pressAnyKeyToContinue();
		System.out.println(
				"Mukhtar: There is a train running on a single track that branches off, on one track there are 5 people, one the other there is one. What do you do?");
		System.out.println("1. Switch to the track with five people.");
		System.out.println("2. Stay on the track with one person.");
		System.out.println("3. MULTI-TRACK DRIFTING!");
		Parser.quiz(evil);
		System.out.println("Mukhtar: That's all I need to know.");
		pressAnyKeyToContinue();
		System.out.println("I will now put you in a body.");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		Player.intro(evil);

		System.out.println(currentRoom.longDescription());
	}

	/**
	 * Given a command, process (that is: execute) the command. If this command
	 * ends the game, true is returned, otherwise false is returned.
	 */
	private boolean processCommand(Command command) {
		if (command.isUnknown()) {
			System.out.println(replies[(int) ((Math.random() * 4) + 1)]);
			return false;
		}

		String commandWord = command.getCommandWord();
		if (commandWord.equals("help"))
			printHelp();
		else if (commandWord.equals("go"))
			goRoom(command);
		else if (commandWord.equals("quit")) {
			if (command.hasSecondWord())
				System.out.println("Quit what?");
			else
				return true; // signal that we want to quit
		} else if (commandWord.equals("eat")) {
			System.out.println("Do you really think you should be eating at a time like this?");
		} else if (commandWord.equals("equip")) {
			equip(command);
		} else if (commandWord.equals("drop")) {
			drop(command);
		}

		return false;
	}

	private void drop(Command command) {
		if (!command.hasSecondWord()) {
			System.out.println("What do you want to drop?");
			return;
		}
		String itemName = command.getSecondWord();
		for (int i = 0; i < playerInventory.getNumItems(); i++) {
			Item currentItem = playerInventory.getInventory().get(i);
			if ((currentItem != null) && (currentItem.getDescription().equals(itemName))) {
				playerInventory.removeItem(currentItem);
				currentRoom.getRoomInventory().getInventory().add(currentItem);
				i = currentRoom.getRoomInventory().getInventory().size();
				System.out.println(currentItem.getDescription() + " dropped.");
			}
		}
	}

	private static void equip(Command command) {

			 if (!command.hasSecondWord()) {
			 System.out.println("What do you want to equip?");
			 return;
			 }
			 boolean found = false;
			 String itemName = command.getSecondWord();
			 for (int i = 0; i < currentRoom.getRoomInventory().getInventory().size(); i++){
			 Item currentItem = currentRoom.getRoomInventory().getInventory().get(i);
			 
			if ((currentItem != null)&&(currentItem.getDescription().equals(itemName))) {
			playerInventory.addItem(currentItem);
			 currentRoom.getRoomInventory().getInventory().remove(i); 
			 i =currentRoom.getRoomInventory().getInventory().size(); 
			 System.out.println(currentItem.getDescription() + " taken."); 
			 found = true;
			 i--;
			 } 
			if (itemName.equals("sword")){
				currentRoom.getRoomInventory().getInventory().get(i).getDescription().equals("dagger");
				currentRoom.getRoomInventory().getInventory().remove(i);
				Player.strength += 2;
			}if (itemName.equals("dagger")){
				currentRoom.getRoomInventory().getInventory().get(i).getDescription().equals("sword");
				currentRoom.getRoomInventory().getInventory().remove(i);
				Player.luck += 2;
				}
			
			}
			 for (int j = 0; j < playerInventory.getInventory().size(); j ++){
					Item currentItem = playerInventory.getInventory().get(j) ;
				
			 
			 }
			 
			 if (found == false){
			 System.out.println("The items is not in the room, please try again!");
			 }
			 
}
		
		
		
	



	// implementations of user commands:

	/**
	 * Print out some help information. Here we print some stupid, cryptic
	 * message and a list of the command words.
	 */
	private void printHelp() {
		System.out.println("You are lost. You are alone. You wander");
		System.out.println();
		System.out.println("Your command words are:");
		System.out.println("Type 'go' and then your desired direction");
		parser.showCommands();
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new room,
	 * otherwise print an error message.
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			System.out.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = currentRoom.nextRoom(direction);


        if (nextRoom == null)
            System.out.println("There is no door!");
        else 
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.longDescription());
        }
    }




    
   

	private static void scrap() {
		boolean isBattleOver = false;
		int playerHP = Player.getPlayerHP();
		int enemyHP = Enemy.getEnemyHP();
		boolean isPlayerTurn;
		final String[] VALID_COMMANDS = { "ATTACK, AT, A, OBSERVE, OB, O, SKILL, SK, S, ITEM, IT, I" };
		String command = "";

		if (flipForTurn() == 1) {
			isPlayerTurn = true;
		} else {
			isPlayerTurn = false;
		}

		System.out.println("You are now in battle!");

		while (playerHP != 0 || enemyHP != 0) {

			if (!isPlayerTurn) {
				attack(Enemy.getEnemySTR(), isPlayerTurn);
			} else {
				System.out.println("HP: " + Player.getPlayerHP());
				System.out.println("SP: " + Player.getPlayerSP());
				System.out.println("Possible actions: attack, observe, skill, item");
				boolean validCommand = false;
				while (!validCommand) {
					System.out.println("HP: " + Player.getPlayerHP());
					System.out.println("SP: " + Player.getPlayerSP());
					System.out.println("Possible actions: attack, observe, skill, item");
					command = keyboard.nextLine();
					for (int i = 0; i < VALID_COMMANDS.length; i++) {
						if (command.toUpperCase().equals(VALID_COMMANDS[i])) {
							validCommand = true;

						} else {
							System.out.println("I don't know what that is but you can't do it.");
							pressAnyKeyToContinue();
						}

					}

				}

			}

		}

	}

  

   }



