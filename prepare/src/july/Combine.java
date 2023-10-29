package july;

import java.util.ArrayList;
import java.util.List;

public class Combine {

	static List<List<Integer>> list;

	public static void main(String[] args) {
		int n = 20, k = 2;
		list = new ArrayList<>();

		solve(1, k, new ArrayList<>(), n);

		System.out.println(list);

	}

	private static void solve(int n, int k, List<Integer> innerList, int limit) {
		if (innerList.size() == k || (innerList.size() > 0 && innerList.get(innerList.size() - 1) == limit)) {
			if (innerList.size() == k) {
				list.add(new ArrayList<>(innerList));
			}

			if (innerList.size() > 0) {
				innerList.remove(innerList.size() - 1);
			}
			return;
		}
		for (int i = n; i <= limit; i++) {
			innerList.add(i);
			solve(i + 1, k, innerList, limit);
		}

		if (innerList.size() > 0) {
			innerList.remove(innerList.size() - 1);
		}
	}

}
