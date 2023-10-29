package mar01;

public class FindValidSplit {

	public static void main(String[] args) {
		int[] nums = { 557663, 280817, 472963, 156253, 273349, 884803, 756869, 763183, 557663, 964357, 821411, 887849,
				891133, 453379, 464279, 574373, 852749, 15031, 156253, 360169, 526159, 410203, 6101, 954851, 860599,
				802573, 971693, 279173, 134243, 187367, 896953, 665011, 277747, 439441, 225683, 555143, 496303, 290317,
				652033, 713311, 230107, 770047, 308323, 319607, 772907, 627217, 119311, 922463, 119311, 641131, 922463,
				404773, 728417, 948281, 612373, 857707, 990589, 12739, 9127, 857963, 53113, 956003, 363397, 768613,
				47981, 466027, 981569, 41597, 87149, 55021, 600883, 111953, 119083, 471871, 125641, 922463, 562577,
				269069, 806999, 981073, 857707, 831587, 149351, 996461, 432457, 10903, 921091, 119083, 72671, 843289,
				567323, 317003, 802129, 612373 };
		System.out.println(solve(nums));
	}

	private static int solve(int[] nums) {
		long[] prefix = new long[nums.length];
		long[] sufix = new long[nums.length];

		long last = 1;
		for (int i = 0; i < nums.length; i++) {
			last *= nums[i];
			prefix[i] = last;
		}

		for (int i = 0; i < nums.length; i++) {
			last /= nums[i];
			sufix[i] = last;
		}

		for (int i = 0; i < nums.length - 1; i++) {
			if (gcd(prefix[i], sufix[i]) == 1) {
				return i;
			}
		}

		return -1;
	}

	private static long gcd(long pref, long suff) {
		if (pref == suff) {
			return pref;
		}

		long big = -1;
		long small = -1;
		long temp;
		if (pref > suff) {
			big = pref;
			small = suff;
		} else {
			small = pref;
			big = suff;
		}

		while (small != 0) {
			temp = small;
			small = big % small;
			big = temp;
		}

		return big;
	}

}
