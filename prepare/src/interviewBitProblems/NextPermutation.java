package interviewBitProblems;

import java.util.Arrays;

public class NextPermutation {

	public static void main(String[] args) {
		int[] A = { 444, 994, 508, 72, 125, 299, 181, 238, 354, 223, 691, 249, 838, 890, 758, 675, 424, 199, 201, 788,
				609, 582, 979, 259, 901, 371, 766, 759, 983, 728, 220, 16, 158, 822, 515, 488, 846, 321, 908, 469, 84,
				460, 961, 285, 417, 142, 952, 626, 916, 247, 116, 975, 202, 734, 128, 312, 499, 274, 213, 208, 472, 265,
				315, 335, 205, 784, 708, 681, 160, 448, 365, 165, 190, 693, 606, 226, 351, 241, 526, 311, 164, 98, 422,
				363, 103, 747, 507, 669, 153, 856, 701, 319, 695, 52 };
		System.out.println(solve(A));

	}

	private static int[] solve(int[] a) {
		if (a.length == 0) {
			return new int[] {};
		}

		int i = a.length - 2;
		while (i >= 0) {
			if (a[i] < a[i + 1]) {
				break;
			} else {
				i--;
			}
		}

		if (i < 0) {
			Arrays.sort(a);
			return a;
		}

		int j = a.length - 1;
		while (j >= 0) {
			if (a[j] > a[i]) {
				break;
			} else {
				j--;
			}
		}

		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;

		int start = i + 1;
		int end = a.length - 1;
		while (start < end) {
			int tempVar = a[start];
			a[start] = a[end];
			a[end] = tempVar;
			start++;
			end--;
		}
		return a;
	}

}
