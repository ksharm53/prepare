package oct3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class EvaluateDivision {

	public static void main(String[] args) {
		String[][] equations = { { "a", "b" }, { "b", "c" } };
		double[] values = { 2.0, 3.0 };
		String[][] queries = { { "a", "c" }, { "b", "a" }, { "a", "e" }, { "a", "a" }, { "x", "x" } };

		//System.out.println(solve(equations, values, queries));

		//////////////////////////////////////

		List<List<String>> equationsL = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
		// double[] values = { 2.0, 3.0 };
		List<List<String>> queriesL = Arrays.asList(Arrays.asList("a", "c"), Arrays.asList("b", "a"),
				Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));

		System.out.println(solveL(equationsL, values, queriesL));

	}

	private static double[] solveL(List<List<String>> equationsL, double[] values, List<List<String>> queriesL) {
		double[] result = new double[queriesL.size()];
		Map<String, Map<String, Double>> graph = createGraph(equationsL, values);
		for (int i = 0; i < queriesL.size(); i++) {
			result[i] = findValue(graph, queriesL.get(i).get(0), queriesL.get(i).get(1), new HashSet<String>());
		}
		return result;
	}

	private static Map<String, Map<String, Double>> createGraph(List<List<String>> equations, double[] values) {
		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			List<String> eachEquation = equations.get(i);
			map.putIfAbsent(eachEquation.get(0), new HashMap<>());
			map.get(eachEquation.get(0)).put(eachEquation.get(1), values[i]);

			map.putIfAbsent(eachEquation.get(1), new HashMap<>());
			map.get(eachEquation.get(1)).put(eachEquation.get(0), 1 / values[i]);
		}

		return map;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	private static double[] solve(String[][] equations, double[] values, String[][] queries) {

		double[] result = new double[queries.length];
		Map<String, Map<String, Double>> graph = createGraph(equations, values);
		for (int i = 0; i < queries.length; i++) {
			result[i] = findValue(graph, queries[i][0], queries[i][1], new HashSet<String>());
		}
		return result;

	}

	private static double findValue(Map<String, Map<String, Double>> graph, String from, String to,
			Set<String> visited) {

		if (!graph.containsKey(from)) {
			return -1;
		}

		visited.add(from);

		if (graph.get(from).containsKey(to)) {

			return graph.get(from).get(to);
		} else {
			for (Entry<String, Double> eachChild : graph.get(from).entrySet()) {
				if (!visited.contains(eachChild.getKey())) {
					double childValue = findValue(graph, eachChild.getKey(), to, visited);
					if (childValue != -1) {
						return childValue * eachChild.getValue();
					}
				}
			}
		}
		return -1;

	}

	private static Map<String, Map<String, Double>> createGraph(String[][] equations, double[] values) {

		Map<String, Map<String, Double>> map = new HashMap<>();
		for (int i = 0; i < equations.length; i++) {
			String[] eachEquation = equations[i];
			map.putIfAbsent(eachEquation[0], new HashMap<>());
			map.get(eachEquation[0]).put(eachEquation[1], values[i]);

			map.putIfAbsent(eachEquation[1], new HashMap<>());
			map.get(eachEquation[1]).put(eachEquation[0], 1 / values[i]);
		}

		return map;

	}

}
