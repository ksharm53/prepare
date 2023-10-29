package may1;

import java.util.Arrays;

public class DoesValidArrayExist {

	public static void main(String[] args) {
		int[] derived = { 0, 0, 1 };
		int[] original = new int[derived.length];

		if (derived.length == 1) {
			System.out.println(derived[0] == 0);
		}
		Arrays.fill(original, -1);

		System.out.println(solve(derived, 0, original));

	}

	private static boolean solve(int[] derived, int idx, int[] original) {
		if (idx == derived.length - 1) {
			if (derived[idx] == 1) {
				if ((original[idx] == 1 && original[0] == 0) || (original[idx] == 0 && original[0] == 1)) {
					return true;
				} else {
					return false;
				}
			} else {
				if ((original[idx] == 1 && original[0] == 1) || (original[idx] == 0 && original[0] == 0)) {
					return true;
				} else {
					return false;
				}
			}
		}

		if (derived[idx] == 1) {
			if (original[idx] == -1) {
				original[idx] = 0;
				original[idx + 1] = 1;
				boolean oneWay = solve(derived, idx + 1, original);

				original[idx] = 1;
				original[idx + 1] = 0;
				boolean secondWay = solve(derived, idx + 1, original);

				return oneWay || secondWay;
			} else {
				if (original[idx] == 0) {
					original[idx + 1] = 1;
				} else {
					original[idx + 1] = 0;
				}
				return solve(derived, idx + 1, original);
			}

		} else {
			if (original[idx] == -1) {
				original[idx] = 0;
				original[idx + 1] = 0;
				boolean oneWay = solve(derived, idx + 1, original);

				original[idx] = 1;
				original[idx + 1] = 1;
				boolean secondWay = solve(derived, idx + 1, original);

				return oneWay || secondWay;
			} else {
				if (original[idx] == 0) {
					original[idx + 1] = 0;
				} else {
					original[idx + 1] = 1;
				}
				return solve(derived, idx + 1, original);
			}
		}

	}

}
