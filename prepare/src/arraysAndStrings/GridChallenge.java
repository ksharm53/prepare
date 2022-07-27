package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class GridChallenge {

	public static void main(String[] args) {
		List<String> grid = Arrays.asList("acb", "ade", "efg");

		System.out.println(solve(grid));

	}

	private static String solve(List<String> grid) {
		if (grid.size() == 0) {
			return "NO";
		}
		if (grid.size() == 1) {
			return "YES";
		}

		char[] array = grid.get(0).toCharArray();
		Arrays.sort(array);
		grid.set(0, new String(array));

		for (int i = 1; i < grid.size(); i++) {

			String previous = grid.get(i - 1);
			if (grid.get(i).length() != previous.length()) {
				return "NO";
			}
			array = grid.get(i).toCharArray();
			Arrays.sort(array);
			grid.set(i, new String(array));

			for (int j = 0; j < grid.get(i).length(); j++) {
				if (grid.get(i).charAt(j) < grid.get(i - 1).charAt(j)) {
					return "NO";
				}
			}
		}
		return "YES";
	}

}
