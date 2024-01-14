package dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestCity {

	static Map<String, List<String>> graph;

	public static void main(String[] args) {
		List<List<String>> paths = Arrays.asList(Arrays.asList("London", "New York"), Arrays.asList("New York", "Lima"),
				Arrays.asList("Lima", "Sao Paulo"));
		graph = new HashMap<>();
		System.out.println(solve(paths));

	}

	private static String solve(List<List<String>> paths) {
		makeGraph(paths);
		for (List<String> eachEntry : paths) {
			if (!graph.containsKey(eachEntry.get(0))) {
				return eachEntry.get(0);
			}
			if (!graph.containsKey(eachEntry.get(1))) {
				return eachEntry.get(1);
			}
		}
		return "";
	}

	private static void makeGraph(List<List<String>> paths) {
		for (List<String> each : paths) {
			List<String> list = graph.getOrDefault(each.get(0), new ArrayList<>());
			list.add(each.get(1));
			graph.put(each.get(0), list);
		}
	}

}
