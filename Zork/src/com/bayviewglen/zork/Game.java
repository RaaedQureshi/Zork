package com.bayviewglen.zork;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Class Game - the main class of the "Zork" game.
 *
 * Author:  Michael Kolling
 * Version: 1.1
 * Date:    March 2000
 * 
 *  This class is the main class of the "Zork" application. Zork is a very
 *  simple, text based adventure game.  Users can walk around some scenery.
 *  That's all. It should really be extended to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  routine.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates the
 *  commands that the parser returns.
 */

class Game 
{
    private Parser parser;
    private static Scanner keyboard = new Scanner (System.in);
    private Room currentRoom;
    // This is a MASTER object that contains all of the rooms and is easily accessible.
    // The key will be the name of the room -> no spaces (Use all caps and underscore -> Great Room would have a key of GREAT_ROOM
    // In a hashmap keys are case sensitive.
    // masterRoomMap.get("GREAT_ROOM") will return the Room Object that is the Great Room (assuming you have one).
    private HashMap<String, Room> masterRoomMap;
    
    private void initRooms(String fileName) throws Exception{
    	masterRoomMap = new HashMap<String, Room>();
    	Scanner roomScanner;
		try {
			HashMap<String, HashMap<String, String>> exits = new HashMap<String, HashMap<String, String>>();    
			roomScanner = new Scanner(new File(fileName));
			while(roomScanner.hasNext()){
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
				for (String s : rooms){
					temp.put(s.split("-")[0].trim(), s.split("-")[1]);
				}
				
				exits.put(roomName.substring(10).trim().toUpperCase().replaceAll(" ",  "_"), temp);
				
				// This puts the room we created (Without the exits in the masterMap)
				masterRoomMap.put(roomName.toUpperCase().substring(10).trim().replaceAll(" ",  "_"), room);
				
				
				
				// Now we better set the exits.
			}
			
			for (String key : masterRoomMap.keySet()){
				Room roomTemp = masterRoomMap.get(key);
				HashMap<String, String> tempExits = exits.get(key);
				for (String s : tempExits.keySet()){
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

    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        try {
			initRooms("data/Rooms.dat");
			currentRoom = masterRoomMap.get("TOWN_SQUARE");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        parser = new Parser();
    }

    

    /**
     *  Main play routine.  Loops until end of play.
     * @throws InterruptedException 
     */
    public void play() throws InterruptedException 
    {            
        printWelcome();
        printBirth();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished)
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     * @throws InterruptedException 
     */
    private void printWelcome() throws InterruptedException
    {
        System.out.println();
        System.out.println("Long ago, the 4 kingdoms of Elysia were at war.");
        Thread.sleep(1500);
        System.out.println("The four countries: Cambalandia, Algaia, Derelicht, Rodrom engaged in a blood bath that lasted for a hundred years. ");
        Thread.sleep(1500);
        System.out.println("Hundreds of thousands of lives were lost.");
        Thread.sleep(1500);
        System.out.println("Until one day, a hero was born, in a fifth country, much smaller than all the rest and placed inbetween them.");
        Thread.sleep(1500);
        System.out.println("Blessed by and granted the power of the Ancient Gods of Elysia, this hero fought off the legions of the four other countries in a grand final battle dubbed the red night.");
        Thread.sleep(1500);
        System.out.println("When the battle was done, all the remaining peoples of the land of elyssa were ready to bow down to this hero as king, but he refused, and diappeared.");
        Thread.sleep(1500);
        System.out.println("Thus a peace treaty was signed, and the war ended.");
        Thread.sleep(1500);
        System.out.println("As time passed, the story of this hero faded into myth, and was eventually forgotten.");
        Thread.sleep(1000);
        System.out.println("");
        Thread.sleep(1000);
        System.out.println("");
        Thread.sleep(1000);
        System.out.println("");
        Thread.sleep(1000);
        System.out.println("");
        Thread.sleep(1500);
        System.out.println("But one day, the spirit of the hero will be reborn into another.");
        Thread.sleep(1500);
    }
    private void printBirth() throws InterruptedException{
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
    	Thread.sleep(1000);
    	System.out.println("[looking around you stand on a blue platform, floating in the middle of a black emptiness stretching as far as the eye can see]");
    	Thread.sleep(1000);
    	System.out.println("Unknown voice: Quit standing so far away come closer, I don�t have all day");
    	Thread.sleep(1000);
    	System.out.println("[You approach, there is a short man in a black suit sitting at a small desk.]");
    	Thread.sleep(1000);
    	System.out.println("[He is writing something in a large book with a feather quill]");
    	Thread.sleep(1000);
    	System.out.println("Unknown voice: So you�re the one huh?");
    	Thread.sleep(1000);
    	System.out.println("[He stares at you]");
    	Thread.sleep(1000);
    	System.out.println("Unknown voice: My name is Mukhtar, and you, are about to be born.");
    	Thread.sleep(1000);
    	System.out.println("Mukhtar: But before that, we must finalize a few details.");
    	Thread.sleep(1000);
    	System.out.println("Mukhtar: What is your name?");
    	Parser.getPlayerName();
    	System.out.println(Parser.playerName + ", I see, I have a few questionsfor you.");
    	
    	
    	System.out.println(currentRoom.longDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    private boolean processCommand(Command command) 
    {
        if(command.isUnknown())
        {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit"))
        {
            if(command.hasSecondWord())
                System.out.println("Quit what?");
            else
                return true;  // signal that we want to quit
        }else if (commandWord.equals("eat")){
        	System.out.println("Do you really think you should be eating at a time like this?");
        }
        return false;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println("Type 'go' and then your desired direction");
        parser.showCommands();
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord())
        {
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
  
}