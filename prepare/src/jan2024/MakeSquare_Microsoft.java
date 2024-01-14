package jan2024;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MakeSquare_Microsoft {
	static TreeSet<Integer> set;
	static int[] arrVal;
	static Map<Integer, Integer> map;

	public static void main(String[] args) {
		int[] arr = { 3, 2, 3, 3, 2, 5, 5, 5, 5 };
		set = new TreeSet<>();
		for (int i = 1; i <= 1000; i++) {
			set.add(i * 4);
		}
		arrVal = new int[set.size()];
		map = new HashMap<>();
		int pointer = 0;
		for (int each : set) {
			map.put(each, pointer);
			arrVal[pointer] = each;
			pointer++;
		}
		System.out.println(solve(arr));

	}

	private static int solve(int[] arr) {
		int count = 0;
		for (int each : arr) {
			count += each;
		}

		int floor = set.floor(count);
		int high = map.get(floor);
		for (int i = high; i >= 0; i--) {
			if (validateMid(arr, arrVal[i] / 4, arr.length - 1)) {
				return arrVal[i] / 4;
			}
		}
		return 0;
	}

	private static boolean validateMid(int[] arr, int target, int idx) {
		int edgeCount = findsubArryCount(arr, target, arr.length - 1);
		return edgeCount >= 4;
	}

	private static int findsubArryCount(int[] arr, int target, int idx) {
		if (target == 0) {
			return 1;
		}
		if (idx < 0 || target < 0) {
			return 0;
		}

		if (arr[idx] <= target) {
			int lenge = findsubArryCount(arr, target - arr[idx], idx - 1);
			int naiLenge = findsubArryCount(arr, target, idx - 1);
			return lenge + naiLenge;
		} else {
			return findsubArryCount(arr, target, idx - 1);
		}
	}

}
