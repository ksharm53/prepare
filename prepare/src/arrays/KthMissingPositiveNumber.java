package arrays;

import java.util.List;
import java.util.stream.IntStream;

public class KthMissingPositiveNumber {

	public static void main(String[] args) {
		int[] arr = { 1, 2 };
		int k = 1;

		System.out.println(solve(arr, k));

	}

	private static int solve(int[] arr, int k) {
		List<Integer> list = IntStream.of(arr).boxed().toList();
		int value = 1;
		while (k > 0) {
			if (!list.contains(value)) {
				k--;
				if (k == 0) {
					break;
				}
			}
			value++;
		}
		return value;
	}

}
