package arraysAndStrings;

import java.util.Stack;

public class NextGreaterElementII {

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,3};

		System.out.println(solve(nums));

	}

	private static int[] solve(int[] nums) {

		int max = Integer.MIN_VALUE;
		int[] result = new int[nums.length];
		Stack<Integer> stack = new Stack<>();
		int maxIndex = -1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= max) {
				max = nums[i];
				maxIndex = i;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int index = (nums.length + maxIndex - i) % nums.length;

			if (stack.size() == 0) {
				result[index] = -1;
			} else if (stack.size() > 0 && nums[index] < stack.peek()) {
				result[index] = stack.peek();
			} else if (stack.size() > 0 && nums[index] >= stack.peek()) {
				while (stack.size() > 0 && nums[index] >= stack.peek()) {
					stack.pop();
				}
				if (stack.size() == 0) {
					result[index] = -1;
				} else {
					result[index] = stack.peek();
				}
			}
			stack.add(nums[index]);
		}
		return result;

	}

}
