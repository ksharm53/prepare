package Oct13;

public class CountSubarraysWithFixedBounds {

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 1 };
		int minK = 1;
		int maxK = 1;
		System.out.println(solve(nums, minK, maxK));

	}

	private static int solve(int[] nums, int minK, int maxK) {
		int counter = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != minK) {
				continue;
			}
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == maxK) {
					counter++;
				}
			}
		}
		return counter;
	}

}
