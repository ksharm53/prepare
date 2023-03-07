package arrays09162022;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InsertInterval {

	public static void main(String[] args) {
		int[][] intervals = { { 1, 5 } };
		int[] newInterval = { 6, 8 };

		System.out.println(insert(intervals, newInterval));

	}

	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length == 0) {
			return new int[][] { newInterval };
		}
		Stack<int[]> stack = new Stack<>();
		List<int[]> list = new ArrayList<>();
		boolean entered = false;

		for (int i = intervals.length - 1; i >= 0; i--) {
			stack.push(intervals[i]);
		}

		while (!stack.isEmpty()) {
			int[] top = stack.peek();
			if (newInterval[1] < top[0]) {
				list.add(newInterval);
				entered = false;
				break;
			} else if (newInterval[0] <= top[1]) {
				newInterval = new int[] { Math.min(top[0], newInterval[0]), Math.max(top[1], newInterval[1]) };
				entered = true;
				stack.pop();
			} else if (newInterval[0] > top[1]) {
				list.add(stack.pop());
				if (stack.size() == 0) {
					list.add(newInterval);
				}
			}

		}

		if (entered) {
			list.add(newInterval);
		}
		while (!stack.isEmpty()) {
			list.add(stack.pop());
		}

		int[][] result = new int[list.size()][2];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
