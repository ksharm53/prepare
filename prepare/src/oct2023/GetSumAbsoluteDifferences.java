package oct2023;

public class GetSumAbsoluteDifferences {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 5 };
		System.out.println(solve(nums));
	}

	private static int[] solve(int[] nums) {
		int[] res = new int[nums.length];
		int totalCount = 0;
		for (int i : nums) {
			totalCount += i;
		}

		int leftCount = 0;
		int rightCount = totalCount;

		for (int i = 0; i < nums.length; i++) {
			res[i] = getLeft(i, nums, leftCount) + getRight(i, nums, rightCount);
			leftCount += nums[i];
			rightCount -= nums[i];
		}

		return res;
	}

	private static int getRight(int idx, int[] nums, int rightCount) {
		int pending = rightCount - nums[idx];
		int countElements = nums.length - idx - 1;
		return pending - (nums[idx] * countElements);
	}

	private static int getLeft(int idx, int[] nums, int leftCount) {
		int countElements = idx;
		return (nums[idx] * countElements) - leftCount;
	}

}
