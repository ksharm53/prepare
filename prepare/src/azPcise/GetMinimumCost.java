package azPcise;

import java.util.List;
import java.util.stream.IntStream;

public class GetMinimumCost {

	public static void main(String[] args) {
		int[] parcels = { 4, 5, 7, 1 };
		int k = 4;
		System.out.println(solve(parcels, k));

	}

	private static long solve(int[] parcels, int k) {
		List<Integer> list = IntStream.of(parcels).boxed().toList();

		int toBeFound = k - parcels.length;
		int start = 1;
		long totalCost = 0;
		while (toBeFound > 0) {
			if (!list.contains(start)) {
				totalCost += start;
				toBeFound--;
			}
			start++;
		}
		return totalCost;
	}

}
