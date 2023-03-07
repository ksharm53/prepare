package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		List<List<Integer>> A = Arrays.asList(Arrays.asList(1));
		int[][] Aarray = { { 1, 2, 3 }, { 4, 5, 6 } };
		System.out.println(solve(Aarray));
		System.out.println(solve(A));

	}

	private static int[] solve(int[][] a) {

		int topRow = 0;
		int bottomRow = a.length - 1;
		int leftColumn = 0;
		int rightColumn = a[0].length - 1;
		int dir = 0;
		int[] result = new int[a.length * a[0].length];
		List<Integer> list = new ArrayList<>();

		while (topRow <= bottomRow && leftColumn <= rightColumn) {
			if (dir == 0) {
				for (int i = leftColumn; i <= rightColumn; i++) {
					list.add(a[topRow][i]);
				}
				topRow++;
				dir = 1;
			}

			else if (dir == 1) {
				for (int i = topRow; i <= bottomRow; i++) {
					list.add(a[i][rightColumn]);
				}
				rightColumn--;
				dir = 2;
			}

			else if (dir == 2) {
				for (int i = rightColumn; i >= leftColumn; i--) {
					list.add(a[bottomRow][i]);
				}
				bottomRow--;
				dir = 3;
			} else if (dir == 3) {
				for (int i = bottomRow; i >= topRow; i--) {
					list.add(a[i][leftColumn]);
				}
				leftColumn++;
				dir = 0;
			}

		}
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;

	}

	private static List<Integer> solve(List<List<Integer>> a) {
		int topRow = 0;
		int bottomRow = a.size() - 1;
		int leftColumn = 0;
		int rightColumn = a.get(0).size() - 1;
		int dir = 0;
		List<Integer> list = new ArrayList<>();

		while (topRow < a.size() && leftColumn < a.get(0).size()) {
			if (dir == 0) {
				for (int i = leftColumn; i <= rightColumn; i++) {
					list.add(a.get(topRow).get(i));
				}
				topRow++;
				dir = 1;
			}

			else if (dir == 1) {
				for (int i = topRow; i <= bottomRow; i++) {
					list.add(a.get(i).get(rightColumn));
				}
				rightColumn--;
				dir = 2;
			}

			else if (dir == 2) {
				for (int i = rightColumn; i >= leftColumn; i--) {
					list.add(a.get(bottomRow).get(i));
				}
				bottomRow--;
				dir = 3;
			} else if (dir == 3) {
				for (int i = bottomRow; i >= topRow; i--) {
					list.add(a.get(i).get(leftColumn));
				}
				leftColumn++;
				dir = 0;
			}

		}

		return list;
	}

}
