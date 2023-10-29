package may1;

import java.util.Arrays;

public class GetAverages {

	public static void main(String[] args) {
		int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
		int k = 3;

		System.out.println(solve(nums, k));

	}

	private static int[] solve(int[] nums, int k) {
		int[] res = new int[nums.length];
		int i = 0;
		int j = 0;
		long count = 0;

		Arrays.fill(res, -1);

		while (j < nums.length) {
			count += nums[j];
			if (j - i + 1 == (2 * k + 1)) {
				res[j - k] = (int) (count / (2 * k + 1));
				count -= nums[i];
				i++;
			}
			j++;
		}
		return res;
	}

}
