package treeAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BFS {

	public static void main(String[] args) {
		int n = 5;
		int m = 3;
		List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2), Arrays.asList(1, 3), Arrays.asList(3, 4));
		int s = 1;

		System.out.println(solve(n, m, edges, s));

	}

	private static List<Integer> solve(int n, int m, List<List<Integer>> edges, int s) {
		List<Integer> list = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			List<Integer> temp = Arrays.asList(s, s + 1);
			if (edges.contains(temp)) {
				list.add(6);
			}
		}
		return null;
	}

}
