package com.bayviewglen.horseracing;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class HorseRacing1 {
	static Scanner input = new Scanner(System.in);
	static String[] horsesInRace = new String[5];
	static int[] playerIndex = new int[3];
	
	public static void main(String[] args) throws InterruptedException, IOException {
		
		introMessage();
		
		File bgm = new File("input/bgm.wav");
		boolean closeMusic = false;
		PlaySound(bgm, closeMusic); // play music
		boolean play = true;
		String[] horses = getHorses();	 //Takes horse information from the input file
		String[] players = getPlayers(); 	//Takes players from the input file
		int[] wallet = getWallet();	 // Takes the player wallets from the input file
		int numPlayers = howManyPlayers();	 // To get amount of players playing
		String[] playersArr = playerName(players, wallet, numPlayers); 	// New array of players that are chosen by users
		int[] newWallets = findWallets(wallet, numPlayers); // Creates new wallets for racing users
		while (play) {
			String[] currentHorse = raceHorses(horses, numPlayers); 	// Takes 5 random race horses and asks users which one they want to bet on
			int bet[] = getBet(currentHorse, newWallets, numPlayers); 	// get player bets
			int winningHorse = displayRace(currentHorse, numPlayers); 	// runs race to find index of winning horse
			afterRace(winningHorse, bet, newWallets, numPlayers); 	//deals with the results of race
			addToFile(players, newWallets, wallet, playersArr, numPlayers); 	// adds results to file
			play = play(); 	//asks user if they want to play again
		}
		closingMessage();;
	}
	
	static void PlaySound(File audio, boolean closeMusic) { // play music
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(audio));
			clip.start();
			while (closeMusic) {
				clip.close();
			}
		} catch (Exception e) {
			System.out.println("");
		}
	}
	
	private static void introMessage() throws InterruptedException {
		System.out.println("Welcome to Horse Racing!");
		Thread.sleep(1000);
		System.out.println("In this game you will chose a player, bet on a horse, and hope your horse wins the race... like gambling");
		Thread.sleep(1000);
		System.out.println("Are you ready?");
		Thread.sleep(1000);

	}
	
	private static void closingMessage() {
		System.out.println("Thank you for playing Horse Racing, I hope you had fun.");

	}


	public static String[] getHorses() {
		String[] horses = null;
		try {
			Scanner scanner = new Scanner(new File("Input/horses.dat"));
			int numHorses = Integer.parseInt(scanner.nextLine());
			horses = new String[numHorses];

			for (int i = 0; i < numHorses; i++) {
				horses[i] = scanner.nextLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return horses;
	}

	public static String[] getPlayers() {
		String[] players = null;
		try {
			Scanner scannerP = new Scanner(new File("Input/player.dat"));
			int numPlayers = Integer.parseInt(scannerP.nextLine());
			players = new String[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				String playersTemp = scannerP.nextLine();
				String[] names = playersTemp.split(" ");
				players[i] = names[0];
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return players;
	}

	public static int[] getWallet() {
		int[] wallet = null;
		try {
			Scanner scannerP = new Scanner(new File("Input/player.dat"));
			int numPlayers = Integer.parseInt(scannerP.nextLine());
			wallet = new int[numPlayers];

			for (int i = 0; i < numPlayers; i++) {
				String walletTemp = scannerP.nextLine();
				String[] nums = walletTemp.split(" ");
				wallet[i] = Integer.parseInt(nums[1]);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return wallet;
	}

	public static boolean alreadyInRace(String horse, String[] horsesChosen) {

			for(int i=0; i<horsesChosen.length; i++){
				if(horse == horsesChosen[i]){
					return true;
				}
			}
		return false;
	}
	
	public static int howManyPlayers() {

		boolean validEntry = false;
		while (!validEntry) {
			System.out.println("How many players will be playing? (Max 3 Players)");
			String strPlayers = input.nextLine();
			int numPlayers = -1;
			try {
				numPlayers = Integer.parseInt(strPlayers);

				if (numPlayers > 0 && numPlayers <= 3) {
					return numPlayers;
				} else if (numPlayers <= 0) {
					System.out.println("There needs to be more players");
				} else {
					System.out.println("Can't have more than 3 people playing...");
				}
			} catch (Exception ex) {
				System.out.println("Please enter a valid number...");
			}
		}
		return 0;
	}

	public static String[] playerName(String[] players, int[] wallet, int numPlayers) throws InterruptedException {
		int player = 0;
		String[] playerArr = new String[numPlayers];
		String input1 = "";
		for (int j = 1; j < 6; j++) {
			System.out.println(j + ". " + players[j-1] + "  >>>  Wallet: " + wallet[j-1]);
		}
		for (int i = 1; i <= numPlayers; i++) {
			boolean valid = false;
			while (!valid) {
				
				System.out.println("Player " + i + ", what player would you like to be? Enter corresponding number!");
				input1 = input.nextLine();
				try {
					player = Integer.parseInt(input1);
					boolean alreadyInRace = alreadyInRace(players[player-1], playerArr);
					if (player > 0 && player < 6 && !alreadyInRace) {
						valid = true;
					}else if(alreadyInRace){
						System.out.println("Player already taken! Choose different player...");
					}
				} catch (Exception ex) {
					System.out.println("Please enter a valid number as listed...");
				}
			}
			if (player == 1) {
				playerArr[i - 1] = players[0];
				playerIndex[i-1] = 0;
			} else if (player == 2) {
				playerArr[i - 1] = players[1];
				playerIndex[i-1] = 1;
			} else if (player == 3) {
				playerArr[i - 1] = players[2];
				playerIndex[i-1] = 2;
			} else if (player == 4) {
				playerArr[i - 1] = players[3];
				playerIndex[i-1] = 3;
			} else if (player == 5) {
				playerArr[i - 1] = players[4];
				playerIndex[i-1] = 4;
			}
		}
		return playerArr;

	}

	public static int[] findWallets(int[] wallets, int numPlayers) {
		int[] newWallets = new int[numPlayers];
		for (int i = 0; i < numPlayers; i++) {
			newWallets[i] = wallets[playerIndex[i]];
		}
		return newWallets;
	}

	public static String[] raceHorses(String[] horses, int numPlayers) {
		String[] horsesChosen = new String[numPlayers];
		String[] tempHorses = new String[5];
		System.out.println("Horses you can bet on:");
		
		for (int i = 1; i < 6; i++) {
			boolean done = false;
			while(!done){
			int tempNum = (int) (Math.random() * horses.length);
			boolean alreadyInRace = alreadyInRace(horses[tempNum], tempHorses);
			if(!alreadyInRace){
			tempHorses[i-1] = horses[tempNum];
			done = true;
			}
			System.out.println(i + ". " + tempHorses[i-1]);
			horsesInRace[i - 1] = tempHorses[i-1];
			}
		}
		
		for (int j = 1; j <= numPlayers; j++) {
			String input1 = "";
			int horseNum = 0;
			boolean valid = false;
			while (!valid) {
				System.out.println(
						"\n Player " + j + " , what horse would you like to bet on? Enter corresponding number!");
				input1 = input.nextLine();
				try {
					horseNum = Integer.parseInt(input1);
					if (horseNum > 0 && horseNum < 6) {
						valid = true;
						}
				}catch (Exception ex) {
					System.out.println("Please enter a valid number as listed...");
				}
			}

			if (horseNum == 1) {
				horsesChosen[j - 1] = horsesInRace[0];
			} else if (horseNum == 2) {
				horsesChosen[j - 1] = horsesInRace[1];
			} else if (horseNum == 3) {
				horsesChosen[j - 1] = horsesInRace[2];
			} else if (horseNum == 4) {
				horsesChosen[j - 1] = horsesInRace[3];
			} else if (horseNum == 5) {
				horsesChosen[j - 1] = horsesInRace[4];
			}
		}
		return horsesChosen;
	}

	public static int[] getBet(String[] currentHorse, int[] wallet, int numPlayers) {
		int bet[] = new int[numPlayers];
		for (int i = 1; i <= numPlayers; i++) {
			boolean validBet = false;
			while (!validBet) {
				System.out.print("Player " + i + ", please enter your bet on " + currentHorse[i - 1] + ", you have "+ wallet[i - 1] + " dollars...");
				String strBet = input.nextLine();

				try {
					bet[i - 1] = Integer.parseInt(strBet);
					if (bet[i - 1] > 0 && bet[i - 1] <= wallet[i - 1]) {
						break;
					} else if (bet[i - 1] <= 0) {
						System.out.println("You need to bet something...");
					} else {
						System.out.println("You don't have that much...");
					}
				} catch (Exception ex) {
					System.out.println("Please enter a valid bet...");
				}
			}
		}
		return bet;
	}

	public static int displayRace(String[] currentHorse, int numPlayers) throws InterruptedException {

		int[] position = new int[horsesInRace.length];
		Thread.sleep(2500);
		boolean finished = false;

		while (!finished) {
			Thread.sleep(200);
			System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
			for (int i = 0; i < horsesInRace.length; i++) {
				System.out.println(
						"---------------------|-----------------------------------------------------------------------------------------------------|");
				System.out.printf("%20s |", horsesInRace[i]);

				if (position[i] < 100) {
					position[i] += (int) (Math.random() * 4);
				}
				for (int j = 0; j < position[i]; j++) {
					System.out.print(" ");
				}

				System.out.printf("%1s \n", i + 1);

			}
			System.out.println(
					"---------------------|-----------------------------------------------------------------------------------------------------|");

			for (int k = 0; k < horsesInRace.length; k++) {
				if (position[k] >= 100) {
					finished = true;
					System.out.println("\n The winner of the race is " + horsesInRace[k] + "!");
				}

				for (int l = 0; l < numPlayers; l++) {
					if (horsesInRace[k].equals(currentHorse[l]) && position[k] >= 100) {
						return l;
					}
				}
			}
		}
		return -1;
	}

	public static void afterRace(int winningHorse, int[] bet, int[] wallet, int numPlayers) throws InterruptedException {

		for (int i = 1; i <= numPlayers; i++) {

			if (winningHorse == i - 1) {
				System.out.println("Player " + i + ", you won!");
				System.out.println(" \t You betted $" + bet[i - 1]);
				wallet[i - 1] += bet[i - 1];
				System.out.println(" \t \t You now have $" + wallet[i - 1]);
			} else {
				System.out.println("Player " + i + ", you lost!");
				System.out.println(" \t You betted $" + bet[i - 1]);
				wallet[i - 1] -= bet[i - 1];
				System.out.println(" \t \t You now have $" + wallet[i - 1]);
			}
			Thread.sleep(500);
		}
	}
	
	public static void addToFile(String[] players, int[] newWallets, int[] wallet, String[] playersArr, int numPlayers) throws IOException{
		
			PrintWriter addToFiler = new PrintWriter(new FileWriter("Input/player.dat"));
			addToFiler.print(players.length);
			for (int i = 0; i <5; i++){
				
				for(int j=0; j<playersArr.length; j++){
					if(playersArr[j] == players[i]){
						wallet[i] = newWallets[j];
					}
				}
				
				addToFiler.write("\n" + players[i] + " " + wallet[i]);
			}
			addToFiler.close();
	    	 
		} 
	
	public static boolean play() {
		String answer = "";
		while (!(answer.equals("y") || answer.equals("yes") || (answer.equals("n") || answer.equals("no")))) {
			System.out.println("Would you like to play again? Please enter 'Y' for yes and 'N' for no.");
			answer = input.nextLine();
			answer.toLowerCase();
		}
		if (answer.equals("n") || answer.equals("no")) {
			return false;
		} else if (answer.equals("y") || answer.equals("yes")) {
			return true;
		}
		return false;

	}
}


