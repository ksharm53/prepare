package august23;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ReorderedPowerof2 {

	public static void main(String[] args) {
		int n = 16;

		System.out.println(solve(n));

	}

	private static boolean solve(int n) {
		if (n == 0) {
			return false;
		}
		String inputString = Integer.toString(n);
		Map<Integer, Integer> mapInput = findFrequency(n);

		for (int i = 0; i < 31; i++) {
			int eachValue = (int) Math.pow(2, i);
			String eachString = Integer.toString(eachValue);

			if (eachString.length() > inputString.length()) {
				return false;
			}
			Map<Integer, Integer> mapEach = findFrequency(eachValue);

			if (foundMatch(mapEach, mapInput)) {
				return true;
			} else {
				continue;
			}

		}
		return false;
	}

	private static boolean foundMatch(Map<Integer, Integer> mapEach, Map<Integer, Integer> mapInput) {

		for (Entry<Integer, Integer> eachInputEntry : mapInput.entrySet()) {
			int key = eachInputEntry.getKey();

			if (mapEach.get(key) == null || mapEach.get(key) != mapInput.get(key)) {
				return false;
			}
		}
		return true;
	}

	private static Map<Integer, Integer> findFrequency(int n) {
		Map<Integer, Integer> mapInput = new HashMap<>();

		while (n > 0) {
			int remiander = n % 10;
			mapInput.put(remiander, mapInput.getOrDefault(remiander, 0) + 1);
			n = n / 10;
		}
		return mapInput;

	}

}
