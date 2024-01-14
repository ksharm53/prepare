package dec;

import java.util.Stack;

public class MaximalSquare {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };
		System.out.println(solve(matrix));

	}

	private static int solve(char[][] matrix) {
		int[][] grid = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix[0].length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[j][i] == '1') {
					grid[j][i] = (j - 1 < 0 ? 0 : grid[j - 1][i]) + 1;
				}
			}
		}

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < grid.length; i++) {
			int[] eachVal = grid[i];
			max = Math.max(max, maxAreaHist(eachVal));
		}

		return max;
	}

	private static int maxAreaHist(int[] eachVal) {
		int[] nsl = nearestSmallerToLeft(eachVal);
		int[] nsr = nearestSmallerToRight(eachVal);

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < eachVal.length; i++) {
			int width = nsr[i] - nsl[i] - 1;
			int height = eachVal[i];
			int size = Math.min(height, width);
			max = Math.max(max, size * size);
		}
		return max;
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

}
