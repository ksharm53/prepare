package arraysAndStrings;

public class PredictWinner {

	public static void main(String[] args) {

		int[] nums = { 1, 5, 2 };
		int sum = 0;

		for (int i : nums) {
			sum = sum + i;
		}

		int value = solve(nums, 0, nums.length - 1);
		if (value >= sum - value) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}

	}

	private static int solve(int[] cardPoints, int start, int end) {

		if (start > end) {
			return 0;
		}

		int left = cardPoints[start]
				+ Math.min(solve(cardPoints, start + 2, end), solve(cardPoints, start + 1, end - 1));
		int right = cardPoints[end]
				+ Math.min(solve(cardPoints, start + 1, end - 1), solve(cardPoints, start, end - 2));

		return Math.max(left, right);
	}

}
