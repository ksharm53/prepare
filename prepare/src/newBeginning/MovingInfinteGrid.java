package newBeginning;

import java.util.Arrays;
import java.util.List;

public class MovingInfinteGrid {

	public static void main(String[] args) {
		List<Integer> listA = Arrays.asList(-2);
		List<Integer> listB = Arrays.asList(7);
		System.out.println(coverPoints(listA, listB));
	}

	public static int coverPoints(List<Integer> A, List<Integer> B) {

		if (A.size() == 0 || B.size() == 0 || A.size() != B.size()) {
			return 0;
		}

		int startX = A.get(0);
		int startY = B.get(0);
		int counter = 0;
		String orderX = A.get(A.size() - 1) > startX ? "F" : "B";
		String orderY = B.get(B.size() - 1) > startY ? "F" : "B";

		if (!orderX.equalsIgnoreCase(orderY)) {
			return 0;
		}
		while (startX != A.get(A.size() - 1) && startY != B.get(B.size() - 1)) {
			if (orderX.equalsIgnoreCase("F")) {
				startX++;
				startY++;
				counter++;
			} else if (orderX.equalsIgnoreCase("B")) {
				startX--;
				startY--;
				counter++;
			}

		}

		return counter;

	}

}
