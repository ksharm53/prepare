package arraysAndStrings;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 5, 2, 4 };
		int[] nums2 = { 6, 5, 4, 3, 2, 1, 7 };

		System.out.println(solve(nums1, nums2));

	}

	private static int[] solve(int[] nums1, int[] nums2) {
		int[] result = new int[nums1.length];
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = Arrays.stream(nums1).boxed().toList();

		for (int i = nums2.length - 1; i >= 0; i--) {
			int index = list.indexOf(nums2[i]);
			if (stack.size() == 0) {
				if (index >= 0) {
					result[index] = -1;
				}
			} else if (stack.size() > 0 && stack.peek() > nums2[i]) {
				if (index >= 0) {
					result[index] = stack.peek();
				}
			} else if (stack.size() > 0 && stack.peek() <= nums2[i]) {
				while (stack.size() > 0 && stack.peek() <= nums2[i]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					if (index >= 0) {
						result[index] = -1;
					}
				} else {
					if (index >= 0) {
						result[index] = stack.peek();
					}
				}
			}
			stack.add(nums2[i]);
		}
		return result;

	}

}
