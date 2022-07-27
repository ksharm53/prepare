package arraysAndStrings;

public class MinimumRotatedSortedArray {

	public static void main(String[] args) {
		int[] nums = { 2, 1 };

		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int size = nums.length;

		while (start <= end) {
			if (nums[start] <= nums[end]) {
				return nums[start];
			}
			int mid = start + (end - start) / 2;

			int previous = (mid - 1 + size) % size;
			int next = (mid + 1) % size;

			if (nums[mid] <= nums[previous] && nums[mid] <= nums[next]) {
				return nums[mid];
			} else if (nums[start] <= nums[mid]) {
				start = mid + 1;
			} else if (nums[mid] <= nums[end]) {
				end = mid - 1;
			}
		}
		return -1;
	}

}
