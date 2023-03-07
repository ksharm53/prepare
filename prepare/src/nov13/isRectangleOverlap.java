package nov13;

public class isRectangleOverlap {

	public static void main(String[] args) {
		int[] rec1 = { 0, 0, 1, 1 };
		int[] rec2 = { 1, 0, 2, 1 };
		System.out.println(solve(rec1, rec2));

	}

	private static boolean solve(int[] rec1, int[] rec2) {
		int ax1 = rec1[0];
		int ax2 = rec1[2];
		int ay1 = rec1[1];
		int ay2 = rec1[3];

		int bx1 = rec2[0];
		int bx2 = rec2[2];
		int by1 = rec2[1];
		int by2 = rec2[3];

		int mergedLength = 0;
		int mergedWidth = 0;

		if (bx2 > ax1 && ax2 > bx1) {
			mergedLength = Math.abs(Math.max(ax1, bx1) - Math.min(ax2, bx2));
		}

		if (by2 > ay1 && ay2 > by1) {
			mergedWidth = Math.abs(Math.max(ay1, by1) - Math.min(ay2, by2));
		}

		return (mergedLength * mergedWidth) > 0 ? true : false;
	}

}
