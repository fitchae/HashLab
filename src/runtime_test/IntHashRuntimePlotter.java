package runtime_test;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

import data_structures.*;



public class IntHashRuntimePlotter {
	
	/**
	 * Reset D and add all integer values from 0 to n-1 (as doubles).
	 * @param D   Dictionary to be modified.
	 * @param n   Limit on size.
	 * @return    Reference to dictionary.
	 */
	
	static final int M = 2003;   // Try with: 2003, 3001, and 5303
	static final int num_trials = 500;
	static final int size_limit = 2000;
	static final int max_key = 10000000;
	
	static private Set<Integer> dictionary_generator(Dictionary<Integer,String> D, int n, 
																   Random rng, int max_value) {
		D.clear();
		D.resetOps();
		
		Set<Integer> S = new HashSet<Integer>();

		for (int i=0; i < n; i++) {
			Integer v = new Integer(rng.nextInt(max_value));
			while (S.contains(v)) {
				v = new Integer(rng.nextInt(max_value));
			}

			S.add(v);
			D.insert(v, "" + i);
			
		}
		return S;
	}
	

	/**
	 * Plot the runtime for calling get on a list of size n.
	 */
	static void plot_find() {
		int step_size = 20;
		
		CurvePlotter C = new CurvePlotter(0, size_limit, 0, 100, "Runtime: find");
		Dictionary<Integer,String> D = new IntHash<String>(1, 0, M);
		 
		
		Random rng = new Random(1);
		

		for (int size=20; size < size_limit; size += step_size) {
			int total = 0;
			int min = 0;
			int max = 100000;

			for (int trial=0; trial < num_trials; trial++) {
				Set<Integer> S = dictionary_generator(D, size-1, rng, max_key);
				Integer v = new Integer(rng.nextInt(max_key));
				while (S.contains(v)) {
					v = new Integer(rng.nextInt(max_key));
				}
				D.insert(v, "X");
				D.resetOps();
				D.find(v);
				int n = D.numOps();
				
				total += n;
				max = Math.max(max, n);
				min = Math.min(min, n);
			}
			C.add_point(size, total/num_trials, "red");
		}

		C.draw();
	}
	
	static void plot_insert() {
		int step_size = 20;
		
		CurvePlotter C = new CurvePlotter(0, size_limit, 0, 100, "Runtime: insert");
		Dictionary<Integer,String> D = new IntHash<String>(1, 0, M);
		
		Random rng = new Random(2);
		

		for (int size=20; size < size_limit; size += step_size) {
			int total = 0;
			int max = 0;
			int min = 100000;

			for (int trial=0; trial < num_trials; trial++) {
				Set<Integer> S = dictionary_generator(D, size, rng, max_key);				
				D.resetOps();
				Integer val = new Integer(rng.nextInt(max_key)); 
				while (S.contains(val)) {
					val = new Integer(rng.nextInt(max_key));
				}
				D.insert(val, "X");
				int n = D.numOps();
				
				total += n;
				max = Math.max(max, n);
				min = Math.min(min, n);
			}
			C.add_point(size, total/num_trials, "red");
			//C.add_point(size,  max, "blue");
			//C.add_point(size, min, "green");
		}

		C.draw();
	}
	
	static void plot_remove() {
		int step_size = 20;
		
		CurvePlotter C = new CurvePlotter(0, size_limit, 0, 100, "Runtime: remove");
		Dictionary<Integer,String> D = new IntHash<String>(1, 0, M);
		
		Random rng = new Random(3);
		

		for (int size=20; size < size_limit; size += step_size) {
			int total = 0;
			int max = 0;
			int min = 100000;

			for (int trial=0; trial < num_trials; trial++) {
				dictionary_generator(D, size, rng, max_key);
				D.resetOps();
				Integer val = rng.nextInt(max_key);    
				D.remove(val);
				int n = D.numOps();
				
				total += n;
				max = Math.max(max, n);
				min = Math.min(min, n);
			}
			C.add_point(size, total/num_trials, "red");
		}

		C.draw();
	}
	

	
	public static void main(String[] args) {
		plot_find();
		plot_insert();
		plot_remove();
	}
}
