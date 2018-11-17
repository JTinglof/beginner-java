package data_structures;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.TreeMap;

public class BalancedTree<K extends Comparable<K>,V> implements DictionaryADT<K,V> {
	private int currentSize;
	private long modCounter;
	private TreeMap<K,V> bTree;
	
	public BalancedTree() {
		bTree = new TreeMap<K,V>();
		currentSize = 0;
	}
	
	public boolean contains(K key){
		return bTree.containsKey(key);
	}
	
	public boolean add(K k, V v) {
		if(bTree.containsKey(k))
			return false;
		bTree.put(k, v);
		currentSize++;
		modCounter++;
		return true;
	}
	
	public boolean delete(K k) {
		if(!bTree.containsKey(k))
			return false;
		bTree.remove(k);
		currentSize--;
		modCounter++;
		return true;
	}
	
	public V getValue(K key) {
		return bTree.get(key);
	}
	
	public K getKey(V value) {
		for(Entry<K,V> node : bTree.entrySet())
			if(value.equals(node.getValue()))
				return node.getKey();
		return null;
	}
	
	public int size(){
		return bTree.size();
	}
	
	public boolean isFull(){
		return false;
	}
	
	public boolean isEmpty(){
		if(bTree.size() == 0) 
			return true;
		return false;
	}
	
	public void clear(){
		currentSize = 0;
		modCounter = 0;
		bTree.clear();
	}
	
	public Iterator keys(){
		return new KeyIteratorHelper();
	}
	
	public Iterator values(){
		return new ValueIteratorHelper();
	}
	
	abstract class IteratorHelper<E> implements Iterator<E>{
		protected Entry<K,V> [] nodes;
		protected int index, j = 0;
		protected long modCheck;
		
		public IteratorHelper(){
			nodes = new Entry[currentSize];
			index = 0; 
			modCheck = modCounter;
			for(Entry<K,V> node : bTree.entrySet()) {
				  nodes[j++] = node;
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
			return (K) nodes[index++].getKey();
		}
	}
	class ValueIteratorHelper<V> extends IteratorHelper<V>{
		public ValueIteratorHelper(){
			super();
		}
		public V next(){
			if(!hasNext())
				throw new NoSuchElementException();
			return (V) nodes[index++].getValue();
		}
	}	

}
