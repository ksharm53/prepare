package oct2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindDiagonalOrder {

	public static void main(String[] args) {

		List<List<Integer>> nums = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5), Arrays.asList(6, 7), Arrays.asList(8),
				Arrays.asList(9, 10, 11), Arrays.asList(12, 13, 14, 15, 16));
		System.out.println(solve(nums));

	}

	private static int[] solve(List<List<Integer>> nums) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < nums.size(); i++) {
			int column = 0;
			for (int j = i; j >= 0; j--) {
				if (column >= nums.get(j).size()) {
					column++;
					continue;
				}
				list.add(nums.get(j).get(column));
				column++;
			}
		}

		for (int col = 1; col < nums.get(nums.size() - 1).size(); col++) {
			int temp = col;
			for (int row = nums.size() - 1; row >= 0; row--) {
				if (temp >= nums.get(row).size()) {
					temp++;
					continue;
				}
				list.add(nums.get(row).get(temp));
				temp++;
			}
		}

		int[] res = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			res[i] = list.get(i);
		}

		return res;
	}

}
