package arrays;

import java.util.Arrays;
import java.util.List;

public class SherlokArray {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(0, 0, 2, 0);
		System.out.println(solve(arr));

	}

	private static String solve(List<Integer> arr) {

		int start = 0;
		int end = arr.size() - 1;
		int leftSum = arr.get(start);
		int rightSum = arr.get(end);

		while (start < end) {
			if (leftSum == rightSum) {
				start++;
				end--;
				if (start < arr.size() && end >= 0) {
					leftSum = leftSum + arr.get(start);
					rightSum = rightSum + arr.get(end);
				}

			} else if (leftSum < rightSum) {
				start++;
				if (start < arr.size()) {
					leftSum = leftSum + arr.get(start);
				}
			} else if (leftSum > rightSum) {
				end--;
				if (end >= 0) {
					rightSum = rightSum + arr.get(end);
				}
			}
		}

		return leftSum == rightSum ? "YES" : "NO";
	}

}
