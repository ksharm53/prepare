package may1;

public class GenerateMatrix {

	public static void main(String[] args) {
		int n = 1;
		System.out.println(solve(n));

	}

	private static int[][] solve(int n) {
		int[][] res = new int[n][n];

		int row = 0;
		int col = 0;
		int rowUpLimit = 0;
		int rowBottomLimit = n - 1;
		int colLeftLimit = 0;
		int colRightLimit = n - 1;

		StringBuilder dir = new StringBuilder("right");

		int val = 1;
		while (val <= (n * n)) {

			if (dir.toString().equals("right")) {

				while (col <= colRightLimit) {
					res[row][col] = val;
					val++;
					col++;
				}
				col--;
				row++;
				rowUpLimit++;

				dir = new StringBuilder();
				dir.append("down");
			}

			else if (dir.toString().equals("down")) {

				while (row <= rowBottomLimit) {
					res[row][col] = val;
					val++;
					row++;
				}
				row--;
				col--;
				colRightLimit--;

				dir = new StringBuilder();
				dir.append("left");
			}

			else if (dir.toString().equals("left")) {

				while (col >= colLeftLimit) {
					res[row][col] = val;
					val++;
					col--;
				}
				col++;
				row--;
				rowBottomLimit--;

				dir = new StringBuilder();
				dir.append("up");
			}

			else if (dir.toString().equals("up")) {

				while (row >= rowUpLimit) {
					res[row][col] = val;
					val++;
					row--;
				}
				row++;
				col++;
				colLeftLimit++;

				dir = new StringBuilder();
				dir.append("right");
			}
		}
		return res;
	}

}
