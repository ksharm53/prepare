package postNoon;

import java.util.Arrays;

public class FinddataLocation {

	public static void main(String[] args) {
		int[] locations = { 1, 7, 6, 8 };
		int[] movedFrom = { 1, 7, 2 };
		int[] movedTo = { 2, 9, 5 };

		System.out.println(solve(locations, movedFrom, movedTo));

	}

	private static int[] solve(int[] locations, int[] movedFrom, int[] movedTo) {

		if (movedFrom.length == 0 || movedTo.length == 0 || movedFrom.length != movedTo.length) {
			Arrays.sort(locations);
			return locations;
		}

		int length = movedFrom.length;

		for (int i = 0; i < length; i++) {
			int index = Arrays.binarySearch(locations, movedFrom[i]);
			locations[index] = movedTo[i];
		}

		Arrays.sort(locations);
		return locations;

	}

}
