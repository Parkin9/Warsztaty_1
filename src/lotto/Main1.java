package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		
		Integer[] arr = new Integer[49];
		int[] drawResult = new int[6];
		int[] guess = new int[6]; 
		int choice = 0;
				
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
		Arrays.sort(guess);
		
		pauser(200);
		System.out.println("\nWytypowane przez Ciebie liczby to: "+"\n\t"+Arrays.toString(guess));
		System.out.println("________________________________________");
		pauser(2000);
		System.out.println("\nZa chwilę nastąpi zwolnienie blokady maszyny losującej.");
		pauser(3000);
		System.out.println("\nZwolnienie blokady.");
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		Collections.shuffle(Arrays.asList(arr));
		// array with shuffled numbers, from 1 to 49
		
		pauser(1000);
		System.out.println("Losowanie...");
		pauser(500);
		String loadAnim = "";
		for (int i=0; i<drawResult.length; i++) {
			drawResult[i] = arr[i];
		}
		for (int j=0; j<40; j++) {
			loadAnim = ("|");
			System.out.print(loadAnim);
			pauser(130);
		}
		pauser(800);
		System.out.println("\n\nWylosowane liczby to: \n\t"+Arrays.toString(drawResult));
		
		scan.close();
		int counterWin = 0;
		for (int i=0; i<drawResult.length; i++) {
			for (int j=0; j<guess.length; j++) {
				if (drawResult[i] == guess [j]) {
					counterWin++;
				}
			}
		}
		System.out.println("________________________________________\n");
		pauser(1000);
		if (counterWin == 3) {
			System.out.println("Gratulacje! Trawiłeś \"trójkę\".\nWygrywasz 9 PLN i tonę satysfakcji.");
		} else if (counterWin == 4) {
			System.out.println("Gratulacje! Trawiłeś \"czwórkę\".\nWygrywasz Poloneza - magnes na dupeczki.");
		} else if (counterWin == 5) {
			System.out.println("Gratulacje! Trawiłeś \"piątkę\".\nWygrywasz kosz owoców i coś tam jeszcze.");
		} else if (counterWin == 6) {
			System.out.println("Gratulacje! Trawiłeś \"szóstkę w Totka\".\nWygrywasz wczasy, latawca, cztery korniszony i miliardy Yenów.");
		} else {
			System.out.println("Niestety nieudało Ci się nic wygrać.\nPrzemyśl swoje zachowanie i spróbuj raz jeszcze.");
		}
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
		
		static void pauser(int milisec) {
			try {
				Thread.sleep(milisec);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
}
