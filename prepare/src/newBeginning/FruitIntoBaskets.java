package newBeginning;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

	public static void main(String[] args) {
		int[] fruits = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
		System.out.println(solve(fruits));
	}

	private static int solve(int[] fruits) {
		int i = 0;
		int j = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;

		while (j < fruits.length) {
			map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);

			if (map.size() < 2) {
				j++;
			}

			else if (map.size() == 2) {
				max = Math.max(max, j - i + 1);
				j++;

			} else if (map.size() > 2) {
				while (map.size() > 2) {
					map.put(fruits[i], map.getOrDefault(fruits[i], 0) - 1);
					if (map.get(fruits[i]) == 0) {
						map.remove(fruits[i]);
					}
					i++;
				}
				j++;
			}
		}
		return max;
	}

}
