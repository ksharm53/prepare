package aug;

public class SeracgRotate {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1 };
		int target = 2;
		System.out.println(solve(nums, target));

	}

	private static boolean solve(int[] nums, int target) {
		int peak = findPeak(nums);
		int next;
		if (peak != -1) {
			next = (peak + 1) % nums.length;
			while (next != peak && nums[next] == nums[peak]) {
				next = (next + 1) % nums.length;
			}

			if (next != -1 && nums[next] == target) {
				return true;
			}
		} else {
			next = nums.length;
		}

		boolean findFirst = binarySearch(0, next - 1, nums, target);
		boolean findSecond = binarySearch(next + 1, nums.length - 1, nums, target);

		return findFirst || findSecond;
	}

	private static boolean binarySearch(int start, int end, int[] nums, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return true;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}

	private static int findPeak(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int last = (mid - 1 + nums.length) % nums.length;
			int next = (mid + 1) % nums.length;

			if ((nums[mid] > nums[last] && nums[mid] > nums[next])
					|| (nums[mid] > nums[last] && nums[mid] == nums[next])
					|| (nums[mid] == nums[last] && nums[mid] > nums[next])) {
				return mid;
			} else if (nums[start] <= nums[mid]) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
