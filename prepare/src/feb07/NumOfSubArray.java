package feb07;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumOfSubArray {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5 };
		System.out.println(numOfSubarrays(arr));

	}

	public static int numOfSubarrays(int[] arr) {
		Set<Integer> set = new HashSet<>();
		int total = 0;
		int counter = 0;
		for (int each : arr) {
			if (each % 2 != 0) {
				set.add(each);
			}
			total += each;
			if (total % 2 != 0) {
				set.add(total);
			}
		}
		for (int each : set) {
			counter += isAvailable(arr, each);
		}
		return counter;
	}

	public static int isAvailable(int[] arr, int sum) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int currSum = 0;
		int total = 0;

		for (int eachElement : arr) {
			currSum += eachElement;
			if (map.containsKey(currSum - sum)) {
				total += map.get(currSum - sum);
			}

			map.put(currSum, map.getOrDefault(currSum, 0) + 1);
		}
		return total;
	}

}
