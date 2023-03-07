package Oct21;

public class CountNumberofNiceSubarrays {

	public static void main(String[] args) {
		int[] nums = { 91473, 45388, 24720, 35841, 29648, 77363, 86290, 58032, 53752, 87188, 34428, 85343, 19801,
				73201 };
		int k = 4;

		System.out.println(solve(nums, k));

	}

	public static int solve(int[] nums, int k) {
		int j = 0, odd = 0, count = 0, total = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				odd++;
				if (odd >= k) {
					count = 1;
					while (!(nums[j] % 2 == 1)) {
						count++;
						j++;
					}

					total += count;
				}
			} else if (odd >= k) {
				total += count;
			}

		}
		return total;
	}

}
