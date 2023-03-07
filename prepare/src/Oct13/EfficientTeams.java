package Oct13;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EfficientTeams {

	public static void main(String[] args) {
		int[] skills = { 1, 2, 3, 2 };
		System.out.println(solve(skills));
	}

	private static long solve(int[] skills) {
		int sum = 0;
		Arrays.sort(skills);
		for (int i = 0; i < skills.length; i++) {
			sum += skills[i];
		}

		if (sum % (skills.length / 2) != 0) {
			return -1;
		}
		long ret = 0;

		int eackBlockSum = sum / (skills.length / 2);
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < skills.length; i++) {
			if (skills[i] > eackBlockSum) {
				return -1;
			}
			if (map.containsKey(skills[i])) {
				ret += skills[i] * (eackBlockSum - skills[i]);
				map.put(skills[i], map.getOrDefault(skills[i], 0) - 1);
				if (map.get(skills[i]) == 0) {
					map.remove(skills[i]);
				}
			} else {
				map.put(eackBlockSum - skills[i], map.getOrDefault(eackBlockSum - skills[i], 0) + 1);
			}
		}
		return map.isEmpty() ? ret : -1;
	}

}
