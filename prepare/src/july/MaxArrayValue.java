package july;

import java.util.Stack;

public class MaxArrayValue {

	public static void main(String[] args) {
		int[] nums = { 5, 3, 3 };
		System.out.println(solve(nums));
	}

	private static long solve(int[] nums) {
		Stack<Long> stack = new Stack<>();
		Long max = Long.MIN_VALUE;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (stack.isEmpty() || nums[i] > stack.peek()) {
				stack.push((long) nums[i]);
				max = Math.max(max, nums[i]);
			} else {
				long sum = stack.pop() + nums[i];
				stack.push(sum);
				max = Math.max(max, sum);
			}
		}
		return max;
	}

}
