package arraysAndStrings;

import java.util.Arrays;

public class SearchInReverseSortedArray {

	public static void main(String[] args) {
		int[] nums = {1,3};
		int target = 0;

		System.out.println(solveSearch(nums, target));
	}

	private static int solveSearch(int[] nums, int target) {
		int smallestIndex = solve(nums);

		int left = searchK(Arrays.copyOfRange(nums, 0, smallestIndex), target);
		int right = searchK(Arrays.copyOfRange(nums, smallestIndex, nums.length), target);

		if(left == -1 && right ==-1) {
			return -1;
		}
		else if(left == -1 && right !=-1) {
			return smallestIndex + right;
		}
		else{
			return left;
		}
	}

	private static int searchK(int[] arraycopy, int target) {
		int start = 0;
		int end = arraycopy.length-1;

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (arraycopy[mid] == target) {
				return mid;
			} else if (arraycopy[mid] < target) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

	private static int solve(int[] nums) {

		int start = 0;
		int end = nums.length - 1;
		int size = nums.length;

		while (start <= end) {
			if (nums[start]<=nums[end])
            {
                return start;
            }
			int mid = start + (end - start) / 2;

			int previous = (mid - 1 + size) % size;
			int next = (mid + 1) % size;

			if (nums[mid] <= nums[previous] && nums[mid] <= nums[next]) {
				return mid;
			}
			if (nums[start] <= nums[mid]) {
				start = mid+1;
			} else if (nums[mid] <= nums[end]) {
				end = mid - 1;
			}
		}
		return -1;
	}

}
