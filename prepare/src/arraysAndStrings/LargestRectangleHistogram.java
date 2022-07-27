package arraysAndStrings;

import java.util.Stack;

public class LargestRectangleHistogram {

	public static void main(String[] args) {
		int[] heights = { 2, 3, 3, 2 };

		System.out.println(solve(heights));

	}

	private static int solve(int[] heights) {
		int maxArea = Integer.MIN_VALUE;

		if (heights.length == 0) {
			return 0;
		}

		int[] nSR = nearestSmallerToRight(heights);

		int[] nSL = nearestSmallerToLeft(heights);

		for (int i = 0; i < heights.length; i++) {
			int width = nSR[i] - nSL[i] - 1;
			maxArea = Math.max(maxArea, width * heights[i]);
		}
		return maxArea;
	}

	private static int[] nearestSmallerToLeft(int[] heights) {

		int[] result = new int[heights.length];
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < heights.length; i++) {
			if (stack.size() == 0) {
				result[i] = -1;
			} else if (stack.size() > 0 && stack.peek()[0] >= heights[i]) {
				while (stack.size() > 0 && stack.peek()[0] >= heights[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					result[i] = -1;
				} else {
					result[i] = stack.peek()[1];
				}
			} else if (stack.size() > 0 && stack.peek()[0] < heights[i]) {
				result[i] = stack.peek()[1];
			}
			stack.push(new int[] { heights[i], i });
		}

		return result;

	}

	private static int[] nearestSmallerToRight(int[] heights) {
		int[] result = new int[heights.length];
		Stack<int[]> stack = new Stack<>();

		for (int i = heights.length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				result[i] = heights.length;
			} else if (stack.size() > 0 && stack.peek()[0] >= heights[i]) {
				while (stack.size() > 0 && stack.peek()[0] >= heights[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					result[i] = heights.length;
				} else {
					result[i] = stack.peek()[1];
				}
			} else if (stack.size() > 0 && stack.peek()[0] < heights[i]) {
				result[i] = stack.peek()[1];
			}
			stack.push(new int[] { heights[i], i });
		}

		return result;

	}

}
