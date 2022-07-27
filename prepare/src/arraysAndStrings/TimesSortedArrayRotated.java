package arraysAndStrings;

public class TimesSortedArrayRotated {

	public static void main(String[] args) {
		int[] nums = { 11, 12, 13, 14, 15, 17, 2, 5, 6, 8 };

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int start = 0;
		int end = nums.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			int next = (mid + 1) % nums.length;
			int prev = (mid - 1 + nums.length) % nums.length;
			if (nums[mid] <= nums[prev] && nums[mid] <= nums[next]) {
				return mid;
			}
			if (nums[0] <= nums[mid]) {
				start = mid + 1;
			} else if (nums[mid] <= nums[nums.length - 1]) {
				end = mid - 1;
			}
		}
		return -1;
	}

}
