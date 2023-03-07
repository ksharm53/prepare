package feb07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

public class MinimumFuelCost {

	public static void main(String[] args) {
		int[][] roads = { { 0, 1 }, { 1, 2 } };
		int seats = 3;
		System.out.println(solve(roads, seats));

	}

	private static int solve(int[][] roads, int seats) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		Set<Integer> visited = new HashSet<>();
		int fuel = 0;

		for (int[] is : roads) {
			List<Integer> list = map.getOrDefault(is[0], new ArrayList<>());
			list.add(is[1]);
			map.put(is[0], list);

			List<Integer> list1 = map.getOrDefault(is[1], new ArrayList<>());
			list1.add(is[0]);
			map.put(is[1], list1);
		}

		Queue<int[]> queue = new LinkedList<>();

		for (Entry<Integer, List<Integer>> eachEntry : map.entrySet()) {
			if (eachEntry.getValue().size() == 1 && eachEntry.getKey() != 0) {
				queue.add(new int[] { eachEntry.getKey(), seats, 1 });
			}
		}

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			fuel += curr[2];
			List<Integer> list = map.get(curr[0]);

			if (!visited.contains(curr[0])) {
				for (int i = 0; i < list.size(); i++) {
					if (!visited.contains(list.get(i)) && list.get(i) != 0) {
						boolean found = false;
						Iterator<int[]> iterator = queue.iterator();

						while (iterator.hasNext()) {
							int[] eachElement = iterator.next();
							if (eachElement[0] == list.get(i)) {
								queue.remove(eachElement);
								if (eachElement[1] - 1 <= 0) {
									queue.add(new int[] { list.get(i), seats, eachElement[2] + 1 });
								} else {
									queue.add(new int[] { list.get(i), curr[1] - 1, 1 });
								}
								found = true;
							}
						}

						if (!found) {
							if (curr[1] - 1 <= 0) {
								queue.add(new int[] { list.get(i), seats, curr[2] + 1 });
							} else {
								queue.add(new int[] { list.get(i), curr[1] - 1, 1 });
							}
						}

					}
				}
			}

			visited.add(curr[0]);
		}
		return fuel;
	}

}
