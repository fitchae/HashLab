/**
 * 
 */
package unit_test;

import static org.junit.Assert.*;

import org.junit.Test;
import data_structures.*;

/**
 * @author karroje
 *
 */
public class DictionaryTester {
	
	private Dictionary<Integer,Integer> create_dictionary(int n) {
		Dictionary<Integer,Integer> D = new IntHash<Integer>();
		for (int i=0; i < n; i++)
			D.insert(new Integer(2*i),new Integer(2*i+1));
		return D;
	}
	

	/**
	 * Check that the constructor works.
	 */
	@Test
	public void constructor() {
		Dictionary<Integer,Integer> D = create_dictionary(0);
		assertNotNull("D should not be null", D);
		assertTrue("check_structure failed", D.check_structure());
		assertTrue("Dictionary size should be 0", D.size() == 0);
	}
	
	/**
	 * Check that the first insert doesn't crash,  modifies size correctly,
	 * and leaves the data structure intact.
	 */
	@Test
	public void firstInsert() {
		Dictionary<Integer,Integer> D = create_dictionary(0);
		D.insert(new Integer(5), new Integer(5));
		assertTrue("Wrong size after first insert", D.size() == 1);
		assertTrue("check_structure failed", D.check_structure());
	}
	
	/**
	 * Check that the only insered element can be bound.
	 */
	@Test
	public void firstfind() {
		Dictionary<Integer,Integer> D = create_dictionary(0);
		D.insert(new Integer(5), new Integer(-1));
		assertEquals("Element not found", D.find(new Integer(5)), new Integer(-1));
	}
	
	/**
	 * Check that multiple inserts don't crash, modifies size correctly,
	 * and leaves the data structure intact.
	 */
	@Test
	public void multiInsert() {
		Dictionary<Integer, Integer> D = create_dictionary(10);
		assertTrue("Wrong size", D.size() == 10);
		assertTrue("check_structure failed", D.check_structure());
	}
	
	/**
	 * Test that find is working when the element is in the list.
	 */
	@Test
	public void testFindPositive() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		for (int i=0; i < 10; i++) {
		    assertEquals("Not found: " + 2*i, new Integer(2*i+1), D.find(new Integer(2*i)));
			assertTrue("check_structure failed after D.find(" + 2*i + ")", D.check_structure());
		}
	}
	
	/**
	 * Test that find is working when the element is not in the list.
	 */
	@Test
	public void testFindNegitive() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		for (int i=0; i < 10; i++) {
    		assertNull("Incorrectly found: " + (2*i+1), D.find(new Integer(2*i+1)));
			assertTrue("check_structure failed after D.find(" + (2*i-1) + ")", D.check_structure());
		}
	}
	
	/**
	 * Make sure we can insert an element at the beginning.
	 */
	@Test
	public void testInsertBegin() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.insert(new Integer(1), new Integer(-4));
		assertTrue("Size should be 11", D.size()==11);
		assertEquals("1 should be found with value -4", D.find(new Integer(1)), new Integer(-4));
		assertTrue("check_structure failed", D.check_structure());
	}
	
	/**
	 * Make sure we can insert an element in the middle.
	 */
	@Test
	public void testInsertMiddle() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.insert(11, 13);
		assertTrue("Size should be 11", D.size()==11);
		assertEquals("1 should be found with value 13", D.find(new Integer(11)), new Integer(13));
		assertTrue("check_structure failed", D.check_structure());
	}	
	
	/**
	 * Make sure we can insert an element at the end.
	 */
	@Test
	public void testInsertEnd() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.insert(new Integer(50), new Integer(51));
		assertTrue("Size should be 11", D.size()==11);
		assertEquals("50 should be found with value 51", D.find(new Integer(50)), new Integer(51));
		assertTrue("check_structure failed", D.check_structure());
	}	
	
	/**
	 * Test that we can remove an element in the middle without problem.
	 */
	@Test
	public void testRemoveBegin() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.remove(0);
		assertTrue("Size should be 9", D.size() == 9);
		assertNull("0 should not be found", D.find(new Integer(0)));
		assertTrue("check_structure failed after remove", D.check_structure());
	}
	
	/**
	 * Test that we can remove an element in the middle without problem.
	 */
	@Test
	public void testRemoveMiddle() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.remove(10);
		assertTrue("Size should be 9", D.size() == 9);
		assertTrue("10 should not be found", D.find(new Integer(10)) == null);
		assertTrue("check_structure failed after remove", D.check_structure());
	}
	
	/**
	 * Test that we can remove an element at the end without problem.
	 */
	@Test
	public void testRemoveEnd() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.remove(10);
		assertTrue("Size should be 9, not " + D.size(), D.size() == 9);
		assertNull("20 should not be found", D.find(new Integer(20)));
		assertTrue("check_structure failed after remove", D.check_structure());
	}
	
	/**
	 * Test the clear() function.
	 */
	@Test
	public void testClear() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.clear();
		assertTrue("Size should be 0", D.size() == 0);
		assertTrue("check_structure failed after clear", D.check_structure());
	}
	
	/**
	 * Test that the same key cannot be inserted twice.
	 */
	@Test(expected = IndexOutOfBoundsException.class) 
	public void testRepeatedKey() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.insert(new Integer(6), new Integer(6));
	}
	
	/**
	 * Test that the same value value be inserted twice.
	 */
	@Test
	public void testRepeatedValue() {
		Dictionary<Integer,Integer> D = create_dictionary(10);
		D.insert(new Integer(7),new Integer(7));
	}
}
