/* Program #1
   Joseph Tinglof
   cssc0944
*/

package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayLinearList<E> implements LinearListADT<E> {
	private E [] storage;
	private int currentSize, maxSize, front, rear;
	
	public ArrayLinearList(int max) {
		maxSize = max;
		front = rear = currentSize = 0;
		storage = (E[]) new Object[maxSize];
	}
	public ArrayLinearList() {
		maxSize = DEFAULT_MAX_CAPACITY;
		front = rear = currentSize = 0;
		storage = (E[]) new Object[maxSize];
	}
    
//  Adds the Object obj to the beginning of list and returns true if the list is not full.
//  returns false and aborts the insertion if the list is full.
    public boolean addFirst(E obj) { 
    	if(currentSize < maxSize || front == -1) {
    			storage[rear] = obj;
    			rear++;
    			currentSize++;
    			return true;	
    	}
    	return false;
    }
    
//  Adds the Object obj to the end of list and returns true if the list is not full.
//  returns false and aborts the insertion if the list is full. 
    public boolean addLast(E obj) {
    	if(currentSize < maxSize) {
    		if(rear == maxSize){
    			rear=0;
    			if(rear == front)
    				return false;
    			storage[rear] = obj;
    			currentSize++;
    			rear++;
    			return true;
    		}
    		storage[rear] = obj;
    		currentSize++;
    		rear++;
    		return true;
    	}
    	return false;
    }
    
//  Removes and returns the parameter object obj in first position in list if the list is not empty,  
//  null if the list is empty. 
    public E removeFirst() {
    	if(currentSize > 0) {
    		--currentSize;
    		front++;
    		return storage[front];
    	}
    	return null;
    }   
    
//  Removes and returns the parameter object obj in last position in list if the list is not empty, 
//  null if the list is empty. 
    public E removeLast() {
    	if(currentSize > 0) {
    		if(rear == 0){
    			rear = (maxSize - 1);
    			--currentSize;
    			return storage[rear];
    		}
    		--currentSize;
    		rear--;
    		return storage[rear];
    	}
    	return null;
    }   
    
//  Removes and returns the parameter object obj from the list if the list contains it, null otherwise.
//  The ordering of the list is preserved.  The list may contain duplicate elements.  This method
//  removes and returns the first matching element found when traversing the list from first position.
//  Note that you may have to shift elements to fill in the slot where the deleted element was located.
    public E remove(E obj) {
    	for(int i=front; i < currentSize; i++){
    		if(storage[i].equals(obj)){
    			E tmp = storage[i];
    			storage[i] = null;
    			--currentSize;
    			return tmp;
    		}
    	}
    	return null;
    } 
    
//  Returns the first element in the list, null if the list is empty.
//  The list is not modified.
    public E peekFirst() { 
    	if(currentSize > 0)
    		return storage[--front];
    	return null;
    }
    
//  Returns the last element in the list, null if the list is empty.
//  The list is not modified.
    public E peekLast() { 
    	if(currentSize > 0)
    		return storage[++rear];
    	return null;
    }                        

//  Returns true if the parameter object obj is in the list, false otherwise.
//  The list is not modified.
    public boolean contains(E obj) {
    	return find(obj) != null;
    }  
    
//  Returns the element matching obj if it is in the list, null otherwise.
//  In the case of duplicates, this method returns the element closest to front.
//  The list is not modified.
    public E find(E obj) {
    	for(int i = front; i < currentSize; i++){
    		E tmp = storage[i];
    		if( ((Comparable<E>)obj).compareTo(tmp) == 0){
    			return tmp;
    		}
    	}
    	return null;
    }       

//  The list is returned to an empty state.
    public void clear() {
    	for(int i = 0; i < maxSize; i++)
    		storage[i] = null;
    	currentSize = rear = front = 0;
    }

//  Returns true if the list is empty, otherwise false
    public boolean isEmpty() {
    	if(currentSize > 0)
    		return true;
    	return false;
    	}
    
//  Returns true if the list is full, otherwise false
    public boolean isFull() {
    	if(currentSize == maxSize)
    		return true;
    	return false;
    }    

//  Returns the number of Objects currently in the list.
    public int size() {
    	return currentSize;
    }
    
//  Returns an Iterator of the values in the list, presented in
//  the same order as the underlying order of the list. (front first, rear last)
    public Iterator<E> iterator(){
    	return new IteratorHelper();
    }
    
    class IteratorHelper implements Iterator<E> {
    	private int count, index;
    	
    	public IteratorHelper(){
    		index = front;
    		count = 0;
    	}
    	
//Returns true if there are more elements available 
    	public boolean hasNext(){
    		return count != currentSize;
    	}
    	
//Returns a reference to the next object in the collection
    	public E next(){
    		if(!hasNext()) throw new NoSuchElementException();
    		E tmp = storage[index++];
    		if(index == maxSize){
    			index = 0;
    			count++;
    			return tmp;
    		}
    		return tmp;
    	}
    }
}
