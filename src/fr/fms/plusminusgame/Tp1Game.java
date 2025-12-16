package fr.fms.plusminusgame;

import java.util.Scanner;

public class Tp1Game {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		boolean wantsToPlay = true;

		while(wantsToPlay) {
			System.out.println("Bonjour, voulez vous jouer avec moi ? (Oui/Non)");

			if(sc.next().equalsIgnoreCase("oui")) {
				playGame();
			} else {
				wantsToPlay = false;
				sc.close();
			}
		}
		System.out.println("Au revoir :)");
	}
	
	/*
	 * Game logic handler, rolls a number, asks for inputs and checks them until game is finished.
	 */
	public static void playGame()  {
		int randomNumber = (int)(Math.random() * 100) + 1;
		int counter = 0;
		boolean hasWon = false;
		
		while (!hasWon) {
			System.out.println("Saissisez un nombre entre 1 et 100:");
			if(sc.hasNext()) {
				String guess = sc.next();
				int g;
				try {
					guess = posInteger(guess);
				} catch(Exception e) {
					System.out.println(e.getMessage());
					return;
				} finally {
					g = Integer.valueOf(guess);
				}
				counter++;
				if (g == randomNumber) {
					hasWon = true;
				} else {
					System.out.print("Essayez un chiffre ");
					System.out.println(g > randomNumber ? "plus petit" : "plus grand");
				} 
			}else {
				sc.next();
			}
			if(hasWon) {
				System.out.println("Bravo vous avez gagné en " + counter + " essais");
			}
		} 
	}
	
	
	static private String posInteger(String input) throws NumberCannotBeNegativeException {
		if(Integer.valueOf(input) >= 0) {
			return input;
		} else {
			throw new NumberCannotBeNegativeException("Errr.. number can't be negative.");
		}
	}
	

}
