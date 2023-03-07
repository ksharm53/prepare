package Oct21;

public class MinCosttoConnectAllPoints {

	public static int[][] matrix;

	public static void main(String[] args) {
		int[][] points = { { 3, 12 }, { -2, 5 }, { -4, 1 } };
		matrix = new int[points.length][points.length];

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < points.length; j++) {
				int xi = points[i][0];
				int yi = points[i][1];
				int xj = points[j][0];
				int yj = points[j][1];
				matrix[i][j] = Math.abs(xi - xj) + Math.abs(yi - yj);
			}
		}

		System.out.println(solve(points));
	}

	private static int solve(int[][] points) {
		int[] distance = new int[matrix.length];
		int sum = 0;
		for (int i = 0; i < points.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		int startVertex = 0;
		distance[startVertex] = 0;
		boolean[] visited = new boolean[points.length];
		int counter = 0;

		while (counter < points.length) {
			int[] arr = matrix[startVertex];
			int minIdx = -1;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < arr.length; i++) {
				if (matrix[startVertex][i] < distance[i] && !visited[i]) {
					distance[i] = matrix[startVertex][i];
				}
				visited[startVertex] = true;
			}

			for (int i = 0; i < distance.length; i++) {
				if (!visited[i] && distance[i] < min) {
					min = distance[i];
					minIdx = i;
				}
			}

			startVertex = minIdx;
			counter++;
		}
		for (int i = 0; i < distance.length; i++) {
			sum += distance[i];
		}

		return sum;
	}

}
