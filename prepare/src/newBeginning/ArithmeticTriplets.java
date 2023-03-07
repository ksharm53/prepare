package newBeginning;

public class ArithmeticTriplets {

	public static void main(String[] args) {
		int[] nums = { 4, 5, 6, 7, 8, 9 };
		int diff = 2;
		System.out.println(solve(nums, diff));
	}

	private static int solve(int[] nums, int diff) {
		int counter = 0;

		for (int i = 0; i < nums.length; i++) {
			int val = firstBinary(nums[i] + diff, nums, i);
			if (val != -1) {
				if (firstBinary(nums[i] + diff + diff, nums, val) != -1) {
					counter++;
				}
			} else {
				continue;
			}
		}
		return counter;
	}

	private static int firstBinary(int found, int[] nums, int start) {
		int end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == found) {
				return mid;
			} else if (nums[mid] < found) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}
