package oct2023;

public class MinSum {

	public static void main(String[] args) {
		int[] nums1 = { 20, 0, 18, 11, 0, 0, 0, 0, 0, 0, 17, 28, 0, 11, 10, 0, 0, 15, 29 };
		int[] nums2 = { 16, 9, 25, 16, 1, 9, 20, 28, 8, 0, 1, 0, 1, 27 };
		System.out.println(solve(nums1, nums2));
	}

	private static int solve(int[] nums1, int[] nums2) {
		int sum1 = 0;
		int sum2 = 0;
		int zeroCount2 = 0;
		int zeroCount1 = 0;
		for (int i : nums2) {
			if (i == 0) {
				zeroCount2++;
			}
			sum2 += i;
		}

		for (int i : nums1) {
			if (i == 0) {
				zeroCount1++;
			}
			sum1 += i;
		}

		if (sum1 > sum2) {
			sum1 += zeroCount1;
			if (zeroCount2 == 0) {
				return -1;
			} else if (zeroCount2 > (sum1 - sum2) && zeroCount1 == 0) {
				return -1;

			} else if (zeroCount2 > (sum1 - sum2) && zeroCount1 != 0) {
				return sum2 + zeroCount2;
			} else {
				return sum1;
			}
		} else if (sum2 > sum1) {
			sum2 += zeroCount2;
			if (zeroCount1 == 0) {
				return -1;
			} else if (zeroCount1 > (sum2 - sum1) && zeroCount2 == 0) {
				return -1;
			} else if (zeroCount1 > (sum2 - sum1) && zeroCount2 != 0) {
				return sum1 + zeroCount1;
			} else {
				return sum2;
			}
		} else {
			if (zeroCount1 != zeroCount2) {
				if ((zeroCount1 != 0 && zeroCount2 == 0) || (zeroCount2 == 0 && zeroCount1 != 0)) {
					return -1;
				} else {
					if (zeroCount1 > zeroCount2) {
						return sum1 + zeroCount1;
					} else {
						return sum2 + zeroCount2;
					}
				}
			} else {
				return sum1 + zeroCount1;
			}
		}

	}

}
