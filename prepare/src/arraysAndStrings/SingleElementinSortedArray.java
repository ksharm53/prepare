package arraysAndStrings;

public class SingleElementinSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,1,2};

		//System.out.println(solve(nums, 0, nums.length - 1));

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums.length == 1) {
				return nums[0];
			}
			if (i + 1 >= nums.length || nums[i] != nums[i + 1]) {
				return nums[i];
			}
			else {
				i=i+1;
			}
		}
		return 0;
	}

	private static int solve(int[] nums, int start, int end) {

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid == start && (mid + 1) < nums.length && nums[mid + 1] != nums[mid]) {
				return nums[mid];
			} else if (mid == end && (mid - 1) > 0 && nums[mid - 1] != nums[mid]) {
				return nums[mid];
			}

			else if ((mid - 1) > 0 && (mid + 1) < nums.length && nums[mid] != nums[mid - 1]
					&& nums[mid] != nums[mid + 1]) {
				return nums[mid];
			}

			else {
				int left = solve(nums, start, mid - 1);
				int right = solve(nums, mid + 1, end);

				return Math.max(left, right);
			}
		}
		return -1;
	}

}
