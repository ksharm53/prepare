package Apr1;

public class MinimizeArrayValue {

	public static void main(String[] args) {
		int[] nums = { 4, 7, 2, 2, 9, 19, 16, 0, 3, 15 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int min = Integer.MIN_VALUE;
		long sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			min = (int) Math.max(min, Math.ceil((double) sum / (double) (i + 1)));

		}
		return min;
	}

}
