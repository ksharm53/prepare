package oct2023;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IBM_Test {

	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		arr.add(2);
		arr.add(3);
		arr.add(1);
		arr.add(6);
		int d = 3;

		long result = solve(arr, d);
		System.out.println("Count of triplets: " + result);

	}

	public static int solve(List<Integer> arr, int k) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int sum = 0;
		int rem = 0;
		int ans = 0;

		for (int i = 0; i < arr.size(); i++) {
			sum = sum + arr.get(i);
			rem = sum % k;

			if (rem < 0) {
				rem += k;
			}

			if (map.containsKey(rem)) {
				ans += map.get(rem);
				map.put(rem, map.get(rem) + 1);
			} else {
				map.put(rem, 1);
			}
		}
		return ans;
	}

}
