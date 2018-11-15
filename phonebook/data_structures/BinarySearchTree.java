/* Program #3
   Joseph Tinglof
   cssc0944
*/

package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class BinarySearchTree<K extends Comparable<K>,V> implements DictionaryADT<K,V> {
	private class Node<K,V> {
		private K key;
		private V value;
		private Node<K,V> leftChild;
		private Node<K,V> rightChild;
		
		public Node(K k, V v) {
			key = k;
			value = v;
			leftChild = rightChild = null;
		}
	}
	
	private Node<K,V> root;
	private int currentSize;
	private long modCounter;
	
	public BinarySearchTree() {
		root = null;
		currentSize = 0;
	}
	
	public boolean contains(K key){
		if(isEmpty()) return false;
		V temp = findValue(key, root);
		return temp != null;
	}
	
	public boolean add(K k, V v) {
		if(isEmpty())
			root = new Node<K,V>(k,v);
		else
			insert(k,v,root,null,false);
		currentSize++;
		modCounter++;
		return true;
	}
	
	private void insert(K k, V v,Node<K,V> n,Node<K,V> parent, boolean wasLeft){
		if(n == null) {
			if(wasLeft) parent.leftChild = new Node<K,V>(k,v);
			else parent.rightChild = new Node<K,V>(k,v);
		}
		else if(((Comparable<K>)k).compareTo((K)n.key) < 0)
			insert(k,v,n.leftChild,n,true);
		else
			insert(k,v,n.rightChild, n, false);
	}
	
	public boolean delete(K k) {
		if(isEmpty()) return false;
		if(!remove(k, root, null, false)) return false;
		currentSize--;
		modCounter++;
		return true;
	}
	
	private boolean remove(K k, Node<K,V> n, Node<K,V> parent, boolean wasleft) {
		if(((Comparable<K>)k).compareTo(n.key) < 0)
			return remove(k, n.leftChild, n, true);
		if(((Comparable<K>)k).compareTo(n.key) > 0)
			return remove(k, n.rightChild, n, false);
		if(n.leftChild == null && n.rightChild==null){ // node with no kids
			if(parent == null){ //last node
				root = null; 
				return true;
			}
			else if (wasleft){  //parent's left
				parent.leftChild = null;
				return true;
			}
			else{ //parents right
				parent.rightChild = null;
				return true;
			}
		}
		else if(n.leftChild == null){ // node with only a right kid
			if(parent == null){ //head 
				root = n.rightChild;
				return true;
			}
			else if(wasleft){ //parent's left
				parent.leftChild = n.rightChild;
				return true;
			}
			else{ //parent's right
				parent.rightChild = n.rightChild;
				return true;
			}
		}
		else if(n.rightChild == null){ // node with only a left kid
			if(parent == null){ //head 
				root = n.leftChild;
				return true;
			}
			else if(wasleft){ //parent's left
				parent.leftChild = n.leftChild;
				return true;
			}
			else{ //parent's right
				parent.rightChild = n.leftChild;
				return true;
			}
		}
		else if(n.leftChild != null && n.rightChild != null){ // node with two kids
			Node<K,V> left = n.leftChild;
			Node<K,V> right = n.leftChild;
			Node<K,V> leftDrillDown = null;
			Node<K,V> rightDrillDown = null;
			Node<K,V> leftDrillParent = null;
			Node<K,V> rightDrillParent = null;
			if(left.rightChild != null){
				leftDrillDown = left.rightChild;
				while(leftDrillDown.rightChild != null){
					leftDrillParent = leftDrillDown;
					leftDrillDown = leftDrillDown.rightChild;
				}
				if(leftDrillDown.leftChild != null){
					left = leftDrillDown.leftChild;
					n = leftDrillParent;
					left = leftDrillDown.leftChild;
				}
				else{
					parent = leftDrillParent;
					//not finished but literally everything else works
				}
			}
				
			if(right.leftChild != null)
				rightDrillDown = right.leftChild;
		}
		return false;
	}
	
	public V getValue(K key) {
		return findValue(key, root);
	}
	
	public K getKey(V value) {
		return findKey(value, root);
	}
	
	private V findValue(K key, Node<K,V> n) {
		if(n == null) return null;
		if(((Comparable<K>)key).compareTo(n.key) < 0)
			return findValue(key, n.leftChild);
		if(((Comparable<K>)key).compareTo(n.key) > 0)
			return findValue(key, n.rightChild);
		return (V) n.value;
	} 
	
	private K findKey(V value, Node<K,V> n) {
		if(n == null) return null;
		if(((Comparable<V>)value).compareTo(n.value) < 0)
			return findKey(value, n.leftChild);
		if(((Comparable<V>)value).compareTo(n.value) > 0)
			return findKey(value, n.rightChild);
		return (K) n.value;
	} 
	
	public int size(){
		return currentSize;
	}
	
	public boolean isFull(){
		return false;
	}

	public boolean isEmpty(){
		if(root == null) return true;
		return false;
	}
	
	public void clear(){
		root = null;
	}
	
	public Iterator keys(){
		return new KeyIteratorHelper();
	}

	public Iterator values(){
		return new ValueIteratorHelper();
	}
	
	abstract class IteratorHelper<E> implements Iterator<E>{
		protected Node<K,V> [] nodes;
		protected int index, j = 0;
		protected long modCheck;
		
		public IteratorHelper(){
			nodes = new Node[currentSize];
			index = 0; 
			modCheck = modCounter;
			walk(root);
		}
		private void walk(Node<K,V> n) {
			if(n != null) {
				walk(n.leftChild);
				nodes[j++] = n;
				walk(n.rightChild);	
			}
		}
		public boolean hasNext(){
			if(modCheck != modCounter)
				throw new ConcurrentModificationException();
			return index < currentSize;
		}
		public abstract E next();
		
		public void remove(){
			throw new UnsupportedOperationException();
		}
	}
	
	class KeyIteratorHelper<K> extends IteratorHelper<K>{
		public KeyIteratorHelper(){
			super();
		}
		public K next(){
			if(!hasNext())
				throw new NoSuchElementException();
			return (K) nodes[index++].key;
		}
	}
	class ValueIteratorHelper<V> extends IteratorHelper<V>{
		public ValueIteratorHelper(){
			super();
		}
		public V next(){
			if(!hasNext())
				throw new NoSuchElementException();
			return (V) nodes[index++].value;
		}
	}	
}