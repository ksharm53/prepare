package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

public class CountSmalleNumbersAfteSelf {

	public static void main(String[] args) {
		int[] nums = { 8, 1, 2, 2, 3 };

		// System.out.println(solve(nums));
		// System.out.println(solveStack(nums));
		System.out.println(solve1365(nums));

	}

	private static int[] solve1365(int[] nums) {
		int[] result = new int[nums.length];

		int[] temp = Arrays.copyOf(nums, nums.length);
		Arrays.sort(temp);
		List<Integer> list = IntStream.of(temp).boxed().toList();

		for (int i = 0; i < nums.length; i++) {
			result[i] = list.indexOf(nums[i]);
		}

		return result;
	}

	private static List<Integer> solve(int[] nums) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int eachCount = 0;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[i]) {
					eachCount++;
				}
			}
			list.add(eachCount);
		}
		return list;
	}

	private static List<Integer> solveStack(int[] nums) {
		int[] result = new int[nums.length];
		Stack<int[]> stack = new Stack<>();
		int size = 0;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (stack.size() == 0) {
				result[i] = 0;
			} else if (stack.size() > 0 && nums[i] <= stack.peek()[0]) {
				while (stack.size() > 0 && nums[i] <= stack.peek()[0]) {
					stack.pop();
				}
				if (stack.size() == 0) {
					result[i] = 0;
				} else {
					result[i] = size;
				}

			} else if (stack.size() > 0 && nums[i] > stack.peek()[0]) {
				size = size + 1;
				result[i] = size;
			}
			stack.push(new int[] { nums[i], size });
		}

		return IntStream.of(result).boxed().toList();
	}

}
