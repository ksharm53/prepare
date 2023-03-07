package Oct13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullSquareCodeSignal {

	public static void main(String[] args) {
		int[] arr = {-56,31,33,55,94,-95,-20,41,-77,64,-11,-34,-90,-8,15,86,39,60,8,-96,44,91,-81,100,-98,-45,-9,-70,17,85,-91,-62,-53,-63,45,37,-7,47,-15,56,77,-1,
				-24,68,72,3,71,-37,6,-17,-49,29,-5,-44,98,-42,-84,0,-74,-57,-19,18,25,-38,-31,42,35,28,23,-39,83,-79,-30,-2,-41,-43,-25,97,80,11,49,21,90,95,-93,20,-26,-23,7};

		System.out.println(solve(arr));
	}

	private static int solve(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		int[] copy = Arrays.copyOf(arr, arr.length);
		Arrays.sort(copy);
		int max = 0;
		if (arr.length == 1) {
			max = copy[0];
		} else {
			max = copy[copy.length - 1] * 2;
		}

		List<Integer> list = new ArrayList<>();
		int counter = 0;

		for (int i = 0; i * i <= max; i++) {
			list.add(i * i);
		}

		for (Integer eachSquare : list) {
			map = new HashMap<>();
			for (int i = 0; i < arr.length; i++) {
				if (map.containsKey(eachSquare - arr[i])) {
					counter += map.get(eachSquare - arr[i]);
				} else if (eachSquare - arr[i] == arr[i]) {
					counter++;
				} else {
					map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
				}
			}
		}

		return counter;
	}

}
