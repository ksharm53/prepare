package oct3;

import java.util.ArrayList;
import java.util.List;

public class AllPathFromSourceToTarget {
	public static List<List<Integer>> mainList;

	public static void main(String[] args) {
		mainList = new ArrayList<>();

		int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
		int target = graph.length - 1;
		solve(graph, target, 0, new ArrayList<>());
		System.out.println(mainList);

	}

	public static void solve(int[][] graph, int target, int curr, List<Integer> currList) {
		currList.add(curr);
		if (curr == target) {
			mainList.add(new ArrayList<>(currList));
			currList.remove(currList.size() - 1);
			return;
		}

		for (int i = 0; i < graph[curr].length; i++) {
			solve(graph, target, graph[curr][i], currList);
		}

		if (currList.size() > 0) {
			currList.remove(currList.size() - 1);
		}
	}

}
