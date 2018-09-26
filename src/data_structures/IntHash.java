/**
 * 
 */
package data_structures;

import java.util.ArrayList;
import java.util.Collections;
import java.lang.IndexOutOfBoundsException;
import java.lang.IllegalArgumentException;

/**
 * @author Alicia Fitch, fitchae
 *Collaborated with Steven Bower, Sam Duemler, Alex Oladele
 */
public class IntHash<value_type> extends Dictionary<Integer, value_type> {
	int a;
	int b;
	int m;
	

	ArrayList<Pair<Integer,value_type>> table;
	Pair<Integer,value_type> del;
	
	/**
	 * Hashing function
	 * @param key
	 * @return hash value
	 */
	private int hash(Integer key) {
		return (((int)key*a) + b) % m;
	}
	
	/**
	 * Default constructor
	 */
	public IntHash() {
		this(7, 1, 25014);
	}
	
	
	/**
	 * Constructor -- hash values specified.
	 */
	public IntHash(int a, int b, int m) {
		super();
		this.a = a;
		this.b = b;
		this.m = m;
		table = new ArrayList<Pair<Integer,value_type>>(Collections.nCopies(m, null));
		del = new Pair(null, null);
	}
	
	/**
	 * Insert a value/key pair into the dictionary.  Do not allow duplicate
	 * or null values.
	 * @param key        key to be inserted
	 * @param value      value to be inserted
	 * @exception   Throw IndexOutOfBoundsException if key already present.
	 * @exception   Throw IllegalArgumentException if value is null.
	 * @exception   Throw IllegalArgumentException if key < 0.  (Makes life easier.
	 */
	@Override
	public void insert(Integer key, value_type value) {
		if (value == null)
			throw new IllegalArgumentException("Null values not allowed");
		if (n == m)
			throw new ArrayIndexOutOfBoundsException("Out of space");
		if (key < 0)
			throw new IllegalArgumentException("Negative keys not allowed");
		
		int temp = hash(key);
		
		while(table.get(temp) != null && table.get(temp) != del){
			numOps+=2;
			if(table.get(temp).first.equals(key)){
				numOps++;
				throw new IndexOutOfBoundsException("Duplicate keys not allowed");
			}
			
			if(temp == m-1){
				temp=0;
			}else{
				temp++;
			}
			
		}
		
		table.set(temp, new Pair<Integer,value_type>(key,value));
		numOps++;
		n++;
		
	}

	/* (non-Javadoc)
	 * @see data_structures.Dictionary#remove(java.lang.Object)
	 */
	@Override
	public void remove(Integer key) {
			int temp = hash(key);
			
			del.first=key;
			
			while(table.get(temp)!=(null)){
				numOps++;
				if(table.get(temp).first.equals(key) && table.get(temp).second != null){
					numOps+=2;
					table.set(temp,del);
					numOps++;
					n--;
				}
				if(temp == m-1){
					temp=0;
				}else{
					temp++;
				}
					
			}	
		
	}
	
	/* (non-Javadoc)
	 * @see data_structures.Container#clear()
	 */
	@Override
	public void clear() {
		table = new ArrayList<Pair<Integer,value_type>>(Collections.nCopies(m, null));
		n=0;
	}

	/* (non-Javadoc)
	 * @see data_structures.Dictionary#find(java.lang.Object)
	 */
	@Override
	public value_type find(Integer key) {
		if (key == null)
			throw new IllegalArgumentException("Null values not allowed");
		if (n == m)
			throw new ArrayIndexOutOfBoundsException("Out of space");
		if (key < 0)
			throw new IllegalArgumentException("Negative keys not allowed");
		
		int temp = hash(key);
		del.first=key;
		while(table.get(temp) != null){
			numOps++;
			if(table.get(temp).first.equals(key) && table.get(temp).second != null){
				numOps+=3;
				return table.get(temp).second;
			}
			if(temp == m-1){
				temp=0;
			}else{
				temp++;
			}
				
			
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see data_structures.Dictionary#check_structure()
	 * This is not useful for this class -- we will just always pass it.
	 */
	@Override
	public boolean check_structure() {
		return true;
	}

	/* (non-Javadoc)
	 * @see data_structures.Dictionary#print_structure()
	 */
	@Override
	public void print_structure() {
		for (int i=0; i < m; i++) {
			Pair<Integer,value_type> p = table.get(i);
			numOps++;
			if (p != null && p.first >= 0)
				System.out.println("k, h(k), v = " + p.first + " " + i + " " + p.second);
		}
	}

}
