/**
 *  Program #7c
 *  This program will take an array of numbers and find the index of a desired value.
 *  CS108-2
 *  11-29-16
 *  @author  Joseph Tinglof
 */

import java.util.Scanner;

public class Prog7c{
	public static void main(String[] args) {
		
		System.out.println("Program 7, Joseph Tinglof, masc0752");
		// Define sorted array
		int[] numbers = {-5, 0, 1, 4, 8, 11, 16, 20, 32, 46, 48, 51, 53, 64, 69, 72, 89, 95, 99};
		Scanner scan = new Scanner(System.in);
		System.out.print("\nEnter a value to search for: ");
		int targetValue = scan.nextInt();
		
		//calls recursive method
		int index = recursiveBinarySearch(numbers, targetValue, 0, numbers.length-1);
		
		if (index != -1)
			System.out.println( targetValue + " found at index " + index);
		else
			System.out.println( targetValue + " not found");
		
	System.out.println();
 }
	
	public static int recursiveBinarySearch(int[] a, int key, int start, int end) {
		if ( start <= end ) {
			// check middle value of the subarray
			int middle = ( start + end ) / 2;
			
			if ( a[middle] == key ) // found key
				return middle;
			else if ( a[middle] > key ) // look lower
				return recursiveBinarySearch(a, key, start, middle - 1);
			else // look higher
				return recursiveBinarySearch(a, key, middle + 1, end);
		}
		else
			return -1; // key not found
 }
}