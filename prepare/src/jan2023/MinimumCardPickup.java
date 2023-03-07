package jan2023;

import java.util.HashMap;
import java.util.Map;

public class MinimumCardPickup {

	public static void main(String[] args) {
		int[] cards = { 3, 4, 2, 3, 4, 7 };
		System.out.println(solve(cards));
	}

	private static int solve(int[] cards) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < cards.length; i++) {
			if (map.containsKey(cards[i])) {
				return i + 1;
			} else {
				map.put(cards[i], map.getOrDefault(cards[i], 0) + 1);
			}
		}
		return -1;
	}

}
