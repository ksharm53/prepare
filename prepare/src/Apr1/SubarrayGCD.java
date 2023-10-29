package Apr1;

public class SubarrayGCD {

	public static void main(String[] args) {
		int[] nums = { 3, 12, 9, 6 };
		int k = 3;
		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {
		int count = 0;
		if (nums.length == 1) {
			return nums[0] == k ? 1 : 0;
		}

		for (int i = 0; i < nums.length; i++) {
			int lastGcd = nums[i];
			if (nums[i] == k) {
				count++;
			}
			for (int j = i + 1; j < nums.length; j++) {
				lastGcd = findGcd(lastGcd, nums[j]);
				if (lastGcd == k) {
					count++;
				} else {
					break;
				}

			}
		}

		return count;
	}

	static int findGcd(int a, int b) {
		if (b == 0)
			return a;

		else
			return findGcd(b, a % b);
	}

}
