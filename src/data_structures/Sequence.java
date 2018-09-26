package data_structures;

public abstract class Sequence<element_type> extends Container<element_type>{
	
	/**
	 * Get the element_type i.
	 * @param i Number of accessed element (from 0).
	 * @return element_type
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	abstract public element_type get(int i);

	/**
	 * Set the element_type at element i to value.
	 * @param i Number of accessed element (from 0).
	 * @param value element_type value being put in the array
	 * @return element_type
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	abstract public element_type set(int i, element_type value);
	
	/**
	 * Insert a new value at index i (bumping elements i - size() up one).
	 * @param i Number of inserted element
	 * @param value element_type valueb eing inserted
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	abstract public void add(int i, element_type value);
	
	/**
	 * Add an element to the back of the element_type.
	 * @param value element_type being added
	 */
	public void push_back(element_type value) {
		add(n, value);
	}
	
	/**
	 * Add an element to the front of the element_type.
	 * @param value element_type being added.
	 */
	public void push_front(element_type value) {
		add(0, value);
	}
	
	/**
	 * Remove element i from the array (renumbering everything past it)
	 * @param i  element being removed
	 * @return   value that was removed
	 * @throws IndexOutOfBoundsException if index out of bounds
	 */
	abstract public element_type remove(int i);
	
	/**
	 * Remove last element
	 * @return value of last element
	 */
	public element_type pop_back() {
		return remove(size()-1);
	}
	
	/**
	 * Remove first element
	 * @return value of first element
	 */
	public element_type pop_front() {
		return remove(0);
	}
	
	
	/**
	 * Search for a query element_type in the array.
	 * @param query element_type being seqrched for
	 * @return boolean
	 */
	@Override
	public boolean in(element_type query) {
		for (int i=0; i < n; i++)
			if (query.equals(get(i)))
				return true;
		
		return false;
	}
	
	/**
	 * Remove all elements.
	 */
	abstract public void clear();
	


}
