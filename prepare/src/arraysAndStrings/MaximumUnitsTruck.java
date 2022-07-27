package arraysAndStrings;

import java.util.Arrays;

public class MaximumUnitsTruck {

	public static void main(String[] args) {
		int[][] boxTypes = { { 1, 3 }, { 2, 2 }, { 3, 1 } };
		int truckSize = 4;

		System.out.println(solve(boxTypes, truckSize));

	}

	private static int solve(int[][] boxTypes, int truckSize) {

		int truckCapacity = truckSize;
		int result = 0;
		if (boxTypes.length == 0 || truckSize == 0) {
			return 0;
		}

		Arrays.sort(boxTypes, (a, b) -> Integer.compare(a[1], b[1]));

		for (int i = boxTypes.length - 1; i >= 0; i--) {
			int shipmentSize = boxTypes[i][0];
			int unitSize = boxTypes[i][1];

			if (shipmentSize <= truckCapacity) {
				result = result + (shipmentSize * unitSize);
				truckCapacity = truckCapacity - shipmentSize;
			} else if (shipmentSize > truckCapacity && truckCapacity > 0) {
				while (truckCapacity > 0) {
					result = result + unitSize;
					truckCapacity--;
				}
			} else {
				return result;
			}
		}
		return result;

	}

}
