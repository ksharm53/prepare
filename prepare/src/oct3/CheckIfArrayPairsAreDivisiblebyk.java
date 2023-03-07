package oct3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisiblebyk {

	public static void main(String[] args) {
		int[] arr = { -4, -7, 5, 2, 9, 1, 10, 4, -8, -3 };
		int k = 3;
		Arrays.sort(arr);
		System.out.println(canArrange(arr, k));

	}

	public static boolean canArrange(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int counter = 0;
		for (int i = 0; i < arr.length; i++) {
			int rem = ((arr[i] % k) + k) % k;
			if (map.containsKey(rem)) {
				counter++;
				map.put(rem, map.get(rem) - 1);
				if (map.get(rem) == 0) {
					map.remove(rem);
				}
			} else {
				map.put((k - rem) % k, map.getOrDefault((k - rem) % k, 0) + 1);
			}
		}

		int val = map.getOrDefault(k, 0);
		if (val != 0) {
			counter += val / 2;
		}
		System.out.println(counter);
		return counter == k ? true : false;
	}

}
