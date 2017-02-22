package com.bayviewglen.horseracing;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;




public class HorseRacing1 {
	
    public static void main(String[] args) {
        introMessage();
        
        
        String[] horses = getHorses();
        String[] playerNames = getPlayerNames();
        int[] playerWallets = getPlayersWallets();
        
        boolean gameOver = false;
        while(!gameOver){
                      doRace(horses, playerNames, playerWallets);
                      gameOver = promptForGameOver();
        }
        
        updatePlayerData(playerNames, playerWallets);
        closingMessage();
}



private static void closingMessage() {
	System.out.println("Thank you for playing Horse Racing, I hope you had fun.");
        
}



private static void introMessage() {
	System.out.println("Welcome to Horse Racing!");
        
}



private static void updatePlayerData(String[] playerNames, int[] playerWallets) {
        // TODO Auto-generated method stub
        
}



private static boolean promptForGameOver() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to continue? Yes or no?");
		String response = scanner.nextLine();
		
		while (!(response.charAt(0) == 'Y'  || response.substring.equals('Yes') || response.charAt(0) == 'no' || response.charAt(0) == 'n')){
			System.out.println("Please only respond with Y for yes or N for no.");
			response = scanner.nextLine();
		}
		
		if (response.charAt(0) == 'n' || response.charAt(0) == 'N'){
			return true;
		}
		
		return false;
        
        
        
}

private static int chooseUser(String[] playerNames, int[] playerWallets) throws FileNotFoundException {
    boolean validint = false;
    boolean withinrange = false;
    int playerChoiceInt = 0;
    Scanner scanner = new Scanner(new File("Input/player.dat"));
    while (!validint || !withinrange) {

        System.out.println("Which user are you (enter the corresponding number)?");
        System.out.println("   Name: Wallet");
        for (int i = 0; i < playerNames.length; i++) {
            System.out.println(i + "." + " " + playerNames[i] + ": " + playerWallets[i]);
        }
        String userchoicestring = scanner.nextLine();


        try {
            playerChoiceInt = Integer.parseInt(userchoicestring);
            validint = true;
        } catch (NumberFormatException ex) {
            System.out.println("There is no option for user \"" + userchoicestring + "\"");
        }

        if (playerChoiceInt <= playerNames.length - 1 && playerChoiceInt >= 0) {
            withinrange = true;
        } else {
            System.out.println(playerChoiceInt + " is not within the given range.");
            withinrange = false;
        }
    }

    return playerChoiceInt;

}




private static void doRace(String[] horses, String[] playerNames, int[] playerWallets) {
        // horsesInRace contains the index of the horses from the master horse array
        String[] horsesInRace = getHorsesInRace(horses);
        
        // 2D array with col0 = betAMT and col1 = horseIndex(from horsesInRace)
        int[] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace);
        int winningHorse = startRace(horsesInRace);
        
        payOutBets(playerBets, playerWallets, playerNames, winningHorse);

}



private static void payOutBets(int[] playerBets, int[] playerWallets, String[] playerNames, int winningHorse) {
        // TODO Auto-generated method stub
        
}



private static int startRace(String[] horsesInRace) {
        // TODO Auto-generated method stub
        return 0;
}



private static int[] getPlayerBets(String[] playerNames, int[] playerWallets, String[] horsesInRace) {
        // TODO Auto-generated method stub
    int[] bet = null;

    try {
      Scanner scanner = new Scanner(new File("Input/player.dat"));
      int numPlayers = Integer.parseInt(scanner.nextLine());
      bet = new int[numPlayers];

      for (int i = 0; i < numPlayers; i++) {
        String x = scanner.nextLine();
        String[] parts = x.split(" ");
        bet[i] = Integer.parseInt(parts[1]);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return bet;
}



private static String [] getHorsesInRace(String[] horses) {
        // TODO Auto-generated method stub
    int random = (int) (Math.random() * 4) + 5;
    String[] raceHorses = new String[random];

    for (int i = 0; i < random; i++) {
      boolean isHorseInRace = false;
      while (!isHorseInRace) {
        int horseNum = (int) (Math.random() * horses.length);
        String theHorse = horses[horseNum];
        boolean inRace = alreadyInRace(theHorse, raceHorses);
        if (inRace == false) {
          raceHorses[i] = theHorse;
          isHorseInRace = true;
        }
      }
    }
    return raceHorses;
}



private static int[] getPlayersWallets() {
        // TODO Auto-generated method stub
        int [] playerWallets = null;
        
        try {
  	      Scanner scanner = new Scanner(new File("Input/player.dat"));
  	      int numPlayers = Integer.parseInt(scanner.nextLine());
  	      playerWallets = new int[numPlayers];

  	      for (int i = 0; i < numPlayers; i++) {
  	        String x = scanner.nextLine();
  	        String[] parts = x.split(" ");
  	        playerWallets[i] = Integer.parseInt(parts[1]);
  	      }
  	    } catch (FileNotFoundException e) {
  	      e.printStackTrace();
  	    }
  	    return playerWallets;
  	  }




private static String[] getPlayerNames() {
        // TODO Auto-generated method stub
       String [] playerNames = null;
       try {
 	      Scanner scanner = new Scanner(new File("Input/player.dat"));
	 	      int numPlayers = Integer.parseInt(scanner.nextLine());
 	      playerNames = new String[numPlayers];

 	      for (int i = 0; i < numPlayers; i++) {
 	        String x = scanner.nextLine();
 	        String[] parts = x.split(" ");
 	        playerNames[i] = parts[0];
 	      }
 	    } catch (FileNotFoundException e) {
 	      e.printStackTrace();
 	    }
 	    return playerNames;
 	  }
    	    




/* 
* Reads the horses from a file assume the file exists and is in the format specified in the
* assignment.
*/
public static String[] getHorses(){
        String[] horses = null;
        try {
                      Scanner scanner = new Scanner(new File("input/horses.dat"));
                      int numHorses = Integer.parseInt(scanner.nextLine());
                      horses = new String[numHorses];
                      
                      for (int i = 0; i<numHorses; i++){
                                    horses[i] = scanner.nextLine();
                      }
                      
                      
        } catch (FileNotFoundException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
        }
        
        return horses;
}

/* 
* Check if a horse is already in the race - uses a modified search method
*/
public static boolean alreadyInRace(String theHorse, String[] raceHorses){
        
        for (int i = 0; i < raceHorses.length; i++){
                      if (raceHorses[i] == theHorse){
                                    return true;
                      }
        }
                      
        return false;
}



	}


