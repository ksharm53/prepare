package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClimbingLeaderboard {

	public static void main(String[] args) {
		List<Integer> ranked = Arrays.asList(100, 90, 90, 80);
		List<Integer> player = Arrays.asList(70, 80, 105);

		System.out.println(solve(ranked, player));

	}

	private static List<Integer> solve(List<Integer> ranked, List<Integer> player) {
		List<Integer> result = new ArrayList<>();
		Collections.sort(ranked);

		Map<Integer, Integer> map = new HashMap<>();
		for (Integer each : ranked) {
			if (!map.containsKey(each)) {
				map.put(each, map.size() + 1);
			} else {
				map.put(each, map.size());
			}
		}

		for (int i = 0; i < player.size(); i++) {
			int start = 0;
			int end = map.size() - 1;
			while (start <= end) {
				int mid = start + (end - start) / 2;
				if (ranked.get(mid) == player.get(i)) {

				}
			}
		}

		return null;
	}

}
