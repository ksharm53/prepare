package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumAreaRectangle {

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };

		System.out.println(solve(matrix));
	}

	private static int solve(int[][] matrix) {

		List<Integer> list1 = new ArrayList<>();

		for (int i = 0; i < matrix[0].length; i++) {
			list1.add(matrix[0][i]);
		}

		int max = maxArea(list1);

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				int prev = list1.get(j);
				if (matrix[i][j] != 0) {
					list1.set(j, prev + matrix[i][j]);
				} else {
					list1.set(j, 0);
				}
			}
			max = Math.max(max, maxArea(list1));
		}
		return max;

	}

	private static int maxArea(List<Integer> list1) {

		List<Integer> nslList = findNSL(list1);
		List<Integer> nslLisR = findNSR(list1);
		int maximum = Integer.MIN_VALUE;

		for (int i = 0; i < list1.size(); i++) {
			int width = nslLisR.get(i) - nslList.get(i) - 1;
			int height = list1.get(i);

			maximum = Math.max(maximum, height * width);
		}
		return maximum;

	}

	private static List<Integer> findNSR(List<Integer> list1) {

		int[] listtemp = new int[list1.size()];

		Stack<int[]> stack = new Stack<>();
		List<Integer> NSR = new ArrayList<>();
		for (int i = list1.size() - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				listtemp[i] = list1.size();
			} else if (stack.size() > 0 && stack.peek()[0] >= list1.get(i)) {
				while (stack.size() > 0 && stack.peek()[0] >= list1.get(i)) {
					stack.pop();
				}
				if (stack.size() == 0) {
					listtemp[i] = list1.size();
				} else {
					listtemp[i] = stack.peek()[1];
				}
			} else if (stack.size() > 0 && list1.get(i) > stack.peek()[0]) {
				listtemp[i] = stack.peek()[1];
			}
			stack.push(new int[] { list1.get(i), i });
		}

		for (int i = 0; i < listtemp.length; i++) {
			NSR.add(listtemp[i]);
		}
		return NSR;
	}

	private static List<Integer> findNSL(List<Integer> list1) {
		Stack<int[]> stack = new Stack<>();
		List<Integer> NSL = new ArrayList<>();
		for (int i = 0; i < list1.size(); i++) {
			if (stack.size() == 0) {
				NSL.add(-1);
			} else if (stack.size() > 0 && stack.peek()[0] >= list1.get(i)) {
				while (stack.size() > 0 && stack.peek()[0] >= list1.get(i)) {
					stack.pop();
				}
				if (stack.size() == 0) {
					NSL.add(-1);
				} else {
					NSL.add(stack.peek()[1]);
				}
			} else if (stack.size() > 0 && list1.get(i) > stack.peek()[0]) {
				NSL.add(stack.peek()[1]);
			}
			stack.push(new int[] { list1.get(i), i });
		}
		return NSL;

	}

}
