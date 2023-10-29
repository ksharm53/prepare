package aug;

public class Search {

	public static void main(String[] args) {
		int[] nums = { 2, 5, 6, 6, 0, 0, 1, 2 };
		int target = 0;
		System.out.println(solve(nums, target));

	}

	private static int solve(int[] nums, int target) {
		int peak = findPeak(nums);
		if (peak != -1 && nums[peak] == target) {
			return peak;
		}
		int findFirst = binarySearch(0, peak - 1, nums, target);
		int findSecond = binarySearch(peak + 1, nums.length - 1, nums, target);

		if (findFirst != -1) {
			return findFirst;
		}

		if (findSecond != -1) {
			return findSecond;
		}
		return -1;
	}

	private static int binarySearch(int start, int end, int[] nums, int target) {
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}

	private static int findPeak(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int last = (mid - 1 + nums.length) % nums.length;
			int next = (mid + 1) % nums.length;

			if (nums[mid] >= nums[last] && nums[mid] >= nums[next]) {
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
