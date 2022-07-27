package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingStrings {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("aba", "baba", "aba", "xzxb");
		List<String> queries = Arrays.asList("aba", "xzxb", "ab");

		System.out.println(solve(strings, queries));

	}

	public static List<Integer> solve(List<String> strings, List<String> queries) {
		List<Integer> list = new ArrayList<>();
		if (strings.size() == 0 || queries.size() == 0) {
			return list;
		}

		Map<String, Integer> map = new HashMap<>();

		for (String each : strings) {
			map.put(each, map.getOrDefault(each, 0) + 1);
		}

		for (int i = 0; i < queries.size(); i++) {
			if (null != map.get(queries.get(i))) {
				list.add(map.get(queries.get(i)));
			} else {
				list.add(0);
			}
		}
		return list;
	}

}
