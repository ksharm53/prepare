package feb07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Questio1 {

	public static void main(String[] args) {
		int[][] nums1 = { { 148, 597 }, { 165, 623 }, { 306, 359 }, { 349, 566 }, { 403, 646 }, { 420, 381 },
				{ 566, 543 }, { 730, 209 }, { 757, 875 }, { 788, 208 }, { 932, 695 } };
		int[][] nums2 = { { 74, 669 }, { 87, 399 }, { 89, 165 }, { 99, 749 }, { 122, 401 }, { 138, 16 }, { 144, 714 },
				{ 148, 206 }, { 177, 948 }, { 211, 653 }, { 285, 775 }, { 309, 289 }, { 349, 396 }, { 386, 831 },
				{ 403, 318 }, { 405, 119 }, { 420, 153 }, { 468, 433 }, { 504, 101 }, { 566, 128 }, { 603, 688 },
				{ 618, 628 }, { 622, 586 }, { 641, 46 }, { 653, 922 }, { 672, 772 }, { 691, 823 }, { 693, 900 },
				{ 756, 878 }, { 757, 952 }, { 770, 795 }, { 806, 118 }, { 813, 88 }, { 919, 501 }, { 935, 253 },
				{ 982, 385 } };
		System.out.println(mergeArrays(nums1, nums2));
	}

	public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
		List<int[]> list = new ArrayList<>();
		int i = 0;
		while (i < nums1.length && i < nums2.length) {
			if (nums1[i][0] == nums2[i][0]) {
				boolean flagnum = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == nums1[i][0]) {
						int[] temp = list.get(j);
						list.remove(j);
						list.add(j, new int[] { temp[0], temp[1] + nums1[i][1] + nums2[i][1] });
						flagnum = true;
					}
				}
				if (!flagnum) {
					list.add(new int[] { nums1[i][0], nums1[i][1] + nums2[i][1] });
				}

			} else if (nums1[i][0] < nums2[i][0]) {
				boolean flagnum1 = false;
				boolean flagnum2 = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == nums1[i][0]) {
						int[] temp = list.get(j);
						list.remove(j);
						list.add(j, new int[] { temp[0], temp[1] + nums1[i][1] });
						flagnum1 = true;
					}

					if (list.get(j)[0] == nums2[i][0]) {
						int[] temp = list.get(j);
						list.remove(j);
						list.add(j, new int[] { temp[0], temp[1] + nums2[i][1] });
						flagnum2 = true;
					}
				}

				if (!flagnum1) {
					list.add(nums1[i]);
				}
				if (!flagnum2) {
					list.add(nums2[i]);
				}

			} else if (nums1[i][0] > nums2[i][0]) {
				boolean flagnum1 = false;
				boolean flagnum2 = false;
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j)[0] == nums2[i][0]) {
						int[] temp = list.get(j);
						list.remove(j);
						list.add(j, new int[] { temp[0], temp[1] + nums2[i][1] });
						flagnum2 = true;
					}

					if (list.get(j)[0] == nums1[i][0]) {
						int[] temp = list.get(j);
						list.remove(j);
						list.add(j, new int[] { temp[0], temp[1] + nums1[i][1] });
						flagnum1 = true;
					}

				}
				if (!flagnum2) {
					list.add(nums2[i]);
				}
				if (!flagnum1) {
					list.add(nums1[i]);
				}

			}
			i++;
		}
		int var = i;
		while (var < nums1.length) {
			boolean flagnum = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j)[0] == nums1[var][0]) {
					int[] temp = list.get(j);
					list.remove(j);
					list.add(j, new int[] { temp[0], temp[1] + nums1[var][1] });
					flagnum = true;
				}
			}
			if (!flagnum) {
				list.add(nums1[var]);
			}
			var++;
		}
		var = i;
		while (var < nums2.length) {
			boolean flagnum = false;
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j)[0] == nums2[var][0]) {
					int[] temp = list.get(j);
					list.remove(j);
					list.add(j, new int[] { temp[0], temp[1] + nums2[var][1] });
					flagnum = true;
				}
			}
			if (!flagnum) {
				list.add(nums2[var]);
			}
			var++;
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});

		int[][] res = new int[list.size()][2];
		for (int k = 0; k < list.size(); k++) {
			res[k] = list.get(k);
		}

		return res;
	}

}
