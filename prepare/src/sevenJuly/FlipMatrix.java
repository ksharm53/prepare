package sevenJuly;

import java.util.Arrays;
import java.util.List;

public class FlipMatrix {

	public static void main(String[] args) {
		List<List<Integer>> matrix = Arrays.asList(Arrays.asList(112, 42, 83, 119), Arrays.asList(56, 125, 56, 49),
				Arrays.asList(15, 78, 101, 43), Arrays.asList(62, 98, 114, 108));

		System.out.println(solve(matrix));

	}

	private static int solve(List<List<Integer>> matrix) {
		int size = matrix.size() / 2;
		int value = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				value += Math.max(
						Math.max(Math.max(matrix.get(i).get(j), matrix.get(i).get(matrix.get(j).size() - j - 1)),
								matrix.get(matrix.size() - i - 1).get(j)),
						matrix.get(matrix.size() - i - 1).get(matrix.size() - j - 1));
			}
		}
		return value;
	}

}
