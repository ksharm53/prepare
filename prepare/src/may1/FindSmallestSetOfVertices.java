package may1;

import java.util.ArrayList;
import java.util.List;

public class FindSmallestSetOfVertices {

	public static void main(String[] args) {
		int n = 6;
		List<List<Integer>> edges = List.of(List.of(0, 1), List.of(0, 2), List.of(2, 5), List.of(3, 4), List.of(4, 2));
		System.out.println(solve(n, edges));

	}

	private static List<Integer> solve(int n, List<List<Integer>> edges) {
		int[] list = new int[n];
		List<Integer> listList = new ArrayList<>();

		for (int i = 0; i < edges.size(); i++) {
			list[edges.get(i).get(1)] = -1;
		}

		for (int i = 0; i < list.length; i++) {
			if (list[i] != -1) {
				listList.add(i);
			}
		}

		return listList;
	}

}
