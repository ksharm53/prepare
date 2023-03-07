package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence {
	static int[][] matrix;

	public static void main(String[] args) {
		int[] nums = { 1, 4, 3 };
		List<Integer> tempAgain = new ArrayList<>();

		for (int each : nums) {
			if (!tempAgain.contains(each)) {
				tempAgain.add(each);
			}
		}
		Collections.sort(tempAgain);

		matrix = new int[nums.length + 1][tempAgain.size() + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(nums, nums.length-1, tempAgain, tempAgain.size()-1));

	}

	private static int solve(int[] nums, int numsLength, List<Integer> temp, int tempLength) {		

		if (numsLength < 0 || tempLength < 0) {
			return 0;
		}
		
		if (matrix[numsLength][tempLength] != -1) {
			return matrix[numsLength][tempLength];
		}

		if (nums[numsLength] == temp.get(tempLength)) {
			return matrix[numsLength][tempLength] = 1 + solve(nums, numsLength - 1, temp, tempLength - 1);
		} else {
			return matrix[numsLength][tempLength] = Math.max(solve(nums, numsLength, temp, tempLength - 1),
					solve(nums, numsLength - 1, temp, tempLength));
		}

	}

}
