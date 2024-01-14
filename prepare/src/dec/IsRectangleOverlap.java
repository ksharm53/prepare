package dec;

public class IsRectangleOverlap {

	public static void main(String[] args) {
		int[] rec1 = { 2, 17, 6, 20 };
		int[] rec2 = { 3, 8, 6, 20 };
		System.out.println(solve(rec1, rec2));
	}

	private static boolean solve(int[] rec1, int[] rec2) {
		int rect1x1 = rec1[0];
		int rect1x2 = rec1[2];
		int rect1y1 = rec1[1];
		int rect1y2 = rec1[3];

		int rect2x1 = rec2[0];
		int rect2x2 = rec2[2];
		int rect2y1 = rec2[1];
		int rect2y2 = rec2[3];

		boolean horizontal = ((rect1x2 > rect2x1 && rect1x2 <= rect2x2) || (rect1x1 > rect2x1 && rect1x1 <= rect2x2)
				|| (rect1x1 > rect2x1 && rect1x2 <= rect2x2) || (rect2x1 > rect1x1 && rect2x2 <= rect1x2));
		boolean vertical = ((rect1y2 > rect2y1 && rect1y2 <= rect2y2) || (rect1y1 > rect2y1 && rect1y1 <= rect2y2)
				|| (rect1y1 > rect2y1 && rect1y2 <= rect2y2) || (rect2y1 > rect1y1 && rect2y2 <= rect1y2));
		if (horizontal && vertical) {
			return true;
		}

		return false;
	}

}
