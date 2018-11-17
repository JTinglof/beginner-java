import data_structures.*;
import java.util.Iterator;
import java.io.*;

public class PhoneBook {
	DictionaryADT<PhoneNumber,String> book;
    // Constructor.  There is no argument-less constructor, or default size
    public PhoneBook(int maxSize){
    	DictionaryADT<PhoneNumber,String> book = new Hashtable<PhoneNumber,String>(maxSize);
    }
       
    // Reads PhoneBook data from a text file and loads the data into
    // the PhoneBook.  Data is in the form "key=value" where a phoneNumber
    // is the key and a name in the format "Last, First" is the value.
    public void load(String filename){
    	String line;
    	try{
    		BufferedReader in = new BufferedReader(new FileReader(filename));
    		while ((line = in.readLine()) != null){
    			PhoneNumber tmp = new PhoneNumber(line.substring(0, 12));
    			String value = line.substring(13);
    			in.close();
    		}
    	
    	} catch (IOException e){
    		e.printStackTrace();
    	}
    }
           
    // Returns the name associated with the given PhoneNumber, if it is
    // in the PhoneBook, null if it is not.
    public String numberLookup(PhoneNumber number){
    	return book.getValue(number);
    }
       
    // Returns the PhoneNumber associated with the given name value.
    // There may be duplicate values, return the first one found.
    // Return null if the name is not in the PhoneBook.
    public PhoneNumber nameLookup(String name){
    	return book.getKey(name);
    }
       
    // Adds a new PhoneNumber = name pair to the PhoneBook.  All
    // names should be in the form "Last, First".
    // Duplicate entries are *not* allowed.  Return true if the
    // insertion succeeds otherwise false (PhoneBook is full or
    // the new record is a duplicate).  Does not change the datafile on disk.
    public boolean addEntry(PhoneNumber number, String name){
    	return book.add(number, name);
    }
       
    // Deletes the record associated with the PhoneNumber if it is
    // in the PhoneBook.  Returns true if the number was found and
    // its record deleted, otherwise false.  Does not change the datafile on disk.
    public boolean deleteEntry(PhoneNumber number){
    	return book.delete(number);
    }
       
    // Prints a directory of all PhoneNumbers with their associated
    // names, in sorted order (ordered by PhoneNumber).
    public void printAll(){
    	for(Iterator<PhoneNumber> n = book.keys(); n.hasNext();){
    		PhoneNumber item = n.next();
    		String names = book.getValue(item);
    		String numbers = item.toString();
    		System.out.print(names + " ");
    		System.out.println(numbers);
    	}	
    }
       
    // Prints all records with the given Area Code in ordered
    // sorted by PhoneNumber.
    public void printByAreaCode(String code){
    	for(Iterator<PhoneNumber> n = book.keys(); n.hasNext();){
    		PhoneNumber item = n.next();
    		if(item.getAreaCode() == code){
    			String names = book.getValue(item);
        		String numbers = item.toString();
        		System.out.print(names + " ");
        		System.out.println(numbers);
    		}	
    	}	
    }
   
    // Prints all of the names in the directory, in sorted order (by name,
    // not by number).  There may be duplicates as these are the values.       
    public void printNames(){
    	for(Iterator<String> n = book.values(); n.hasNext();){ 
    		String item = n.next();
    		System.out.println(item);
    	}	
    }
}
