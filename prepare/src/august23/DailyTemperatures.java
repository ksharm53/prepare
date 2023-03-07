package august23;

import java.util.Stack;

public class DailyTemperatures {

	public static void main(String[] args) {
		int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
		System.out.println(solve(temperatures));

	}

	private static int[] solve(int[] temperatures) {
		int[] nextWarmer = new int[temperatures.length];
		int[] warmresult = new int[temperatures.length];
		Stack<int[]> stack = new Stack<>();

		for (int i = temperatures.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				nextWarmer[i] = 0;
			} else if (stack.peek()[1] > temperatures[i]) {
				nextWarmer[i] = stack.peek()[0];
			} else if (stack.peek()[1] <= temperatures[i]) {
				while (!stack.isEmpty() && stack.peek()[1] <= temperatures[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					nextWarmer[i] = 0;
				} else if (stack.peek()[1] > temperatures[i]) {
					nextWarmer[i] = stack.peek()[0];
				}
			}
			stack.push(new int[] { i, temperatures[i] });
		}

		for (int i = 0; i < nextWarmer.length; i++) {
			if (nextWarmer[i] == 0) {
				warmresult[i] = 0;
			} else {
				warmresult[i] = nextWarmer[i] - i;
			}
		}
		return warmresult;

	}

}
