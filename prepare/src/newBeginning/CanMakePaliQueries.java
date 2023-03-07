package newBeginning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanMakePaliQueries {

	public static void main(String[] args) {
		String s = "abcda";
		int[][] queries = { { 3, 3, 0 }, { 1, 2, 0 }, { 0, 3, 1 }, { 0, 3, 2 }, { 0, 4, 1 } };
		System.out.println(solve(s, queries));

	}

	private static List<Boolean> solve(String s, int[][] queries) {

		HashMap<Integer, int[]> map = new HashMap<>();

		int[] arr = new int[26];
		map.put(-1, new int[26]);
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			arr[c - 'a']++;
			map.put(i, getArray(arr));
		}

		List<Boolean> list = new ArrayList<>();
		for (int[] query : queries) {
			int diff = 0;
			int left = query[0];
			int right = query[1];
			int k = query[2];
			for (int i = 0; i < 26; i++) {
				diff += (map.get(right)[i] - map.get(left - 1)[i]) % 2;
			}
			int count = right - left + 1;
			if (count % 2 == 0) {
				list.add(diff / 2 <= k);
			} else {
				list.add((diff - 1) / 2 <= k);
			}
		}

		return list;
	}

	public static int[] getArray(int[] arr) {
		int[] temp = new int[26];
		for (int i = 0; i < 26; i++) {
			temp[i] = arr[i];
		}

		return temp;
	}

}
