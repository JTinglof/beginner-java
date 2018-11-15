/**
 *  Program #2a
 *  This program takes a series of numbers inputed by the user and finds the distance
 *  from the average of each, all while handling errors gracefully.
 *  CS108-2
 *  9-13-16
 *  @author  Joseph Tinglof
 */

import java.util.Scanner;

public class Prog2a {

	public static void main(String[] args) {
		Scanner radar = new Scanner(System.in);
		int arraySize = 0;
		int i = 0; 
		double arraySum = 0.0;
		double averageLenght = 0.0;
		
		try{
			//User inputs size of array
			arraySize = Integer.parseInt(radar.next());
			double[] userNums = new double[arraySize];
		
			//Populates array with user input
			for(i = 0; i < arraySize; i++){
				userNums[i] = radar.nextDouble();
			}
		
			//Finds the sum of the entire array
			for(i = 0; i < arraySize; i++){
				arraySum = arraySum + userNums[i];
			}
		
			System.out.println("Program 2a, Joseph Tinglof, masc0752");
			//Finds the average value of the indexes and prints out
			//the distance from each for every index
			for(i = 0; i< arraySize; i++){
				averageLenght = (arraySum/arraySize) - userNums[i];
				System.out.println(userNums[i] + " distance from average is " + Math.abs(averageLenght));
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
