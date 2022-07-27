package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		int numRows = 5;

		System.out.println(solve(numRows));

	}

	private static List<List<Integer>> solve(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		if (numRows == 0) {
			return list;
		}

		list.add(Arrays.asList(1));
		if (numRows == 1) {
			return list;
		}
		list.add(Arrays.asList(1, 1));
		if (numRows == 2) {
			return list;
		}
		for (int i = 3; i <= numRows; i++) {
			List<Integer> temp = new ArrayList<>();
			temp.add(1);
			for (int j = 0; j < list.get(i - 2).size(); j++) {
				if (j + 1 < list.get(i - 2).size()) {
					temp.add(list.get(i - 2).get(j) + list.get(i - 2).get(j + 1));
				}
			}
			temp.add(1);
			list.add(temp);
		}

		return list;
	}

}
