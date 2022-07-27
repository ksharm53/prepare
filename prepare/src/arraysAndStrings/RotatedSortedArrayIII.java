package arraysAndStrings;

public class RotatedSortedArrayIII {

	public static void main(String[] args) {
		int[] nums = {2,2,2,0,1};

		int index = solve(nums);
		System.out.println(index);
	}

	private static int solve(int[] nums) {

		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + (hi - lo) / 2;
			if (nums[mid] > nums[hi])
				lo = mid + 1;
			else if (nums[mid] < nums[hi])
				hi = mid;
			else
				hi--;
		}
		return nums[lo];

	}

}
