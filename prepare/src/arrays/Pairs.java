package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pairs {

	public static void main(String[] args) {
		int k = 2;
		List<Integer> arr = Arrays.asList(8,10);

		System.out.println(solve(k, arr));

	}

	private static int solve(int k, List<Integer> arr) {
		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		for (Integer integer : arr) {
			int local = integer % k;
			map.put(local, map.getOrDefault(local, 0) + 1);
		}

		List<Integer> list = new ArrayList<>(map.keySet());

		outer: for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) == 0) {
					result = result + map.get(list.get(i)) / 2;
					continue outer;
				}
				if ((list.get(i) + list.get(j)) % k == 0) {
					result = result + map.get(list.get(i)) * map.get(list.get(j));
				}
			}
		}

		return result;

	}

}
