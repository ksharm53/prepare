package oct2023;

import java.util.HashMap;
import java.util.Map;

public class CountNicePairs {

	public static void main(String[] args) {
		int[] nums = { 42, 11, 1, 97 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int mod = 1000000007;
		int[] updatedNum = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			updatedNum[i] = nums[i] - reverse(nums[i]);
		}
		Map<Integer, Long> map = new HashMap<>();
		long response = 0;
		for (int i = 0; i < updatedNum.length; i++) {
			if (map.containsKey(updatedNum[i])) {
				response += map.get(updatedNum[i]);
			}
			map.put(updatedNum[i], map.getOrDefault(updatedNum[i], 0L) + 1);
		}

		return (int) (response % mod);
	}

	private static int reverse(int eachVal) {
		int ret = 0;
		while (eachVal > 0) {
			int digit = eachVal % 10;
			ret = (ret * 10) + digit;
			eachVal = eachVal / 10;
		}

		return ret;
	}

}
