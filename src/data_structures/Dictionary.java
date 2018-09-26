package data_structures;

public abstract class Dictionary<key_type,value_type> extends Container<key_type> {

	public Dictionary() {
		super();
	}
	
	/**
	 * Insert a value/key pair into the dictionary.
	 * @param key        key to be inserted
	 * @param value      value to be inserted
	 * @exception   Throw IndexOutOfBoundsException if key already present.
	 */
	public abstract void insert(key_type key, value_type value);

	
	/**
	 * Remove a key from the dictionary
	 * @param key  key to remove
	 */
	public abstract void remove(key_type key);
	
	/**
	 * Search for a key value
	 * @return value associated with key.  Returns null if key not found.
	 */
	public abstract value_type find(key_type key);
	
	/* (non-Javadoc)
	 * @see data_structures.Container#in()
	 */
	@Override 
	public boolean in(key_type key) {
		return find(key) != null;
	}
	
	
	/**
	 * Check to make sure the implemented structure correct.
	 * (For debugging.)
	 * @return boolean
	 */
	public abstract boolean check_structure();
	
	
	/**
	 * Print out the structure in whatever way makes snese.
	 * (For debugging.)
	 */
	public abstract void print_structure();
}
