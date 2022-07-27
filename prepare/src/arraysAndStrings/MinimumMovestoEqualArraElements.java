package arraysAndStrings;

public class MinimumMovestoEqualArraElements {

	public static void main(String[] args) {
		int[] nums = {5,8,2,4};

		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int count = 0;
		int min = Integer.MAX_VALUE;
		for (int i : nums) {
			min = Math.min(i, min);
		}

		for (int i : nums) {
			count = count + Math.abs(i - min);
		}
		return count;
	}

}
