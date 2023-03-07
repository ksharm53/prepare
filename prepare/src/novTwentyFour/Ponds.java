package novTwentyFour;

import java.util.LinkedList;
import java.util.Queue;

public class Ponds {

	public static int[][] matrix;

	public static void main(String[] args) {
		String[] arr = { "#--------##-", "-###-----###", "----##---##-", "---------##-", "---------#--", "--#------#--",
				"-#-#-----##-", "#-#-#-----#-", "-#-#------#-", "--#-------#-" };

		matrix = new int[arr.length][arr[0].length()];
		int counter = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length(); j++) {
				if (arr[i].charAt(j) == '#' && matrix[i][j] == 0) {
					solve(arr, i, j);
					counter++;
				}
			}
		}
		System.out.println(counter);

	}

	private static void solve(String[] arr, int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { row, col });
		matrix[row][col] = 1;
		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int i = 0; i < level; i++) {
				int[] curr = queue.poll();
				int currRow = curr[0];
				int currCol = curr[1];
				// Down
				if (currRow + 1 < arr.length && arr[currRow + 1].charAt(currCol) != '-'
						&& matrix[currRow + 1][currCol] != 1) {
					queue.add(new int[] { currRow + 1, currCol });
					matrix[currRow + 1][currCol] = 1;
				}
				// Up
				if (currRow - 1 >= 0 && arr[currRow - 1].charAt(currCol) != '-' && matrix[currRow - 1][currCol] != 1) {
					queue.add(new int[] { currRow - 1, currCol });
					matrix[currRow - 1][currCol] = 1;
				}
				// Right
				if (currCol + 1 < arr[currRow].length() && arr[currRow].charAt(currCol + 1) != '-'
						&& matrix[currRow][currCol + 1] != 1) {
					queue.add(new int[] { currRow, currCol + 1 });
					matrix[currRow][currCol + 1] = 1;
				}
				// Left
				if (currCol - 1 >= 0 && arr[currRow].charAt(currCol - 1) != '-' && matrix[currRow][currCol - 1] != 1) {
					queue.add(new int[] { currRow, currCol - 1 });
					matrix[currRow][currCol - 1] = 1;
				}
				// Up Left
				if (currCol - 1 >= 0 && currRow - 1 >= 0 && arr[currRow - 1].charAt(currCol - 1) != '-'
						&& matrix[currRow - 1][currCol - 1] != 1) {
					queue.add(new int[] { currRow - 1, currCol - 1 });
					matrix[currRow - 1][currCol - 1] = 1;
				}

				// Up Right
				if (currRow - 1 >= 0 && currCol + 1 < arr[currRow - 1].length()
						&& arr[currRow - 1].charAt(currCol + 1) != '-' && matrix[currRow - 1][currCol + 1] != 1) {
					queue.add(new int[] { currRow - 1, currCol + 1 });
					matrix[currRow - 1][currCol + 1] = 1;
				}

				// Down Right
				if (currRow + 1 < arr.length && currCol + 1 < arr[currRow + 1].length()
						&& arr[currRow + 1].charAt(currCol + 1) != '-' && matrix[currRow + 1][currCol + 1] != 1) {
					queue.add(new int[] { currRow + 1, currCol + 1 });
					matrix[currRow + 1][currCol + 1] = 1;
				}

				// Down Left
				if (currRow + 1 < arr.length && currCol - 1 >= 0 && arr[currRow + 1].charAt(currCol - 1) != '-'
						&& matrix[currRow + 1][currCol - 1] != 1) {
					queue.add(new int[] { currRow + 1, currCol - 1 });
					matrix[currRow + 1][currCol - 1] = 1;
				}
			}
		}

	}

}
