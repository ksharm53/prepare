package aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(5);
		list.add(3);
		list.add(4);
		list.add(2);
		int target = 2;
		System.out.println(solve(list, target));

	}

	private static int solve(List<Integer> list, int target) {
		Collections.sort(list);
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;

		for (Integer each : list) {
			if (map.containsKey(each)) {
				count += map.get(each);
			}

			map.put(each + target, map.getOrDefault(each + target, 0) + 1);
		}
		return count;
	}

}
