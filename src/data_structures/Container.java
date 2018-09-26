package data_structures;

public abstract class Container<element_type> {

	/**
	 * n: Size of container
	 */
	protected int n;
	
	/**
	 * numOps: Number of "basic operations" since last resource reset
	 */
	int numOps;
	
	protected Container() {
		resetOps();
		n=0;
	}
	
	/**
	 * Return the number of element_types contained in the list.
	 * @return int
	 */
	public int size() {
		return n;
	}
	
	
	/**
	 * Remove all elements.
	 */
	abstract public void clear();
	
	
	/**
	 * Search for a query element_type in the array.
	 * @param query element_type being seqrched for
	 * @return boolean
	 */
	abstract public boolean in(element_type query);
	
	/**
	 * Return True if the container is empty.
	 */
	public boolean isEmpty() {
		return n==0;
	}
	
	/**
	 * Amount of memory used since last resource reset.
	 * @return Number of operations
	 */
	public int numOps() {
		return numOps;
	}
	
	
	public void resetOps() {
		numOps = 0;
	}

}
