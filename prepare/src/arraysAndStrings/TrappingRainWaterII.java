package arraysAndStrings;

public class TrappingRainWaterII {

	public static void main(String[] args) {
		int[][] heightMap = { { 12, 13, 1, 12 }, { 13, 4, 13, 12 }, { 13, 8, 10, 12 }, { 12, 13, 12, 12 },
				{ 13, 13, 13, 13 } };

		System.out.println(solve(heightMap));

	}

	private static int solve(int[][] heightMap) {
		int totalWater = 0;
		if (heightMap.length == 0) {
			return 0;
		}
		for (int i = 1; i < heightMap[0].length - 1; i++) {
			int[] tempArray = new int[heightMap.length];
			for (int j = 0; j < heightMap.length; j++) {
				tempArray[j] = heightMap[j][i];
			}

			totalWater = totalWater + findtrappedWater(tempArray);
		}
		return totalWater;
	}

	private static int findtrappedWater(int[] height) {

		int totalWater = 0;
		if (height.length == 0) {
			return 0;
		}

		int[] nGRight = nextGreaterRight(height);
		int[] ngLeft = maxGreaterLeft(height);

		for (int i = 0; i < height.length; i++) {
			totalWater = totalWater + Math.min(ngLeft[i], nGRight[i]) - height[i];
		}

		return totalWater;
	}

	private static int[] maxGreaterLeft(int[] height) {
		int[] result = new int[height.length];
		result[0] = height[0];

		for (int i = 1; i < height.length; i++) {
			result[i] = Math.max(result[i - 1], height[i]);
		}
		return result;
	}

	private static int[] nextGreaterRight(int[] height) {
		int[] result = new int[height.length];
		result[height.length - 1] = height[height.length - 1];

		for (int i = height.length - 2; i >= 0; i--) {
			result[i] = Math.max(result[i + 1], height[i]);
		}

		return result;
	}

}
