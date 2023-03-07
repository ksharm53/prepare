package newBeginning;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SeparateDigits {

	public static void main(String[] args) {
		int[] nums = { 13, 25, 83, 77 };
		System.out.println(solve(nums));
	}

	private static int[] solve(int[] nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			int val = nums[i];
			Stack<Integer> stack = new Stack<>();
			while (val > 0) {
				stack.add(val % 10);
				val = val / 10;
			}
			while (!stack.isEmpty()) {
				list.add(stack.pop());
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

}
