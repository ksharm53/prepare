package may1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairs {

	static List<Integer> list;

	public static void main(String[] args) {
		int[] deliciousness = { 149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234 };

		list = new ArrayList<>();

		for (int i = 0; i <= 32; i++) {
			list.add((int) Math.pow(2, i));
		}

		System.out.println(solve(deliciousness));
	}

	private static int solve(int[] deliciousness) {
		int mod = 1000000007;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int i = 0; i < deliciousness.length; i++) {
			if (map.containsKey(deliciousness[i])) {
				count += (map.get(deliciousness[i]) % mod);
				count %= mod;
			}

			for (int j = 0; j < list.size(); j++) {
				int diff = list.get(j) - deliciousness[i];
				map.put(diff, map.getOrDefault(diff, 0) + 1);
			}
		}

		return count % mod;
	}

}
