package arraysAndStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pairs {

	public static void main(String[] args) {
		int k = 2;
		List<Integer> arr = Arrays.asList(1, 5, 3, 4, 2);

		System.out.println(solve(arr, k));

		System.out.println(solveSet(arr, k));

	}

	private static int solveSet(List<Integer> arr, int k) {
		Set<Integer> set = new HashSet<>();
		int counter = 0;
		for (Integer integer : arr) {
			set.add(integer);
		}

		for (Integer integer : arr) {
			if (set.contains(integer + k)) {
				counter++;
			}
		}
		return counter;
	}

	private static int solve(List<Integer> arr, int k) {
		Collections.sort(arr);
		int counter = 0;

		for (int i = 0; i < arr.size(); i++) {
			for (int j = i + 1; j < arr.size(); j++) {
				if (Math.abs(arr.get(i) - arr.get(j)) == k) {
					counter++;
					while (j + 1 < arr.size() && arr.get(j + 1) == arr.get(j)) {
						counter++;
					}
					break;
				}
			}
		}
		return counter;
	}

}
