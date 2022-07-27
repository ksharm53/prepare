package arraysAndStrings;

import java.util.Arrays;

public class MinimumMovesEqualArrayElements {

	public static void main(String[] args) {
		int[] nums = { 203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656,
				-425653504, -212123143 };

		System.out.println(solve(nums));
		
		System.out.println(solveMean(nums));

	}

	private static int solve(int[] nums) {

		Arrays.sort(nums);

		int result = Integer.MAX_VALUE;

		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			long count = findResult(mid, nums);
			if (count <= result) {
				result = (int) count;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;

	}

	private static long findResult(int mid, int[] nums) {
		long count = 0;
		for (int i = 0; i < nums.length; i++) {
			count = count + Math.abs(nums[i] - nums[mid]);
		}
		return count;

	}

	private static int solveMean(int[] nums) {

		Arrays.sort(nums);

		int result = 0;

		int size = nums.length;
		int median = size / 2;

		for (int i = 0; i < nums.length; i++) {
			result = result + Math.abs(nums[i] - nums[median]);
		}
		return result;

	}

}
