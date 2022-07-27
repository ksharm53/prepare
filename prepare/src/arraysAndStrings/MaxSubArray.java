package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxSubArray {

	public static void main(String[] args) {
		List<Integer> arr = Arrays.asList(2, -1, 2, 3, 4, -5);
		System.out.println(solve(arr));
	}

	private static List<Integer> solve(List<Integer> arr) {
		int maxSubsequence = subSequence(arr);
		int maxSubArray = subArray(arr);
		return Arrays.asList(maxSubArray, maxSubsequence);
	}

	private static int subSequence(List<Integer> array) {
		List<Integer> arr = new ArrayList<>(array);
		Collections.sort(arr);

		int sum = arr.get(arr.size() - 1);
		int max = sum;

		for (int i = arr.size() - 2; i >= 0; i--) {
			sum = sum + arr.get(i);
			max = Math.max(max, sum);
		}
		return max;
	}

	private static int subArray(List<Integer> arr) {
		int localSum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.size(); i++) {
			localSum = Math.max(localSum + arr.get(i), arr.get(i));
			max = Math.max(max, localSum);
		}
		return max;
	}

}
