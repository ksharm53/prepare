package arraysAndStrings;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestPalindromicSubstring {

	static Map<Integer, List<Map<Integer, Integer>>> map = new HashMap<>();

	public static void main(String[] args) {

		map= new HashMap<>();
		
		String s = "cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc";

		
		StringBuilder sb = new StringBuilder(s);
		String r = sb.reverse().toString();

		int matrix[][] = solve(s, r);

		findMax(matrix);

		System.out.println(createString(matrix, s, r, map));
	}

	private static String createString(int[][] matrix, String s, String r,
			Map<Integer, List<Map<Integer, Integer>>> map2) {

		int i = map2.keySet().stream().max(Comparator.naturalOrder()).get();

		while (i > 0) {
			List<Map<Integer, Integer>> temp = map2.get(i);

			for (Map<Integer, Integer> is : temp) {
				String returnValue = createString(matrix, s, r, (int) is.keySet().toArray()[0],
						(int) is.values().toArray()[0]);

				StringBuilder sbResult = new StringBuilder(returnValue);
				if (sbResult.reverse().toString().equalsIgnoreCase(returnValue)) {
					return returnValue;
				} else {
					continue;
				}
			}
			i--;

		}
		return "";

	}

	private static String createString(int[][] matrix, String s, String r, int indexI2, int indexJ2) {
		int i = indexI2;
		int j = indexJ2;

		StringBuilder sb = new StringBuilder();

		while (matrix[i][j] != 0) {
			if (s.charAt(i - 1) == r.charAt(j - 1)) {
				sb.append(s.charAt(i - 1));
				i--;
				j--;
			}
		}
		return sb.toString();

	}

	private static void findMax(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				int value = matrix[i][j];
				if(value==0) {
					continue;
				}
				if (map.containsKey(value)) {
					Map<Integer, Integer> temp = new HashMap<>();
					temp.put(i, j);
					map.get(value).add(temp);
				} else {
					Map<Integer, Integer> temp = new HashMap<>();
					List<Map<Integer, Integer>> tempList = new ArrayList<>();
					temp.put(i, j);
					tempList.add(temp);

					map.put(value, tempList);
				}
			}
		}
	}

	private static int[][] solve(String s, String r) {

		int matrix[][] = new int[s.length() + 1][r.length() + 1];

		for (int i = 0; i <= s.length(); i++) {
			matrix[i][0] = 0;
		}

		for (int i = 0; i <= r.length(); i++) {
			matrix[0][i] = 0;
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= r.length(); j++) {
				if (s.charAt(i - 1) == r.charAt(j - 1)) {
					matrix[i][j] = 1 + matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = 0;
				}

			}
		}
		return matrix;
	}

}
