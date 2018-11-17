/**
 *  This program displays a desired number of the most recent Tweets that use a 
 *  user specified word or phrase. 
 *  12-13-16
 *  @author  Joseph Tinglof
 */

import java.util.ArrayList;
import java.util.Scanner;
import realtimeweb.twittersearch.TwitterSearch;
import realtimeweb.twittersearch.domain.Tweet;

public class TwitterExample {
    public static void main(String[] args) {
    	
    	//Initialize the varables.
    	int numTweets;
    	String searchTerm;
    	Scanner radar = new Scanner(System.in);
    	
    	try{
    		//Asks for and stores desired number of Tweets and topic to search for.
    		System.out.println("Please enter the word or phrase you would like to search for:");
    		searchTerm = radar.nextLine();
    		System.out.println("Please enter the number of tweets you would like displayed.");
    		numTweets = radar.nextInt();
    	
    		System.out.println("Displaying " + numTweets + " of the most recent tweets about " + searchTerm + "...");
    		System.out.print("\n");
    	
    		//Begins a new search of Twitter's website using the search term. 
    		TwitterSearch nws = new TwitterSearch();
    		ArrayList<Tweet> current = nws.query(searchTerm, "Recent", numTweets);
    		//Displays the text of the Tweet and its author.
    		for(int j = 0; j <= numTweets - 1; j++){
    			System.out.println(current.get(j).getUser());
    			System.out.println(current.get(j).getText());
    			System.out.print("\n");
    			}
    		
    		//Catch block for exceptions.
    		}catch (NullPointerException excpt){
    			System.out.print("Caught NullPointerException");
    		}	
    	}
    }
