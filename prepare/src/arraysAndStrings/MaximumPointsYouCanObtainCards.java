package arraysAndStrings;

public class MaximumPointsYouCanObtainCards {

	// static Map<String, Integer> map;
	// static int[][][] matrix;

	public static void main(String[] args) {

		// map = new HashMap<>();

		int[] cardPoints = { 9, 7, 7, 9, 7, 7, 9 };
		int k = 7;

		// matrix = new int[cardPoints.length + 1][cardPoints.length + 1][k + 1];

		/*
		 * for (int[][] i : matrix) { for (int[] j : i) { Arrays.fill(j, -1); } }
		 */

		// System.out.println(solveMatrxi(cardPoints, k, 0, cardPoints.length - 1));

		System.out.println(solveSlidingWindow(cardPoints, k));

		System.out.println("Test");

	}

	private static int solveSlidingWindow(int[] cardPoints, int k) {

		int i = 0;
		int j = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;

		if (cardPoints.length == 0 || k == 0 || cardPoints.length < k) {
			return 0;
		}

		int window = cardPoints.length - k;

		for (int l : cardPoints) {
			sum = sum + l;
		}

		if (window == 0) {
			return sum;
		}

		int tempSum = sum;

		while (j < cardPoints.length) {
			tempSum = tempSum - cardPoints[j];

			if (j - i + 1 < window) {
				j++;
			} else if (j - i + 1 == window) {
				max = Math.max(max, tempSum);
				j++;
				tempSum = tempSum + cardPoints[i];
				i++;
			}
		}
		return max;
	}

	/*
	 * private static int solveMatrxi(int[] cardPoints, int k, int start, int end) {
	 * 
	 * int length = cardPoints.length;
	 * 
	 * if (length == 0 || k == 0 || length < k) { return 0; }
	 * 
	 * if (matrix[start][end][k] != -1) { return matrix[start][end][k]; }
	 * 
	 * int left = cardPoints[start] + solveMatrxi(cardPoints, k - 1, start + 1,
	 * end); int right = cardPoints[end] + solveMatrxi(cardPoints, k - 1, start, end
	 * - 1);
	 * 
	 * int max = Math.max(left, right);
	 * 
	 * return matrix[start][end][k] = max; }
	 * 
	 * private static int solve(int[] cardPoints, int k, int start, int end) {
	 * 
	 * StringBuilder sb = new StringBuilder(); sb.append(start); sb.append(end);
	 * sb.append(k);
	 * 
	 * if (map.get(sb.toString()) != null) { return map.get(sb.toString()); }
	 * 
	 * int length = cardPoints.length; if (length == 0 || k == 0 || length < k) {
	 * map.put(sb.toString(), 0); return 0; }
	 * 
	 * int left = cardPoints[start] + solve(cardPoints, k - 1, start + 1, end); int
	 * right = cardPoints[end] + solve(cardPoints, k - 1, start, end - 1);
	 * 
	 * int max = Math.max(left, right); map.put(sb.toString(), max);
	 * 
	 * return max; }
	 */

}
