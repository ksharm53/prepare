package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxAbsoluteDiff {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(55, -8, 43, 52, 8, 59, -91, -79, -18, -94);

		System.out.println(solve(list));
		System.out.println(solveAgain(list));

	}

	private static int solve(List<Integer> list) {
		if (list.size() == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				max = Math.max(max, Math.abs(list.get(i) - list.get(j)) + Math.abs(i - j));
			}
		}
		return max;
	}

	private static int solveAgain(List<Integer> list) {
		if (list.size() == 0) {
			return 0;
		}
		List<Integer> maxList = new ArrayList<>(list);
		List<Integer> minList = new ArrayList<>(list);
		Collections.sort(maxList);
		Collections.reverse(maxList);

		Collections.sort(minList);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < list.size(); i++) {
			int difference = Math.abs(maxList.get(i) - minList.get(i));
			int indexDiff = Math.abs(list.indexOf(maxList.get(i)) - list.lastIndexOf(minList.get(i)));
			if (maxList.get(i) == minList.get(i)) {
				max = Math.abs(list.indexOf(maxList.get(i)) - list.lastIndexOf(maxList.get(i)));
			} else {
				max = Math.max(max, difference + indexDiff);
			}
		}
		return max;
	}

}
