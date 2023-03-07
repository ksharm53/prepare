package Oct21;

public class NumberofSubarraysWithLCMEqualtoK {

	public static void main(String[] args) {
		int[] nums = { 3 };
		int k = 2;

		System.out.println(solve(nums, k));

	}

	private static int solve(int[] nums, int k) {

		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			int prev = 1;
			for (int j = i; j < nums.length; j++) {
				int val = lcm(nums[j], prev);
				if (val == k) {
					counter++;
				}
				prev = val;
			}

		}

		return counter;
	}

	public static int lcm(int number1, int number2) {
		if (number1 == 0 || number2 == 0) {
			return 0;
		}
		int absNumber1 = Math.abs(number1);
		int absNumber2 = Math.abs(number2);
		int absHigherNumber = Math.max(absNumber1, absNumber2);
		int absLowerNumber = Math.min(absNumber1, absNumber2);
		int lcm = absHigherNumber;
		while (lcm % absLowerNumber != 0) {
			lcm += absHigherNumber;
		}
		return lcm;
	}

}
