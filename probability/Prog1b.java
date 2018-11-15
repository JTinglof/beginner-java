
/**
 *  Program #1b
 *  This program records the frequency a specific dice rolls 
 *  occurs when two dice are rolled.
 *  CS108-2
 *  9-13-16
 *  @author  Joseph Tinglof
 */

import java.util.Random;

public class Prog1b {

	public static void main(String[] args) {
		Random rand1 = new Random(256L); 
		
		final int NUM_ROLLS = 3600000;          
		final int NUM_ELEMENTS = 67; 
		int[] diceRolls = new int[NUM_ELEMENTS]; 
		int i = 0; 
		int currentRoll = 0; 
		
		for(i = 0; i < NUM_ROLLS + 1; i++ ){                                       //Takes the dice rolls    
			currentRoll = ((rand1.nextInt(6) + 1) * 10) + (rand1.nextInt(6) + 1);  //and turns them into a unique 
			diceRolls[currentRoll]++;                                              //value that corresponds to an 
		}                                                                          //index in the array
		
		System.out.println("Program 1, Joseph Tinglof, masc0752");
		for(i = 1; i < 7; i++){
			System.out.printf( "%10d", i);
		}
		System.out.printf("\n");
		
		for(i = 10; i < 70; i = i+10){         //Prints out only the indexes of the array that were used
			System.out.printf("%d %10d %10d %10d %10d %10d %10d\n", (i/10), diceRolls[i+1], diceRolls[i+2],+
					diceRolls[i+3], diceRolls[i+4], diceRolls[i+5], diceRolls[i+6]);
			}
		}
	
		
	}


