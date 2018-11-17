/**
 *  This program will accept a list of numbers and then return list backwards.
 *  11-29-16
 *  @author  Joseph Tinglof
 */

import java.util.Scanner;

public class Prog7a {
	
	public static String reverse(String C){
		//grabs last letter to start new line of numbers
		char s = C.charAt(C.length()-1);
		
		//continues recursively, returning each number in reverse order
		if(C.length() == 1){
			return Character.toString(s);
		}
		else{
			return s + reverse(C.substring(0, C.length()-1));
		}
	}

	public static void main(String[] args) {
		System.out.println("Program 7, Joseph Tinglof, masc0752");
		System.out.println("What number would you like to reversed?");
		Scanner scrn = new Scanner(System.in);
		String newNum = scrn.nextLine();
		System.out.print(reverse(newNum));
		return;

	}

}
