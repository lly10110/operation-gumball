package opgumball;
/**operation gumball fundamentals
 * user chooses # of gumballs to guess
 * user's guess: 
 *   if the guess contains a number in the final solution, a gumball is given:
 *   if the number is in the right spot: GREEN GUMBALL
 *   if the number is in the wrong spot: RED GUMBALL
 * States of gumball guess: 
 *   present in right spot
 *   present in wrong spot
 *   not present
 */
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.LinkedList;

public class gumball {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("# of gumballs:");
		int numofgb = in.nextInt();
		
		
		//generate random sequence
		String sequence = generateSequence(numofgb);
		
		
		int numofguess = 0; boolean correct = false;
		
		while (numofguess < 15 && correct == false) {
			System.out.println();
			System.out.print("Enter your guess: ");
			String guess = in.next();
			
			if (guess.length() == numofgb && guess.matches("[0-9]+")) {
				
				correct = check(guess, sequence, numofgb);
				
				
			} else {
				System.out.println("Guess is invalid "); 
				continue;
			}
			numofguess++;
		}
		
		in.close();
	}

public static Boolean check(String guess, String sequence ,int numofgb) {
		
		LinkedList<Integer> Lguess = new LinkedList<Integer>();
		LinkedList<Integer> Lseq = new LinkedList<Integer>();
		
		for (int i = 0; i < numofgb ; i++) {
			Lguess.add(Character.getNumericValue(guess.charAt(i)));
			Lseq.add(Character.getNumericValue(sequence.charAt(i)));
		}
		
		if (guess.equals(sequence)) {//totally correct
			for (int i = 0; i < numofgb; i++) {
				System.out.print(" GREEN ");
			}
			System.out.println();
			System.out.print("Your guess is correct.");	
			return true;
		}
		
		else {
			for(int i = numofgb-1 ; i >= 0; i--) {
				for (int j = 0 ; j < 10 ; j++) {
					if (Lguess.get(i) == j && Lseq.get(i) == j) {
						numofgb -= 1;
						System.out.print(" GREEN ");
						Lguess.remove(i); Lseq.remove(i);
						break;
					}
					
				}
			}
			for(int i = numofgb-1 ; i >= 0; i--) {
				for (int j = 0 ; j < 10 ; j++) {
					if (Lseq.get(i) == j   && Lguess.contains(j) && Lseq.contains(j)){
						System.out.print(" RED ");
						
						
					}
				}
			}
			
			return false;
		}
	}
		
	
	
	public static String generateSequence(int numofgb) {
		Random rand = new Random();
		int i = 0;
		String sequence = "";
		while (i < numofgb) {
			int j = rand.nextInt(10);
			sequence += String.valueOf(j);
			i++;
		}
		return sequence;
	}
}
