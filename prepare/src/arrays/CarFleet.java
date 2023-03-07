package arrays;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class CarFleet {

	public static void main(String[] args) {
		int[] position = { 10, 8, 0, 5, 3 };
		int[] speed = { 2, 4, 1, 1, 3 };

		System.out.println(solve(position, speed, 12));
	}

	private static int solve(int[] position, int[] speed, int target) {
		Map<Integer, Integer> map = new TreeMap<>();
		double[] result = new double[position.length];

		int size = position.length;

		if (size == 1) {
			return 1;
		}

		for (int i = 0; i < size; i++) {
			map.put(position[i], speed[i]);
		}
		int counter = 0;

		for (Entry<Integer, Integer> i : map.entrySet()) {
			result[counter] = (double) (target - i.getKey()) / (double) i.getValue();
			counter++;
		}
		int fleets = 1;
		double max = result[result.length - 1];

		for (int i = result.length - 2; i >= 0; i--) {

			if (i >= 0 && result[i] <= max) {
				continue;
			}
			max = result[i];
			fleets++;

		}
		return fleets;

	}

}
