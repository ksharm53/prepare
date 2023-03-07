package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class AsteroidsDestroyed {

	public static void main(String[] args) {
		int mass = 5;
		int[] asteroids = { 4, 9, 23, 4 };
		System.out.println(solve(mass, asteroids));

	}

	private static boolean solve(int mass, int[] asteroids) {
		if (asteroids.length == 0) {
			return true;
		}
		if (mass < 0) {
			return false;
		}

		TreeSet<Integer> set = new TreeSet<>();
		Map<Integer, Integer> map = new HashMap<>();

		for (Integer eachInteger : asteroids) {
			set.add(eachInteger);
			map.put(eachInteger, map.getOrDefault(eachInteger, 0) + 1);
		}

		while (mass > 0 && set.size() > 0) {
			if (set.floor(mass) == null) {
				return false;
			}
			int value = set.floor(mass);
			mass += value;
			map.put(value, map.get(value) - 1);
			if (map.get(value) <= 0) {
				set.remove(value);
			}
		}
		return true;

	}

}
