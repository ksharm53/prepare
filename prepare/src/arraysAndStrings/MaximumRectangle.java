package arraysAndStrings;

import java.util.Stack;

public class MaximumRectangle {

	public static void main(String[] args) {
		char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '0', '1', '0' } };

		System.out.println(maximalRectangle(matrix));

	}

	public static int maximalRectangle(char[][] matrix) {
		int[] tempArray = new int[matrix[0].length];
		int area = Integer.MIN_VALUE;

		for (int i = 0; i < matrix.length; i++) {
			char[] innerArray = matrix[i];
			for (int j = 0; j < innerArray.length; j++) {
				if (innerArray[j] == '0') {
					tempArray[j] = 0;
				} else {
					tempArray[j]++;
				}
			}

			int[] psl = psl(tempArray);
			int[] nsl = nsl(tempArray);

			for (int j = 0; j < tempArray.length; j++) {
				int width = nsl[j] - psl[j] - 1;
				area = Math.max(area, width * tempArray[j]);
			}
		}

		return area;
	}

	public static int[] psl(int[] tempArray) {
		int[] result = new int[tempArray.length];
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < tempArray.length; i++) {
			if (stack.isEmpty()) {
				result[i] = -1;
			} else if (stack.peek()[1] < tempArray[i]) {
				result[i] = stack.peek()[0];
			} else if (stack.peek()[1] >= tempArray[i]) {
				while (!stack.isEmpty() && stack.peek()[1] >= tempArray[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					result[i] = -1;
				} else if (stack.peek()[1] < tempArray[i]) {
					result[i] = stack.peek()[0];
				}
			}
			stack.add(new int[] { i, tempArray[i] });
		}
		return result;
	}

	public static int[] nsl(int[] tempArray) {
		int[] result = new int[tempArray.length];
		Stack<int[]> stack = new Stack<>();
		for (int i = tempArray.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				result[i] = tempArray.length;
			} else if (stack.peek()[1] < tempArray[i]) {
				result[i] = stack.peek()[0];
			} else if (stack.peek()[1] >= tempArray[i]) {
				while (!stack.isEmpty() && stack.peek()[1] >= tempArray[i]) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					result[i] = tempArray.length;
				} else if (stack.peek()[1] < tempArray[i]) {
					result[i] = stack.peek()[0];
				}
			}
			stack.add(new int[] { i, tempArray[i] });
		}
		return result;
	}

}
