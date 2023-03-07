package newBeginning;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 3, 2, 2 };
		int k = 2;
		int p = 2;

		System.out.println(solve(nums, k, p));

	}

	private static int solve(int[] nums, int k, int p) {
		if (nums.length == 0) {
			return 0;
		}
		Set<String> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			int innercounter = 0;
			StringBuilder sb = new StringBuilder();
			for (int j = i; j < nums.length; j++) {
				sb.append(nums[j] + ",");
				if (nums[j] % p == 0) {
					innercounter++;
				}
				if (innercounter <= k) {
					set.add(sb.toString());
				}
			}
		}
		return set.size();
	}

}
