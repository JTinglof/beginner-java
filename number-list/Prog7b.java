/**
 *  This program will accept a string and determine if the string is a palindrome.
 *  11-29-16
 *  @author  Joseph Tinglof
 */

import java.util.Scanner;

public class Prog7b {
	public static String reverse(String C){
		//find first and last letter in string
		char a = C.charAt(C.length()-1);
		char b = C.charAt(0);
		
		//check first and last letter in string for matching
		if(a == b){
			if(C.length() <= 1){
				return(" is a palindrome");
			}
			return reverse(C.substring(1,C.length()-1));
		}
		
		else{
			return(" is not a palindrome");
		}
	}

	public static void main(String[] args) {
		System.out.println("Type phrase");
		Scanner scrn = new Scanner(System.in);
		String test = scrn.nextLine();
		System.out.print(test +reverse(test));
		return;
	}

}
