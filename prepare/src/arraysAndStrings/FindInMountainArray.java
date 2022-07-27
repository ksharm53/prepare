package arraysAndStrings;

import java.util.Arrays;

public class FindInMountainArray {

	public static void main(String[] args) {
		int[] nums = {1,5,2};
		int target = 2;

		int peak = solve(nums);

		int left = searchAsc(Arrays.copyOfRange(nums, 0, peak), target);
		int right = searchDec(Arrays.copyOfRange(nums, peak, nums.length), target);

		if (left == -1 && right == -1) {
			System.out.println(-1);
		} else if (left == -1 && right != -1) {
			System.out.println(peak + right);
		} else if (left != -1 && right == -1) {
			System.out.println(left);
		} else if (left != -1 && right != -1) {
			System.out.println(left);
		}

	}

	private static int searchAsc(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				start = mid + 1;
			} else if (array[mid] > target) {
				end = mid - 1;
			}
		}
		return -1;
	}
	
	private static int searchDec(int[] array, int target) {
		int start = 0;
		int end = array.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (array[mid] == target) {
				return mid;
			} else if (array[mid] > target) {
				start = mid + 1;
			} else if (array[mid] < target) {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int solve(int[] nums) {

		int start = 0;
		int end = nums.length - 1;

		if (nums.length == 0) {
			return -1;
		}

		if (nums.length == 1) {
			return 0;
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (mid > 0 && mid + 1 < nums.length) {
				if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
					return mid;
				} else if (nums[mid - 1] > nums[mid]) {
					end = mid - 1;
				} else if (nums[mid + 1] > nums[mid]) {
					start = mid + 1;
				}
			} else if (mid == 0) {
				if (nums[0] > nums[1]) {
					return 0;
				} else {
					return 1;
				}
			} else if (mid == nums.length - 1) {
				if (nums[nums.length - 1] > nums[nums.length - 2]) {
					return nums.length - 1;
				} else {
					return nums.length - 2;
				}
			}
		}
		return -1;

	}

}
