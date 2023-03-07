package Oct21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zipRecruiter {

	public static void main(String[] args) {
		String[][] logs = { { "supply", "item1", "2", "100" }, { "supply", "item2", "3", "60" },
				{ "sell", "item1", "1" }, { "sell", "item1", "1" }, { "sell", "item2", "2" },
				{ "return", "item2", "1", "60", "40" }, { "sell", "item2", "1" }, { "sell", "item2", "1" } };

		System.out.println(solve(logs));
	}

	private static List<Integer> solve(String[][] logs) {
		Map<String, List<int[]>> map = new HashMap<>();
		List<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < logs.length; i++) {
			String[] strings = logs[i];
			if (strings[0].equals("supply")) {
				List<int[]> list = map.getOrDefault(strings[1], new ArrayList<>());
				list.add(new int[] { Integer.valueOf(strings[2]), Integer.valueOf(strings[3]) });
				map.put(strings[1], list);
			} else if (strings[0].equals("sell")) {
				int minPrice = Integer.MAX_VALUE;
				int idx = -1;
				List<int[]> list = map.get(strings[1]);
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[1] < minPrice && list.get(j)[0] > 0) {
						minPrice = list.get(j)[1];
						idx = j;
					}
				}
				res.add(minPrice * Integer.valueOf(strings[2]));
				int[] prev = list.get(idx);
				int count = prev[0];
				int rate = prev[1];

				list.set(idx, new int[] { count - Integer.valueOf(strings[2]), rate });

				map.put(strings[1], list);
			}

			else if (strings[0].equals("return")) {
				List<int[]> list = map.get(strings[1]);
				int[] temp = new int[] { Integer.valueOf(strings[2]), Integer.valueOf(strings[4]) };
				list.add(temp);
				map.put(strings[1], list);
			}
		}
		return res;
	}

}
