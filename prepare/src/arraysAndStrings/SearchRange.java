package arraysAndStrings;

public class SearchRange {

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 6;

		System.out.println(solve(nums, target));
	}

	private static int[] solve(int[] nums, int target) {
		int findFirst = binarySearch(nums, target);
		int findSecond = binarySecondSearch(nums, target);

		return new int[] { findFirst, findSecond };
	}

	private static int binarySecondSearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result = mid;
				start = mid + 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			}
		}
		return result;

	}

	private static int binarySearch(int[] nums, int target) {
		int start = 0;
		int end = nums.length - 1;
		int result = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				result = mid;
				end = mid - 1;
			} else if (nums[mid] < target) {
				start = mid + 1;
			} else if (nums[mid] > target) {
				end = mid - 1;
			}
		}
		return result;
	}

}
