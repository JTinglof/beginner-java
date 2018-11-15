/* Program #3
   Joseph Tinglof
   cssc0944
*/

import java.util.Iterator;
import data_structures.*;

public class PhoneNumber implements Comparable<PhoneNumber> {
    String areaCode, prefix, number;
    String phoneNumber;
   
    // Constructor.  Creates a new PhoneNumber instance.  The parameter
    // is a phone number in the form xxx-xxx-xxxx, which is area code -
    // prefix - number.  The phone number must be validated, and an
    // IllegalArgumentException thrown if it is invalid.
    public PhoneNumber(String n){
    	verify(n);
    	areaCode = n.substring(0, 2);
    	prefix = n.substring(4, 6);
    	number = n.substring(8, 11);
    	phoneNumber = n.toString();
    }
    
    // Follows the specifications of the Comparable Interface.  
    public int compareTo(PhoneNumber n){
    	return ((Comparable<String>)phoneNumber).compareTo((String)n.phoneNumber); 
    }
       
    // Returns an int representing the hashCode of the PhoneNumber.
    public int hashCode(){
    	byte[] b = phoneNumber.getBytes();
    	long hashVal = 0;
    	for(int i = phoneNumber.length()-1; i >= 0; i--)
    		hashVal = (hashVal << 5) + b[i];
    	return (int) hashVal;
    }
   
    // Private method to validate the Phone Number.  Should be called
    // from the constructor.   
    private void verify(String n){
    	for(int j = 0; j < 2; j++)
    		if(!Character.isDigit(n.charAt(j)))
    			throw new IllegalArgumentException();
    	for(int j = 4; j < 6; j++)
    		if(!Character.isDigit(n.charAt(j)))
    			throw new IllegalArgumentException();
    	for(int j = 8; j < 11; j++)
    		if(!Character.isDigit(n.charAt(j)))
    			throw new IllegalArgumentException();	
    }
       
    // Returns the area code of the Phone Number.
    public String getAreaCode(){
    	return areaCode;
    }
       
    // Returns the prefix of the Phone Number.
    public String getPrefix(){
    	return prefix;
    }
       
    // Returns the the last four digits of the number.
    public String getNumber(){
    	return number;
    }

    // Returns the Phone Number.       
    public String toString(){
    	return areaCode + prefix + number;
    }
}            
