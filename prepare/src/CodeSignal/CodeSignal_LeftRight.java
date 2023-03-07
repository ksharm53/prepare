package CodeSignal;

import java.util.ArrayList;
import java.util.List;

public class CodeSignal_LeftRight {

	public static void main(String[] args) {
		int[] numbers = { 8, 5, 6, 16, 5 };
		int left = 1;
		int right = 3;

		System.out.println(solution(numbers, left, right));

	}

	public static boolean[] solution(int[] numbers, int left, int right) {
		boolean[] result = new boolean[numbers.length];
		List<Double> list = new ArrayList<>();

		for (int i = left; i <= right; i++) {
			list.add((double) i);
		}

		for (int i = 0; i < numbers.length; i++) {
			double x = (double) numbers[i] / (double) (i + 1);
			if (list.contains(x)) {
				result[i] = true;
			} else {
				result[i] = false;
			}
		}
		return result;
	}

}
