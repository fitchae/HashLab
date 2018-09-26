package unit_test;

import static org.junit.Assert.*;

import org.junit.Test;
import data_structures.IntHash;

public class IntHashTester {


	@Test
	public void test1() {
		int m = 11;
		int s = 5;		
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s), "a");
		S.insert(new Integer(s + m), "b");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s + m)), "b");
	}
	

	@Test
	public void test1b() {
		int m = 11;
		int s = m-1;		
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s), "a");
		S.insert(new Integer(s + m), "b");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s + m)), "b");
	}
		
	
	
	@Test
	public void test2() {
		int m = 11;
		int s = 2;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s), "a");
		S.insert(new Integer(s + m), "b");
		S.insert(new Integer(s + 2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s + m)), "b");
		assertEquals(S.find(new Integer(s + 2*m)), "c");
		S.remove(new Integer(s+2*m));
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertNull(S.find(new Integer(s+2*m)));
	}
	
	@Test
	public void test2b() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s), "a");
		S.insert(new Integer(s + m), "b");
		S.insert(new Integer(s + 2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(new Integer(s+2*m));
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertNull(S.find(new Integer(s+2*m)));
	}
	
	
	@Test
	public void test3() {
		int m = 11;
		int s = 2;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+m), "b");
		S.insert(new Integer(s+2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(new Integer(s+m));
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+2*m)), "c");
	}
	
	@Test
	public void testb3b() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+m), "b");
		S.insert(new Integer(s+2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(s+m);
		assertEquals(S.find(new Integer(s)), "a");
		assertNull(S.find(new Integer(s + m)));
		assertEquals(S.find(new Integer(s+2*m)), "c");
	}
	
	
	@Test
	public void test4() {
		int m = 11;
		int s = 4;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+m), "b");
		S.insert(new Integer(s+2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(new Integer(s+m));
		S.insert(new Integer(s+m), "d");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "d");
		assertEquals(S.find(new Integer(s+2*m)), "c");
	}
	
	@Test
	public void test4b() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+m), "b");
		S.insert(new Integer(s+2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(new Integer(s+m));
		S.insert(new Integer(s+m), "d");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+m)), "d");
		assertEquals(S.find(new Integer(s+2*m)), "c");
	}

	@Test
	public void test5() {
		int m = 11;
		int s = 2;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+1), "b");
		S.insert(new Integer(s+m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+1)), "b");
		assertEquals(S.find(new Integer(s+m)), "c");
	}
	
	@Test
	public void test5b() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+1), "b");
		S.insert(new Integer(s+m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+1)), "b");
		assertEquals(S.find(new Integer(s+m)), "c");
	}
	
	@Test
	public void test6() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+1), "b");
		S.insert(new Integer(s+2*m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+1)), "b");
		assertEquals(S.find(new Integer(s+2*m)), "c");
		S.remove(new Integer(s+1));       
		assertEquals(S.find(new Integer(s)), "a");
		assertNull(S.find(new Integer(s+1)));
		assertEquals(S.find(new Integer(s+2*m)), "c");
	}
	
	@Test
	public void test6b() {
		int m = 11;
		int s = m-1;
		IntHash<String> S = new IntHash<String>(1,0,m);
		S.insert(new Integer(s),  "a");
		S.insert(new Integer(s+1), "b");
		S.insert(new Integer(s+m), "c");
		assertEquals(S.find(new Integer(s)), "a");
		assertEquals(S.find(new Integer(s+1)), "b");
		assertEquals(S.find(new Integer(s+m)), "c");
		S.remove(new Integer(s+1));
		assertEquals(S.find(new Integer(s)), "a");
		assertNull(S.find(new Integer(s+1)));
		assertEquals(S.find(new Integer(s+m)), "c");
	}
	
}
