package june;

import java.util.HashMap;
import java.util.Map;

public class MaxDistance {

	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		int[] position = { 79, 74, 57, 22 };
		int m = 4;
		map = new HashMap<>();

		System.out.println(solve(position, m));

	}

	private static int solve(int[] position, int m) {
		createMap(m - 2);

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for (int each : position) {
			min = Math.min(min, each);
			max = Math.max(max, each);
		}

		if (m - 2 == 0) {
			return max - min;
		}

		int val = map.get(m - 2);

		double value = (double) (max - min) / (double) (val + 1);

		int intVal = (max - min) / (val + 1);

		return value > intVal ? intVal + 1 : intVal;

	}

	private static void createMap(int vaipl) {
		int val = 1;
		int count = 1;
		for (int i = 1; i <= vaipl; i++) {
			int temp = count;
			while (temp > 0) {
				map.put(i, val);
				temp--;
			}
			val += 2 * count;
			count *= 2;
		}

	}

}
