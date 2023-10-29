package may1;

import java.util.Stack;

public class LongestObstacleCourseAtEachPosition {

	public static void main(String[] args) {
		int[] obstacles = { 5, 1, 5, 5, 1, 3, 4, 5, 1, 4 };
		// 5, 1, 1, 1, 1, 1, 1, 1, 1, 1
		// 1, 1, 2, 3, 2, 3, 4, 5, 3,

		System.out.println(longestObstacleCourseAtEachPosition(obstacles));

	}

	public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
		int[] arr = new int[obstacles.length];

		int[] nll = nextLowerLeft(obstacles);

		for (int i = 0; i < obstacles.length; i++) {
			if (i == 0) {
				arr[i] = 1;
			}

			else {
				if (nll[i] == -1) {
					arr[i] = 1;
				} else {

					arr[i] = arr[nll[i]] + 1;
				}
			}
		}
		return arr;
	}

	private static int[] nextLowerLeft(int[] obstacles) {
		int[] res = new int[obstacles.length];

		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < obstacles.length; i++) {
			if (stack.isEmpty()) {
				res[i] = -1;
			} else {
				while (!stack.isEmpty() && stack.peek()[0] > obstacles[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					res[i] = -1;
				} else {
					res[i] = stack.peek()[1];
				}
			}

			stack.push(new int[] { obstacles[i], i });
		}
		return res;
	}

}
