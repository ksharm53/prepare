package may1;

public class FindMaxAverage {

	public static void main(String[] args) {
		int[] nums = { -1 };
		System.out.println(solve(nums, 1));

	}

	private static double solve(int[] nums, int k) {

		int i = 0;
		int j = 0;
		int count = 0;
		int sum = 0;

		double max = -Double.MAX_VALUE;

		while (j < nums.length) {
			sum += nums[j];
			count++;
			if (j - i + 1 == k) {
				max = Math.max(max, ((double) sum / (double) count));
				sum -= nums[i];
				count--;
				i++;
			}
			j++;
		}

		return max;
	}

}
