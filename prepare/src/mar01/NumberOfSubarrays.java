package mar01;

public class NumberOfSubarrays {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 1, 1 };
		int k = 3;
		System.out.println(solve(nums, k) - solve(nums, k - 1));

	}

	private static int solve(int[] nums, int k) {
		int i = 0;
		int j = 0;
		int count = 0;
		int total = 0;

		while (j < nums.length) {
			if (nums[j] % 2 != 0) {
				count++;
			}

			if (count > k) {
				while (count > k) {
					if (nums[i] % 2 != 0) {
						count--;
					}
					i++;
				}
			}

			total += j - i + 1;
			j++;
		}
		return total;
	}

}
