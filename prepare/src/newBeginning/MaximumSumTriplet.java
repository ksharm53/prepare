package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaximumSumTriplet {
	static int matrix[][];

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(2, 5, 3, 1, 4, 9);
		/*
		 * List<Integer> A1 = new ArrayList<>(A); Collections.sort(A1);
		 * 
		 * matrix = new int[A.size() + 1][A1.size() + 1]; for (int[] eachRow : matrix) {
		 * Arrays.fill(eachRow, -1); }
		 */

		System.out.println(solve(A));


	}

	// Did not worked with memoization
	private static int solverecursion(List<Integer> a, List<Integer> a1, int size, int size1, int counter) {

		if (size == 0 || size1 == 0) {
			return 0;
		}

		if (a.get(size - 1) == a1.get(size1 - 1) && counter > 0) {
			int value = a.get(size - 1);
			counter = counter - 1;
			return value + solverecursion(a, a1, size - 1, size1 - 1, counter);
		} else {
			return Math.max(solverecursion(a, a1, size - 1, size1, counter),
					solverecursion(a, a1, size, size1 - 1, counter));
		}

	}

	private static int solve(List<Integer> a) {

		if (a.size() < 3) {
			return 0;
		}
		int size = a.size();
		int[] suffixArray = new int[size];
		int[] lowerArray = new int[size];
		suffixArray[size - 1] = 0;
		int max = Integer.MIN_VALUE;

		for (int i = size - 2; i >= 0; i--) {
			suffixArray[i] = Math.max(suffixArray[i + 1], a.get(i + 1));
		}

		TreeSet<Integer> set = new TreeSet<>();

		for (int i = 1; i < a.size(); i++) {
			set.add(a.get(i - 1));
			Integer lower = set.lower(a.get(i));
			lowerArray[i] = lower == null ? 0 : lower;
		}

		for (int i = 0; i < a.size(); i++) {
			if (lowerArray[i] == 0 || suffixArray[i] < a.get(i)) {
				continue;
			}
			max = Math.max(max, a.get(i) + suffixArray[i] + lowerArray[i]);
		}
		return max;

	}

}
