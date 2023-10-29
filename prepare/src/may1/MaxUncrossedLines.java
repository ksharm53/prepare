package may1;

import java.util.Arrays;

public class MaxUncrossedLines {

	static int[][] matrix;

	public static void main(String[] args) {
		int[] nums1 = { 1, 3, 7, 1, 7, 5 };
		int[] nums2 = { 1, 9, 2, 5, 1 };

		matrix = new int[nums1.length + 1][nums2.length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		System.out.println(solve(nums1, nums2, 0, 0));

	}

	private static int solve(int[] nums1, int[] nums2, int nums1Idx, int nums2Idx) {
		if (nums1Idx >= nums1.length || nums2Idx >= nums2.length) {
			return 0;
		}

		if (matrix[nums1Idx][nums2Idx] != -1) {
			return matrix[nums1Idx][nums2Idx];
		}

		if (nums1[nums1Idx] == nums2[nums2Idx]) {
			return matrix[nums1Idx][nums2Idx] = 1 + solve(nums1, nums2, nums1Idx + 1, nums2Idx + 1);
		} else {
			int upar = solve(nums1, nums2, nums1Idx + 1, nums2Idx);
			int neeche = solve(nums1, nums2, nums1Idx, nums2Idx + 1);

			return matrix[nums1Idx][nums2Idx] = Math.max(upar, neeche);
		}
	}

}
