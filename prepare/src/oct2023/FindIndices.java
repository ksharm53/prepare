package oct2023;

public class FindIndices {

	public static void main(String[] args) {
		int[] nums = { 5, 1, 4, 1 };
		int indexDifference = 2;
		int valueDifference = 4;

		System.out.println(solve(nums, indexDifference, valueDifference));

	}

	private static int[] solve(int[] nums, int indexDifference, int valueDifference) {

		for (int i = 0; i < nums.length - indexDifference; i++) {
			for (int j = i + indexDifference; j < nums.length; j++) {
				if (Math.abs(nums[i] - nums[j]) >= valueDifference) {
					return new int[] { i, j };
				}
			}

		}
		return new int[] { -1, -1 };
	}

}
