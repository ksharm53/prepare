package mar01;

import java.util.Arrays;

public class MinNumber {

	public static void main(String[] args) {
		int[] nums1 = { 3, 5, 2, 6 };
		int[] nums2 = { 3, 1, 7 };
		System.out.println(minNumber(nums1, nums2));
	}

	public static int minNumber(int[] nums1, int[] nums2) {
		int min = Integer.MAX_VALUE;
		int sb = 0;

		Arrays.sort(nums1);
		Arrays.sort(nums2);

		for (int i = 1; i <= 9; i++) {
			if (!(Arrays.binarySearch(nums1, i) < 0)) {
				sb = 0;
				sb = (sb * 10) + i;
				for (int j = 1; j <= 9; j++) {
					boolean flag = false;
					if (!(Arrays.binarySearch(nums2, j) < 0)) {
						if (i != j) {
							flag = true;
							sb = (sb * 10) + j;
						}
						min = Math.min(min, sb);
						if (flag) {
							sb = sb / 10;
						}
					}
				}
			}
		}

		for (int i = 1; i <= 9; i++) {
			if (!(Arrays.binarySearch(nums2, i) < 0)) {
				sb = 0;
				sb = (sb * 10) + i;
				for (int j = 1; j <= 9; j++) {
					boolean flag = false;
					if (!(Arrays.binarySearch(nums1, j) < 0)) {
						if (i != j) {
							flag = true;
							sb = (sb * 10) + j;
						}
						min = Math.min(min, sb);
						if (flag) {
							sb = sb / 10;
						}
					}
				}
			}
		}

		return min;
	}

}
