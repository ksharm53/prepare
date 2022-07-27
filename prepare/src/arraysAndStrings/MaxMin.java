package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxMin {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(100, 200, 300, 350, 400, 401, 402);
		int k = 3;

		System.out.println(maxMin(k, list));
	}

	public static int maxMin(int k, List<Integer> arr) {
		Collections.sort(arr);
		int i = 0;
		int j = 0;
		List<Integer> list = new ArrayList<>();
		int min = Integer.MAX_VALUE;

		while (j < arr.size()) {
			list.add(arr.get(j));
			if (j - i + 1 < k) {
				j++;
			} else if (j - i + 1 == k) {
				min = Math.min(list.get(k - 1) - list.get(0), min);
				list.remove(0);
				i++;
				j++;
			}
		}
		return min;
	}

}
