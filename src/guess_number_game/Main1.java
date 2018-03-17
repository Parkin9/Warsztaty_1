package guess_number_game;

import java.util.Random;
import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		System.out.println("Witam Cię w grze \"Zgadnij o której liczbie myślę\".");
		Scanner scan = new Scanner(System.in);
		
		int rand = randNumbers();
		//System.out.println("Test: "+rand);
		System.out.println("Wpisz liczbę (1-100): ");
		int guess = 0;
		while (true) {
			while (!scan.hasNextInt()) {
	    		scan.next();
	    		System.out.println("To nie jest liczba. Spróbuj jeszcze raz: ");
	    	}
			guess = scan.nextInt();
			
			if (guess > rand) {
				System.out.println("Za dużo.");
			} else if (guess < rand) {
				System.out.println("Za mało.");
			} else if (guess == rand){
				System.out.println("Zgadłeś!");
				break;
			}
			System.out.println("Wpisz liczbę (1-100): ");
		}
		scan.close();
	}
	
		static int randNumbers() {
			Random rand = new Random();
			int rNumber = rand.nextInt(100)+1;
			return rNumber;
		}
}
