package arraysAndStrings;

public class KokoEatingBananas {

	public static void main(String[] args) {
		int[] piles = { 1000000000 };
		int h = 2;

		System.out.println(solve(piles, h));
	}

	private static int solve(int[] piles, int h) {

		int result = -1;
		int start = 1;
		int end = Integer.MIN_VALUE;

		for (int i : piles) {
			end = Math.max(end, i);
		}

		while (start <= end) {
			int mid = start + (end - start) / 2;

			if (validate(mid, piles, h)) {
				result = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	private static boolean validate(int mid, int[] piles, int h) {

		int tempMid = mid;
		for (int i = 0; i < piles.length; i++) {
			int value = piles[i] / tempMid;
			if (piles[i] % tempMid == 0) {
				h = h - (value);
			} else {
				h = h - (value + 1);
			}

		}
		if (h < 0) {
			return false;
		}
		return true;

	}

}
