package june;

public class SemiOrderedPermutation {

	public static void main(String[] args) {
		int[] nums = { 2, 4, 5, 3, 1, 6, 10, 9, 8, 7 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		int firstPos = -1;
		int lastPos = -1;

		int hops = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1) {
				firstPos = i;
			}

			if (nums[i] == nums.length) {
				lastPos = i;
			}
		}

		hops += firstPos - 0;
		hops += nums.length - 1 - lastPos;

		if (lastPos < firstPos) {
			hops--;
		}

		return hops;
	}

}
