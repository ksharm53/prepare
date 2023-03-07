package nov13;

import java.util.HashSet;
import java.util.Set;

public class ErectTheFence {

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 2, 2 }, { 2, 0 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
		// int[][] points = { { 1, 2 }, { 2, 2 }, { 4, 2 } };
		// System.out.println(solve(points));
		solve(points);
	}

	private static char[] solve(int[][] points) {
		Set<int[]> list = new HashSet<>();

		int xMin = Integer.MAX_VALUE;
		int[] xMinVal = null;
		int xMax = Integer.MIN_VALUE;
		int[] xMaxVal = null;
		int yMin = Integer.MAX_VALUE;
		int[] yMinVal = null;
		int yMax = Integer.MIN_VALUE;
		int[] yMaxVal = null;

		for (int[] each : points) {
			if (xMin > each[0]) {
				xMin = each[0];
				xMinVal = each;
			}
			if (xMax < each[0]) {
				xMax = each[0];
				xMaxVal = each;
			}
			if (yMin > each[1]) {
				yMin = each[1];
				yMinVal = each;
			}

			if (yMax < each[1]) {
				yMax = each[1];
				yMaxVal = each;
			}
		}

		list.add(xMinVal);
		list.add(xMaxVal);
		list.add(yMinVal);
		list.add(yMaxVal);

		for (int[] each : points) {
			if (each[0] == xMin && each != xMinVal) {
				list.add(each);
			}

			if (each[0] == xMax && each != xMaxVal) {
				list.add(each);
			}

			if (each[1] == yMin && each != yMinVal) {
				list.add(each);
			}

			if (each[1] == yMax && each != yMaxVal) {
				list.add(each);
			}
		}

		System.out.println(list);
		return null;
	}

}
