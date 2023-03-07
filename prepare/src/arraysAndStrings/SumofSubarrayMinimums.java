package arraysAndStrings;

import java.util.Stack;

public class SumofSubarrayMinimums {

	public static void main(String[] args) {
		int[] arr = { 19, 19, 62, 66 };
		System.out.println(solve(arr));

	}

	private static int solve(int[] arr) {

		int mod = 1000000007;

		if (arr.length == 0) {
			return 0;
		}
		if (arr.length == 1) {
			return arr[0];
		}
		long sum = 0;
		int[] nle = findNLE(arr);
		int[] ple = findPLE(arr);

		for (int i = 0; i < arr.length; i++) {
			long temp = (i - nle[i]) * (ple[i] - i);
			sum += (arr[i] * temp);
		}

		return (int) (sum % mod);
	}

	private static int[] findPLE(int[] arr) {
		int[] nle = new int[arr.length];
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < arr.length; i++) {
			if (stack.isEmpty()) {
				nle[i] = -1;
			} else if (stack.peek()[1] <= arr[i]) {
				nle[i] = stack.peek()[0];
			} else if (stack.peek()[1] > arr[i]) {
				while (!stack.isEmpty() && stack.peek()[1] > arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					nle[i] = -1;
				} else if (stack.peek()[1] <= arr[i]) {
					nle[i] = stack.peek()[0];
				}
			}
			stack.add(new int[] { i, arr[i] });
		}
		return nle;
	}

	private static int[] findNLE(int[] arr) {
		int[] ple = new int[arr.length];
		Stack<int[]> stack = new Stack<>();

		for (int i = arr.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				ple[i] = arr.length;
			} else if (stack.peek()[1] < arr[i]) {
				ple[i] = stack.peek()[0];
			} else if (stack.peek()[1] >= arr[i]) {
				while (!stack.isEmpty() && stack.peek()[1] >= arr[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					ple[i] = arr.length;
				} else if (stack.peek()[1] < arr[i]) {
					ple[i] = stack.peek()[0];
				}
			}
			stack.add(new int[] { i, arr[i] });
		}
		return ple;
	}

}
