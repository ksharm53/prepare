package feb07;

public class SquareFreeSubsets {

	public static void main(String[] args) {
		int[] nums = { 11, 2, 19, 7, 9, 27 };
		System.out.println(solve(nums));

	}

	private static int solve(int[] nums) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			long start = nums[i];
			for (int j = i; j < nums.length; j++) {
				if (i == j) {
					if (!calculate(nums[i])) {
						count++;
					}
				} else {
					start *= nums[j];
					if (!calculate(start)) {
						count++;
					}
					if (!calculate(nums[i] * nums[j])) {
						count++;
					}
				}
			}
		}
		return count;
	}

	private static boolean calculate(long start) {
		double valD = Math.sqrt(start);
		int valI = (int) Math.sqrt(start);
		if (valD > valI) {
			valI++;
		}

		for (int i = 2; i <= valI; i++) {
			if (start < i * i) {
				return true;
			}
			if (start % (i * i) == 0) {
				return true;
			}
		}
		return false;
	}

}
