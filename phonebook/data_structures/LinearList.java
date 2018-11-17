package data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

public class LinearList<E extends Comparable<E>> implements LinearListADT<E> {
	
	private class Node<T> {
		T data;
		Node<T> next, previous;
		
		public Node(T data) {
			this.data = data;
			next = previous = null;
		}
	}
	
	private Node<E> head, tail;
	private int currentSize, maxSize;
	private long modCounter;
	
	public LinearList(){
		head = tail = null;
	}

//  Adds the Object obj to the beginning of list and returns true if the 
//  list is not full. returns false and aborts the insertion if the list is full.
	public boolean addFirst(E obj) {
		if(isFull()) 
			return false;
		Node<E> newNode = new Node<E>(obj);
		if(isEmpty()) 
			head = tail = newNode;
		else { //one obj in list must exist
			newNode.next = head;
			head.previous = newNode;
			head = newNode;
		}
		currentSize++;
		modCounter++;
		return true;
	}

//  Adds the Object obj to the end of list and returns true if the list 
//	is not full. returns false and aborts the insertion if the list is full.
	public boolean addLast(E obj) {
		if(isFull()) 
			return false;
		Node<E> newNode = new Node<E>(obj);
		if(isEmpty()) 
			head = tail = newNode;
		else { //one obj in list must exist
			newNode.previous = tail;
			tail.next = newNode;
			tail = newNode; 	
		}
		currentSize++;
		modCounter++;
		return true;
	}

//  Removes and returns the parameter object obj in first position in 
//	list if the list is not empty, null if the list is empty. 
	public E removeFirst() {
		if(isEmpty())
			return null;
		E tmp = head.data;
		head = head.next;
		if(head == null) //check if removed last obj
			tail = null;
		else
			head.previous = null;
		currentSize--;
		modCounter++;
		return tmp;
	}

//  Removes and returns the parameter object obj in last position 
//	in list if the list is not empty, null if the list is empty.
	public E removeLast() {
		if(isEmpty()) 
			return null;
		E tmp = tail.data;
		tail = tail.previous;
		if(tail == null) //check if removed last obj
			head = null;
		else
			tail.next = null;
		currentSize--;
		modCounter++;
		return tmp;
	}

//  Removes and returns the parameter object obj from the list if the list 
//	contains it, null otherwise. The ordering of the list is preserved.  
//	The list may contain duplicate elements.  This method removes and 
//	returns the first matching element found when traversing the list 
//	from first position. Note that you may have to shift elements to fill 
//	in the slot where the deleted element was located.
	public E remove(E obj) {
		Node<E> current = head;
		while(current != null && ((Comparable<E>)obj).compareTo(current.data) != 0) 
			current = current.next;
		if(current == null) //not contained 
			return null;
		if(current == head) //obj is first
			return removeFirst();
		if(current == tail) //obj is last
			return removeLast();
		current.previous.next = current.next; //obj is inside
		current.next.previous = current.previous;
		currentSize--;
		modCounter++;
		return current.data;
	}

//  Returns the first element in the list, null if the list is empty.
//  The list is not modified.
	public E peekFirst() {
		if(isEmpty()) 
			return null;
		E tmp = head.data;
		return tmp;
	}

	public E peekLast() {
		if(isEmpty()) 
			return null;
		E tmp = tail.data;
		return tmp;
	}

//  Returns true if the parameter object obj is in the list, false otherwise.
//  The list is not modified.
	public boolean contains(E obj) {
		Node<E> tmp = head;
		while(tmp != null){
			if(((Comparable<E>)obj).compareTo(tmp.data) == 0)
				return true;
			tmp = tmp.next;
		}
		return false;
	}

//  Returns the element matching obj if it is in the list, null otherwise.
//  In the case of duplicates, this method returns the element 
//	closest to front. The list is not modified.
	public E find(E obj) {
		Node<E> tmp = head;
		while(tmp != null){
			if(((Comparable<E>)obj).compareTo(tmp.data) == 0)
				return tmp.data;
			tmp = tmp.next;
		}
		return null;
	}

//  The list is returned to an empty state.
	public void clear() {
		head = tail = null;
		currentSize = 0;
		modCounter = 0;
	}

//  Returns true if the list is empty, otherwise false
	public boolean isEmpty() {
		if(head == null && tail == null)
			return true;
		return false;
	}

	public boolean isFull() {
		return false;
	}

	public int size() {
		return currentSize;
	}

	public Iterator<E> iterator() {
		return new IteratorHelper();
	}
	
	class IteratorHelper implements Iterator<E> {
		private Node<E> iteratorPointer;
		private long modCheck;
		
		public IteratorHelper() {
			modCheck = modCounter;
			iteratorPointer = head;
		}
		public boolean hasNext() {
			if(modCheck != modCounter)
				throw new ConcurrentModificationException();
			return iteratorPointer != null;
		}
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E tmp = iteratorPointer.data;
			iteratorPointer = iteratorPointer.next;
			return tmp;
		}
		public void remove() {
				throw new UnsupportedOperationException();
		}
	}
}
