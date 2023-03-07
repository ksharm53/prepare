package oct3;

import java.util.HashMap;
import java.util.Map;

public class MinimumDominoRotationsForEqualRow {

	public static void main(String[] args) {
		int[] tops = { 2, 1, 2, 4, 2, 2 };
		int[] bottoms = { 5, 2, 6, 2, 3, 2 };

		System.out.println(solve(tops, bottoms));

	}

	private static int solve(int[] tops, int[] bottoms) {
		Map<Integer, Integer> mapT = new HashMap<>();
		Map<Integer, Integer> mapB = new HashMap<>();
		Map<Integer, Integer> sameMap = new HashMap<>();

		for (int i = 0; i < tops.length; i++) {

			mapT.put(tops[i], mapT.getOrDefault(tops[i], 0) + 1);
			if (tops[i] == bottoms[i]) {
				sameMap.put(tops[i], sameMap.getOrDefault(tops[i], 0) + 1);
			}
		}

		for (int i : bottoms) {
			mapB.put(i, mapB.getOrDefault(i, 0) + 1);
		}

		for (int i = 1; i <= 6; i++) {
			if ((mapT.getOrDefault(i, 0) + mapB.getOrDefault(i, 0) - sameMap.getOrDefault(i, 0)) == tops.length) {
				return tops.length - Math.max(mapT.get(i), mapB.get(i));
			}
		}
		return -1;

	}

}
