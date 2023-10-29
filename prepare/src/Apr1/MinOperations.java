package Apr1;

public class MinOperations {

	public static void main(String[] args) {
		int[] nums = { 2, 1, 6, 1 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int gcd = 0;
		int countOne = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 1) {
				countOne++;
			}
			gcd = findGcd(nums[i], nums[i + 1]);
		}

		if (nums[nums.length - 1] == 1) {
			countOne++;
		}

		if (gcd > 1) {
			return -1;
		}

		return nums.length - countOne;

	}

	static int findGcd(int a, int b) {
		if (b == 0)
			return a;

		else
			return findGcd(b, a % b);
	}

}
