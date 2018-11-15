/**
 *  Program #2b
 *  This program takes a series of numbers inputed by the user and switches two of
 *  them, all while handling errors gracefully.
 *  sum of two dice rolls.
 *  CS108-2
 *  9-13-16
 *  @author  Joseph Tinglof
 */

import java.util.Scanner;

public class Prog2b {

	public static void main(String[] args) {
		Scanner radar = new Scanner(System.in);
		int arraySize = 0;
		int i = 0; 
		Byte j = 0;
		int Swap1 = 0;
		int Swap2 = 0;
		Byte holder = 0;
		
		try{
			//User inputs size of array
			arraySize = Integer.parseInt(radar.next()); 
			Byte[] userNums1 = new Byte[arraySize];
			Byte[] userNums2 = new Byte[arraySize];
		
			//Populates both arrays with user inputs
			for(i = 0; i < arraySize; i++){            
				j = radar.nextByte();                   
				userNums1[i] = j;
				userNums2[i] = j;
			}
			
			//Swaps the indexes in the second array
			Swap1 = Integer.parseInt(radar.next());     
			Swap2 = Integer.parseInt(radar.next());
			holder = userNums1[Swap1];
			userNums2[Swap1] = userNums1[Swap2];
			userNums2[Swap2] = holder;
			
			System.out.println("Program 2b, Joseph Tinglof, masc0752");
			//Prints both arrays
			for(i = 0; i < arraySize; i++){
				System.out.print(userNums1[i] + " ");
			}
			System.out.println();
			for(i = 0; i < arraySize; i++){
				System.out.print(userNums2[i] + " ");
			}
		
		//Catch block for exceptions
		}catch (NegativeArraySizeException excpt){
			System.out.print("Caught NegativeArraySizeException");
		}
		catch (NumberFormatException excpt){
			System.out.print("Caught NumberFormatException");
		}
		catch (ArrayIndexOutOfBoundsException excpt){
			System.out.print("Caught ArrayIndexOutOfBoundsException");
		}
	}

}
