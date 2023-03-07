package oct3;

import java.util.Arrays;

public class PerimeterOfTriangle {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2, 4, 18, 8 };
		Arrays.sort(nums);
		System.out.println(largestPerimeter(nums));

	}

	public static int largestPerimeter(int[] nums) {

		for (int i = nums.length - 3; i >= 0; i--) {
			if (!ifAreaZero(nums[i], nums[i + 1], nums[i + 2])) {
				return nums[i] + nums[i + 1] + nums[i + 2];
			}
		}
		return 0;
	}

	public static boolean ifAreaZero(int a, int b, int c) {
		double s = (double) (a + b + c) / (double) 2;
		if (s * (s - a) * (s - b) * (s - c) < 0) {
			return true;
		}
		double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return area <= 0 ? true : false;
	}

}
