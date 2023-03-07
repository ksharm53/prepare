package jan2023;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DeleteGreatestValue {

	public static void main(String[] args) {
		int[][] grid = { { 1, 2, 4 }, { 3, 3, 1 } };
		System.out.println(solve(grid));
	}

	public static int solve(int[][] grid) {
		List<List<Integer>> bigList = new ArrayList<>();
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			int[] each = grid[i];
			List<Integer> list = new ArrayList<>();

			for (int eachVal : each) {
				list.add(eachVal);
			}
			Collections.sort(list, Collections.reverseOrder());
			bigList.add(list);
		}
		for (int i = 0; i < grid[0].length; i++) {
			int max = Integer.MIN_VALUE;
			for (int j = 0; j < bigList.size(); j++) {
				max = Math.max(max, bigList.get(j).get(i));
			}
			count += max;
		}
		return count;
	}

}
