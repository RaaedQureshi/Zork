package com.bayviewglen.horseracing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HorseRacing {

	public static void main(String[] args) {
		introMessage();
		Scanner input = new Scanner(System.in);
		
		Scanner scanner = new Scanner(System.in);

		String [] horses = getHorses();
		String [] playerNames = getPlayerNames();
		int [] playerWallets = getPlayerWallets();
		String [] horsesInRace = raceHorses(horses);
		
		int[][] playerBets = new int[playerNames.length][horsesInRace.length];
		playerBets = getBet(playerNames, playerWallets, horsesInRace);
		
		
		
		boolean gameOver = false;
		while (!gameOver){
			doRace(horses, playerNames, playerWallets);
			gameOver = promptForGameOver();
		}
		
		updatePlayerData(playerNames, playerWallets);
		closingMessage();
		

	}
	
	
	private static int[] getPlayerWallets() {
		
		int[] wallet = null;

	    try {
	      Scanner scanner = new Scanner(new File("Input/player.dat"));
	      int numPlayers = Integer.parseInt(scanner.nextLine());
	      wallet = new int[numPlayers];

	      for (int i = 0; i < numPlayers; i++) {
	        String x = scanner.nextLine();
	        String[] parts = x.split(" ");
	        wallet[i] = Integer.parseInt(parts[1]);
	      }
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    return wallet;
	  }
	


	private static String[] getPlayerNames() {
		// TODO Auto-generated method stub
		String[] names = null;

	    try {
	      Scanner scanner = new Scanner(new File("Input/player.dat"));
	      int numPlayers = Integer.parseInt(scanner.nextLine());
	      names = new String[numPlayers];

	      for (int i = 0; i < numPlayers; i++) {
	        String x = scanner.nextLine();
	        String[] parts = x.split(" ");
	        names[i] = parts[0];
	      }
	    } catch (FileNotFoundException e) {
	      e.printStackTrace();
	    }
	    return names;
	  }
	
	private static String [] raceHorses (String[] horses) {
		int x = (int) (Math.random() * 4) + 5;
	    String[] raceHorses = new String[x];

	    for (int i = 0; i < x; i++) {
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
	
	private static boolean alreadyInRace(String theHorse, String[] raceHorses) {

	    for (int i = 0; i < raceHorses.length; i++) {
	      if (theHorse.equalsIgnoreCase(raceHorses[i])) {
	        return true;
	      }
	    }
	    return false;
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
		System.out.println("Would you like to continue? Y/N");
		Scanner keyboard = new Scanner(System.in);
		String response = keyboard.nextLine();
		
		while (!(response.charAt(0) == 'Y'  || response.charAt(0) == 'N' || response.charAt(0) == 'y' || response.charAt(0) == 'n')){
			System.out.println("Please only respond with Y for yes or N for no.");
			response = keyboard.nextLine();
		}
		
		if (response.charAt(0) == 'n' || response.charAt(0) == 'N'){
			return true;
		}
		
		return false;
	}


	private static void doRace(String[] horses, String[] playerNames, int[] playerWallets) {
		// horsesInRace contains the index of the horses from the master horse array
		int [] horsesInRace = getHorsesInRace(horses);
		
		// 2D array with column 0 = bet and comlumn 1 = horseIndex (from horsesInRace)
		int [][] playerBets = getPlayerBets(playerNames, playerWallets, horsesInRace);
		int winningHorse = startRace(horsesInRace);
		
		payOutBets(playerBets, playerWallets, playerNames, winningHorse);
		
	}


	private static void payOutBets(int[][] playerBets, int[] playerWallets, String[] playerNames, int winningHorse) {
		// TODO Auto-generated method stub
		
	}


	private static int startRace(int[] horsesInRace) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	


	private static int[][] getPlayerBets(String[] playerNames, int[] playerWallets, int[] horsesInRace) {
		// TODO Auto-generated method stub
		
		int[][] bet = new int[playerNames.length][horsesInRace.length];

	    boolean choosePlayer = false;

	    while (!choosePlayer) {
	      displayPlayers(playerNames, playerWallets);
	      System.out.print("\nPlease choose a player: ");

	      int playerIndex = choosePlayer(playerNames, playerWallets, horsesInRace);
	      int amountOfBet = individualPlayerBet(bet, playerIndex, playerNames, playerWallets, horsesInRace);

	      if (amountOfBet != 0) {
	        int horseIndex = ChooseHorse(playerIndex, horsesInRace, playerNames);
	        bet[playerIndex][horseIndex] += amountOfBet;
	        System.out.println(playerNames[playerIndex] + ", you have placed a bet of $" + bet[playerIndex][horseIndex] + " on horse " + horsesInRace[horseIndex] + ".");
	      }
	      choosePlayer = continueChosing();
	    }
	    return bet;
	  }

	private static void displayPlayers(String[] playerNames, int[] playerWallets) {
		// TODO Auto-generated method stub
		 System.out.println();
		    System.out.printf("%1s%1s%16s%1s%16s%1s\n", "#", "|", "  Player Names  ", "|", " Player Wallets ", "|");
		    for (int i = 0; i < playerNames.length; i++) {
		      System.out.printf("%1s%1s%16s%1s%16s%1s\n", "~", "|", "~~~~~~~~~~~~~~~~", "|", "~~~~~~~~~~~~~~~~", "|");
		      System.out.printf("%1s%1s%16s%1s%16s%1s\n", i + 1, "|", playerNames[i], "|", playerWallets[i], "|");
		    }

		
	}


	private static int choosePlayer(String[] playerNames, int[] playerWallets, int[] horsesInRace, Scanner input) {
		// TODO Auto-generated method stub
		int playerIndex = -1;
	    boolean checkingName = false;

	    while (!checkingName) {
	      String nameEntered = input.nextLine();
	      boolean ifInteger = isInteger (nameEntered);

	      if (ifInteger) {
	        int x = Integer.parseInt(nameEntered);
	        for (int i = 0; i < playerNames.length; i++) {
	          if (i == x - 1) {
	            playerIndex = i;
	          }
	        }
	      } else {
	        for (int i = 0; i < playerNames.length; i++) {
	          if (playerNames[i].equalsIgnoreCase(nameEntered)) {
	            playerIndex = i;
	          }
	        }
	      }
	
	}


	private static int individualPlayerBet(int[][] bet, int playerIndex, String[] playerNames, int[] playerWallets,
			int[] horsesInRace) {
		// TODO Auto-generated method stub
		  System.out.print(playerNames[playerIndex] + ", you have $" + playerWallets[playerIndex]
			        + ", how much would you want to bet? (Note: Any bet that is not a whole number will be converted to whole number) ");
			    Double money = 0.0;
			    int wallet = playerWallets[playerIndex];

			    boolean betting = false;

			    if (wallet == 0) {
			      System.out.println("You have $0! You cannot bet anymore!");
			      return 0;
			    }

			    while (!betting) {
			      String userBet = scanner.nextLine();
			      try {
			        money = Double.parseDouble(userBet);
			        betting = true;

			        if (money > wallet) {
			          System.out.print("You don't have that much money... : ");
			          betting = false;
			        } else if (money < 1 && money > 0) {
			          System.out.print("You must bet a integer quantity of money: ");
			          betting = false;
			        } else if (money == 0) {
			          System.out.print("You must bet some amount! Enter new bet: ");
			          betting = false;
			        } else if (money <= 0) {
			          System.out.print("You cannot bet a negative amount of money!: ");
			          betting = false;
			        } else {
			          betting = true;
			        }

			      } catch (NumberFormatException ex) {
			        if ("Quit".equalsIgnoreCase(userBet)) {
			          money = 0.0;
			          betting = true;
			        } else {
			          System.out.print("That is not a valid input! Please enter how much you want to bet: ");
			        }
			      }
			    }

			    int moneyINT = money.intValue();
			    playerWallets[playerIndex] -= moneyINT;

			    return moneyINT;
			  }
	}

	}


	private static boolean isInteger (String nameEntered) {
		// TODO Auto-generated method stub
		return false;
	}


	private static int[] getHorsesInRace(String[] horses) {
		// TODO Auto-generated method stub
		return null;
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
	} public static boolean alreadyInRace(int horse, int[] horsesInRace){
		
		for (int i = 0; i < horsesInRace.length; i++){
			if (horsesInRace[i] == horse){
				return true;
			}
		}
			
		return false;
	}
}


