package arraysAndStrings;

public class MaximumLengthRepeatedSubArray {

	static int max;

	public static void main(String[] args) {
		int[] nums1 = { 0, 1, 1, 1, 1 };
		int[] nums2 = { 1, 0, 1, 0, 1 };

		max = Integer.MIN_VALUE;

		System.out.println(solve(nums1, nums2));
	}

	public static int solve(int[] nums1, int[] nums2) {

		int[][] matrix = new int[nums1.length + 1][nums2.length + 1];

		for (int i = 0; i < matrix.length; i++) {
			matrix[i][0] = 0;
		}

		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] = 0;
		}

		for (int i = 1; i <= nums1.length; i++) {
			for (int j = 1; j <= nums2.length; j++) {
				if (nums1[i - 1] == nums2[j - 1]) {
					matrix[i][j] = matrix[i - 1][j - 1] + 1;
				} else {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, matrix[i][j]);
			}
		}
		return max;

	}

}
