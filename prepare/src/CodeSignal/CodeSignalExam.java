package CodeSignal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CodeSignalExam {

	public static void main(String[] args) {
		int[] first = { 1, 2 };
		int[] second = { 3, 1 };

		System.out.println(solve(first, second));

	}

	private static int solve(int[] first, int[] second) {
		if (first.length == 0 || second.length == 0) {
			return 0;
		}

		List<Integer> list1 = new ArrayList<>(IntStream.of(first).boxed().toList());
		List<Integer> list2 = new ArrayList<>(IntStream.of(second).boxed().toList());
		int counter = 0;
		while (list1.size() > 0 && list2.size() > 0) {
			counter++;
			int first1 = list1.get(0);
			int first2 = list2.get(0);

			if (first1 >= first2) {
				list1.remove(0);
				list1.add(first1);
				list1.add(first2);
				list2.remove(0);
			} else {
				list2.remove(0);
				list2.add(first2);
				list2.add(first1);
				list1.remove(0);
			}
		}
		return counter;
	}

}
