package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountingSOrt {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(1, 1, 3, 2, 1);

		System.out.println(solve(arr));

	}

	private static List<Integer> solve(List<Integer> arr) {
		List<Integer> list = new ArrayList<>();

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Integer each : arr) {
			min = Math.min(min, each);
			max = Math.max(max, each);
		}

		int[] array = new int[max - min + 2];

		for (int i = 0; i < 100; i++) {
			array[arr.get(i)]++;
		}

		for (int i : array) {
			list.add(i);
		}
		return list;
	}

}
