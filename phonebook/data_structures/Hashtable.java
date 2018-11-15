/* Program #3
   Joseph Tinglof
   cssc0944
*/

package data_structures;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Hashtable<K extends Comparable<K>,V> implements DictionaryADT<K,V> {
	private int currentSize, maxSize, tableSize;
	private long modCounter;
	private LinearListADT<DictionaryNode<K,V>> [] list;
	
	class DictionaryNode<K,V> implements Comparable<DictionaryNode<K,V>> {
		K key;
		V value;
		
		public DictionaryNode(K key, V value){
			this.key = key;
			this.value = value;
		}
		public int compareTo(DictionaryNode<K,V> node){
			return ((Comparable<K>)key).compareTo((K)node.key);
		}
	}
	
	public Hashtable(int n){
		currentSize = 0;
		maxSize = n;
		modCounter = 0; 
		tableSize = (int) (maxSize * 1.3f);
		list = new LinearList[tableSize];
		for(int i=0; i < tableSize; i++)
			list[i] = new LinearList<DictionaryNode<K,V>>();
	}
	
	public int getHashCode(K key){
		int index = (key.hashCode() & 0x7FFFFFFF) % maxSize;
		return index;
	}
	
	public boolean contains(K key){
		return list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null));
	}
	
	public boolean add(K key, V value){
		if(isFull())
			return false;
		if(list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null)))
			return false;
		list[getHashCode(key)].addLast(new DictionaryNode<K,V>(key, value));
		currentSize++;
		modCounter++;
		return true;
	}
	
	public boolean delete(K key){
		if(!list[getHashCode(key)].contains(new DictionaryNode<K,V>(key,null))){
			return false;
		}
		list[getHashCode(key)].remove(new DictionaryNode<K,V>(key, null));
		currentSize--;
		modCounter++;
		return true;
	}
	
	public V getValue(K key){
		DictionaryNode<K,V> tmp = list[getHashCode(key)].find(new DictionaryNode<K,V>(key,null));
		if(tmp == null) 
			return null;
		return tmp.value;
	}
	
	public K getKey(V value){
		for(int i = 0; i < maxSize; i++){
			for(DictionaryNode<K,V> tmp : list[i]){
				if(((Comparable<V>)value).compareTo(tmp.value) == 0)
					return tmp.key;
			}
		}
		return null;
	}

	
	public int size(){
		return currentSize;
	}
	
	public boolean isFull(){
		return currentSize == maxSize;
	}
	
	public boolean isEmpty(){
		return currentSize == 0;
	}
	
	public void clear(){
		currentSize = 0;
		modCounter = 0;
		for(int i = 0; i < tableSize; i++ )
			list[i].clear();
	}
	
	public Iterator keys(){
		return new KeyIteratorHelper();
	}
	
	public Iterator values(){
		return new ValueIteratorHelper();
	}
	
	abstract class IteratorHelper<E> implements Iterator<E>{
		protected DictionaryNode<K,V> [] nodes;
		protected int index;
		protected long modCheck;
		
		public IteratorHelper(){
			nodes = new DictionaryNode[currentSize];
			index = 0;
			int j = 0; 
			modCheck = modCounter;
			for(int i = 0; i < tableSize; i++)
				for(DictionaryNode n : list[i])
					nodes[j++] = n;
			nodes = (DictionaryNode<K,V>[]) shellSort(nodes);
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
		
		private DictionaryNode<K,V>[] shellSort(DictionaryNode<K,V> array[]) {
			DictionaryNode<K,V>[] n = array;
			int out, in;
			DictionaryNode<K,V> temp;
			int h = 1;
			int size = n.length;
			
			while(h <= size/3)
				h = h*3+1;
			while(h > 0) {
				for(out = h; out < size; out++) {
					temp = n[out];
					in = out;
					while(in > h-1 && n[in-h].compareTo(temp) >= 0) {
						n[in] = n[in-h];
						in -= h;
					} 
					n[in] = temp;
				}
				h = (h-1)/3;
			}
			return n;
		}	
	} // End KeyIterator abstract class
	
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
