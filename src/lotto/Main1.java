package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		int[] arr = new int[49];
		int[] guess = new int[6]; 
		int choice = 0;
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}
		Collections.shuffle(Arrays.asList(arr));
		// array with shuffled numbers, from 1 to 49
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\tWitam Cię w \"LOTTO - The Game\".\n\nWytypuj 6 liczb i sprawdź czy szczęście Ci sprzyja.\nLiczby muszą być wybrane z zakresu 1-49.\n\tPowodzenia!\n");
						
		for (int i=0; i<guess.length; i++) {
			System.out.print("Podaj "+(i+1)+". liczbę: ");
			while (!scan.hasNextInt()) {
	    		scan.next();
	    		System.out.println("To nie jest liczba. Spróbuj jeszcze raz.");
	    		System.out.print("Podaj "+(i+1)+". liczbę: ");
	    	}
			// checking if the user's Ints are numbers at all
			
			choice = scan.nextInt();			
			if ((choice <= 49) && (choice >= 1)) {
				if (!checkValue(guess, choice)) {
					guess[i] = choice;
				} else {
					System.out.println("Wytypowałeś już tę liczbę. Musisz podać inną.");
					i--;
				}
			} else {
				System.out.println("Typowana liczba wykracza poza zakres 1-49. Musisz podać inną.");
				i--;
			}
		}
		
		System.out.println(Arrays.toString(guess)); //test line
		
		scan.close();
	}
	
		static boolean checkValue(int[] tab, int search) {
			for (int i=0; i<tab.length; i++) {
				if (tab[i] == search) {
					return true;
				}
			}
			return false;
		}
		// method checks if the number is in the array
		
//		static String counterShots() {
//			String str = "";
//			for (int i=0; i<=6; i++) {
//				str = ("Podaj "+i+". liczbę: ");
//				return str;
//			}
//		}
}
