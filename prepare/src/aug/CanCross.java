package aug;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanCross {

	static Map<Integer, Integer> map;
	static int[][] matrix;

	public static void main(String[] args) {
		int[] stones = { 0, 1, 2, 3, 4, 8, 9, 11 };
		map = new HashMap<>();
		matrix = new int[stones.length + 1][stones.length + 1];

		for (int[] each : matrix) {
			Arrays.fill(each, -1);
		}

		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], i);
		}

		System.out.println(solve(stones, 0, 0));

	}

	private static boolean solve(int[] stones, int idx, int lastUnits) {

		if (idx == stones.length - 1) {
			return true;
		}

		if (idx >= stones.length || lastUnits < 0) {
			return false;
		}

		if (matrix[idx][lastUnits] != -1) {
			return matrix[idx][lastUnits] == 1 ? true : false;
		}

		boolean plusOne = false;
		boolean plusZero = false;
		boolean minusOne = false;

		if (map.containsKey(stones[idx] + lastUnits - 1)) {
			minusOne = solve(stones, map.get(stones[idx] + lastUnits - 1), lastUnits - 1);
		}

		if (lastUnits != 0 && map.containsKey(stones[idx] + lastUnits)) {
			plusZero = solve(stones, map.get(stones[idx] + lastUnits), lastUnits);
		}

		if (map.containsKey(stones[idx] + lastUnits + 1)) {
			plusOne = solve(stones, map.get(stones[idx] + lastUnits + 1), lastUnits + 1);
		}

		matrix[idx][lastUnits] = (plusOne || plusZero || minusOne) == true ? 1 : 2;
		return (plusOne || plusZero || minusOne);

	}

}
