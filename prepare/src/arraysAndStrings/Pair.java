package arraysAndStrings;

import java.util.HashSet;
import java.util.Set;

public class Pair {

	public static void main(String[] args) {
		int[] array = new int[] { 30, 20, 150, 100, 40 };
		System.out.println(solve(array));
	}

	private static int solve(int[] array) {
		Set<Integer> set = new HashSet<>();
		int counter = 0;
		if (array.length == 0) {
			return 0;
		}
		for (int i = 0; i < array.length; i++) {
			if (set.contains(60 - (array[i] % 60))) {
				counter++;
			}
			set.add(array[i] % 60);
		}
		return counter;
	}

}
