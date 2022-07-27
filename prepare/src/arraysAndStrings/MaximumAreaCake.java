package arraysAndStrings;

import java.util.Arrays;

public class MaximumAreaCake {

	public static void main(String[] args) {
		int h = 5;
		int w = 4;
		int[] horizontalCuts = { 3, 1 };
		int[] verticalCuts = { 1 };

		System.out.println(solve(h, w, horizontalCuts, verticalCuts));

	}

	private static int solve(int h, int w, int[] horizontalCuts, int[] verticalCuts) {

		long pow = (long) (Math.pow(10, 9) + 7);

		if (h == 0 || w == 0) {
			return 0;
		}

		Arrays.sort(horizontalCuts);
		Arrays.sort(verticalCuts);

		long maxHorizontalCut = Math.max(Math.abs(0 - horizontalCuts[0]),
				Math.abs(h - horizontalCuts[horizontalCuts.length - 1]));
		long maxVersticalCut = Math.max(Math.abs(0 - verticalCuts[0]),
				Math.abs(w - verticalCuts[verticalCuts.length - 1]));

		for (int i = 0; i < horizontalCuts.length; i++) {
			if (i + 1 < horizontalCuts.length) {
				maxHorizontalCut = Math.max(maxHorizontalCut, Math.abs(horizontalCuts[i] - horizontalCuts[i + 1]));
			}
		}

		for (int i = 0; i < verticalCuts.length; i++) {
			if (i + 1 < verticalCuts.length) {
				maxVersticalCut = Math.max(maxVersticalCut, Math.abs(verticalCuts[i] - verticalCuts[i + 1]));
			}
		}
		long result = maxVersticalCut * maxHorizontalCut;

		return (int) ((result) % pow);

	}

}
