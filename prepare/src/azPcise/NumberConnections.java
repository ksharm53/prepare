package azPcise;

import java.util.Arrays;
import java.util.List;

public class NumberConnections {

	public static void main(String[] args) {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(1, 0, 1, 1), Arrays.asList(0, 1, 1, 0),
				Arrays.asList(0, 0, 0, 0), Arrays.asList(1, 0, 0, 0));

		System.out.println(solve(list));

	}

	private static int solve(List<List<Integer>> list) {
		int finalConnections = 0;
		int initialSum = 0;
		if (list.size() == 0) {
			return 0;
		}

		List<Integer> temp = list.get(0);
		for (Integer each : temp) {
			initialSum += each;
		}

		for (int i = 1; i < list.size(); i++) {
			int eachSum = 0;
			List<Integer> listEach = list.get(i);
			for (Integer each : listEach) {
				eachSum += each;
			}
			finalConnections += initialSum * eachSum;
			initialSum = eachSum == 0 ? initialSum : eachSum;
		}
		return finalConnections;
	}

}
