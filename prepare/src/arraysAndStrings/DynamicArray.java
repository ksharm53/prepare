package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {

	public static void main(String[] args) {
		int n = 2;
		List<List<Integer>> queries = Arrays.asList(Arrays.asList(1, 0, 5), Arrays.asList(1, 1, 7),
				Arrays.asList(1, 0, 3), Arrays.asList(2, 1, 0), Arrays.asList(2, 1, 1));

		System.out.println(dynamicArray(n, queries));

	}

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		int lastAnswer = 0;
		List<Integer> list = new ArrayList<>();
		int[] arr = new int[n];

		for (int i = 0; i < queries.size(); i++) {
			if (queries.get(i).get(0) == 1) {
				int idx = (queries.get(i).get(1) ^ lastAnswer) % n;
				System.out.println(idx);
				arr[idx] = queries.get(i).get(2);
			} else {
				int idx = (queries.get(i).get(1) ^ lastAnswer) % n;
				lastAnswer = queries.get(idx).get(queries.get(i).get(2) % queries.get(idx).size());
				arr[idx] = lastAnswer;
			}

		}
		for (int i : arr) {
			list.add(i);
		}
		return list;

	}

}
