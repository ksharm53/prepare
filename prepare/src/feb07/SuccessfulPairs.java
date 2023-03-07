package feb07;

import java.util.Arrays;

public class SuccessfulPairs {

	public static void main(String[] args) {
		int[] spells = { 15, 39, 38, 35, 33, 25, 31, 12, 40, 27, 29, 16, 22, 24, 7, 36, 29, 34, 24, 9, 11, 35, 21, 3,
				33, 10, 9, 27, 35, 17, 14, 3, 35, 35, 39, 23, 35, 14, 31, 7 };
		int[] potions = { 25, 19, 30, 37, 14, 30, 38, 22, 38, 38, 26, 33, 34, 23, 40, 28, 15, 29, 36, 39, 39, 37, 32,
				38, 8, 17, 39, 20, 4, 39, 39, 7, 30, 35, 29, 23 };
		int success = 317;

		System.out.println(solve(spells, potions, success));

	}

	private static int[] solve(int[] spells, int[] potions, long success) {
		int[] res = new int[spells.length];

		Arrays.sort(potions);

		for (int i = 0; i < spells.length; i++) {
			long intVal = success / spells[i];
			double val = (double) success / (double) spells[i];
			if (val > intVal) {
				intVal++;
			}
			int idx = binarySearch(potions, intVal);
			res[i] = potions.length - idx;
		}
		return res;
	}

	private static int binarySearch(int[] potions, long find) {
		int start = 0;
		int end = potions.length - 1;
		int found = -1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (potions[mid] == find) {
				found = mid;
				end = mid - 1;
			} else if (potions[mid] < find) {
				start = mid + 1;
			} else if (potions[mid] > find) {
				end = mid - 1;
			}
		}
		return found == -1 ? start : found;

	}

}
