package Oct21;

public class RemoveDuplicatesfromSortedArrayII {

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int i = 0;
		for (int each : nums) {
			if (i < 2 || each > nums[i - 2]) {
				nums[i] = each;
				i++;
			}
		}
		return i;
	}

}
