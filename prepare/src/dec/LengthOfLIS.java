package dec;

import java.util.Arrays;

public class LengthOfLIS {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] nums = { 7, 7, 7, 7, 7, 7, 7 };
		int[] copyNums = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			int idx = Arrays.binarySearch(copyNums, nums[i]);
			if (idx >= 0) {
				continue;
			}else {
				
			}
		}

		matrix = new int[nums.length][copyNums.length];
		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}
		Arrays.sort(copyNums);
		System.out.println(solve(nums, copyNums, 0, 0));
	}

	private static int solve(int[] nums, int[] copyNums, int idxO, int idxC) {
		if (idxC == copyNums.length || idxO == nums.length) {
			return 0;
		}

		if (matrix[idxO][idxC] != -1) {
			return matrix[idxO][idxC];
		}

		if (nums[idxO] == copyNums[idxC]) {
			return matrix[idxO][idxC] = 1 + solve(nums, copyNums, idxO + 1, idxC + 1);

		} else {
			int liya = solve(nums, copyNums, idxO, idxC + 1);
			int naiLiya = solve(nums, copyNums, idxO + 1, idxC);

			return matrix[idxO][idxC] = Math.max(liya, naiLiya);
		}
	}

}
