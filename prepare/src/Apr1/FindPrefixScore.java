package Apr1;

public class FindPrefixScore {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 4, 8, 16 };
		System.out.println(solve(nums));
	}

		private static long[] solve(int[] nums) {
			int max = Integer.MIN_VALUE;
			long sumSoFar = 0;
			long[] res = new long[nums.length];
			for (int i = 0; i < nums.length; i++) {
				max = Math.max(max, nums[i]);
				sumSoFar += nums[i] + max;
				res[i] = sumSoFar;
			}
			return res;
		}

}
