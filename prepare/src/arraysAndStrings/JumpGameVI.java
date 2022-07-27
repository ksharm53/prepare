package arraysAndStrings;

public class JumpGameVI {

	public static void main(String[] args) {

		int[] nums = { -5582, -5317, 6711, -639, 1001, 1845, 1728, -4575, -6066, -7770, 128, -3254, 7281, 3966, 6857,
				5477, 8968, -1771, 9986, -6267, 9010, -764, 8413, -8154, 1087, -1107, 4183, 3033, 58, 659, 4625, 2825,
				5031, 6811, 5657, 3229, 8597, -5772, 8869, 5723, 2960, 4040, 7222, 4841, -1014, 581, -2830, 3881, -3800,
				577, -7396, -611, -6944, 8461, 3294, 6297, 9713, -2246, -3441, 3831, -5754, 6716, 6040, -6715, 5763,
				8611, 5412, -7630, 6216, 260, 2595, 6852, -8956 };
		int k = 56;

		System.out.println(solve(nums, k, nums.length));

		System.out.println(maxResult(nums, k));

	}

	static public int maxResult(int[] nums, int k) {
		int[] mem = new int[nums.length]; // Lookup table to score max score for given node

		for (int i = 0; i < mem.length; i++)
			mem[i] = Integer.MIN_VALUE;

		return maxResult(mem, nums, 0, k);
	}

	static private int maxResult(int[] mem, int[] nums, int i, int k) {
		if (i >= nums.length - 1)
			return nums[nums.length - 1];

		if (mem[i] != Integer.MIN_VALUE)
			return mem[i];

		int max = Integer.MIN_VALUE;

		for (int j = i + 1; j <= Math.min(i + k, nums.length); j++)
			max = Math.max(max, maxResult(mem, nums, j, k));

		mem[i] = nums[i] + max;

		return mem[i];
	}

	private static int solve(int[] nums, int k, int length) {

		if (length == 0) {
			return 0;
		}
		int sum = nums[0];

		for (int i = 1; i < nums.length; i++) {
			int localMax = Integer.MIN_VALUE;
			int index = -1;
			int tempK = k;
			while (tempK > 0 && i < nums.length) {
				if (nums[i] > localMax) {
					localMax = nums[i];
					index = i;
				}
				tempK--;
				i++;
			}
			i = index;
			sum = sum + localMax;
		}
		return sum;
	}

}
