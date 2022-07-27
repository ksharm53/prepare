package arraysAndStrings;

public class RainWaterTrap {

	public static void main(String[] args) {
		int[] height = { 4, 2, 0, 3, 2, 5 };

		System.out.println(solve(height));
	}

	private static int solve(int[] height) {

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
