
/**
 *  This program records the frequency a number appears by a taking the 
 *  sum of two dice rolls.
 *  9-13-16
 *  @author  Joseph Tinglof
 */

import java.util.Random;

public class Prog1a {
	
	public static void main(String[] args) {
		Random rand1 = new Random(256L);          //Creates a new Dice
		
		final int NUM_ELEMENTS = 13;               
		final int NUM_ROLLS = 36000000;           
		int[] diceRolls = new int[NUM_ELEMENTS];  //Creates an array to store frequencies
		int i = 0;                                
		int currentRoll = 0;                     
		
		for(i = 0; i < NUM_ROLLS + 1; i++){       
			currentRoll = (rand1.nextInt(6) + 1) + ((rand1.nextInt(6) + 1)); //Adds the sum of 
			                                                                 //two dice rolls 
			diceRolls[currentRoll]++;
			}
		
		System.out.println("Program 1, Joseph Tinglof, masc0752");
		System.out.printf("Sum" + "%15s\n", "Frequency");
		
		for(i = 2; i < NUM_ELEMENTS; i++){
			System.out.printf(i + "%15s\n", diceRolls[i]); 
		}
		
	}
}
	


