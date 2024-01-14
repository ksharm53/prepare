package oct2023;

import java.util.HashMap;
import java.util.Map;

public class GarbageCollection {

	public static void main(String[] args) {
		String[] garbage = { "MMM", "PGM", "GP" };
		int[] travel = { 3, 10 };
		System.out.println(solve(garbage, travel));

	}

	private static int solve(String[] garbage, int[] travel) {
		int count = 0;
		int gPos = 0;
		int pPos = 0;
		int mPos = 0;

		int[] runSumTravel = new int[travel.length + 1];
		runSumTravel[0] = 0;
		for (int i = 0; i < travel.length; i++) {
			if (i == 0) {
				runSumTravel[i + 1] = travel[i];
			} else {
				runSumTravel[i + 1] = runSumTravel[i] + travel[i];
			}
		}

		for (int i = 0; i < garbage.length; i++) {
			String each = garbage[i];
			Map<Character, Integer> map = new HashMap<>();
			for (int j = 0; j < each.length(); j++) {
				map.put(each.charAt(j), map.getOrDefault(each.charAt(j), 0) + 1);
			}

			if (map.containsKey('G')) {
				int posDiff = runSumTravel[i] - runSumTravel[gPos];
				count += posDiff;

				count += map.get('G');
				gPos = i;
			}

			if (map.containsKey('P')) {
				int posDiff = runSumTravel[i] - runSumTravel[pPos];
				count += posDiff;
				count += map.get('P');
				pPos = i;
			}

			if (map.containsKey('M')) {
				int posDiff = runSumTravel[i] - runSumTravel[mPos];
				count += posDiff;
				count += map.get('M');
				mPos = i;
			}
		}

		return count;
	}

}
