package arraysAndStrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyIntegr {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 1);
		System.out.println(lonelyinteger(list));
	}

	public static int lonelyinteger(List<Integer> a) {
		Map<Integer, Integer> map = new HashMap<>();

		for (Integer integer : a) {
			map.put(integer, map.getOrDefault(integer, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> each : map.entrySet()) {
			if (each.getValue() == 1) {
				return each.getKey();
			}
		}
		return a.get(0);
	}

}
