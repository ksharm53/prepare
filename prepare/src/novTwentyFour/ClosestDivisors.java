package novTwentyFour;

import java.util.ArrayList;
import java.util.List;

public class ClosestDivisors {

	public static void main(String[] args) {
		int num = 1000000000;
		int[] res = solve(num);
		System.out.println("");
	}

	private static int[] solve(int num) {
		List<Integer> listFirst = findDivisor(num + 1);
		List<Integer> listSecond = findDivisor(num + 2);

		System.out.println(listFirst.size());
		System.out.println(listSecond.size());
		int[] res = new int[2];
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < listFirst.size(); i++) {
			for (int j = 0; j < listFirst.size(); j++) {
				if (listFirst.get(i) * listFirst.get(j) == num + 1) {
					if (min > Math.abs(listFirst.get(i) - listFirst.get(j))) {
						res = new int[] { listFirst.get(i), listFirst.get(j) };
						min = Math.abs(listFirst.get(i) - listFirst.get(j));
					}
				}
			}
		}

		for (int i = 0; i < listSecond.size(); i++) {
			for (int j = 0; j < listSecond.size(); j++) {
				if (listSecond.get(i) * listSecond.get(j) == num + 2) {
					if (min > Math.abs(listSecond.get(i) - listSecond.get(j))) {
						res = new int[] { listSecond.get(i), listSecond.get(j) };
						min = Math.abs(listSecond.get(i) - listSecond.get(j));
					}
				}
			}
		}
		return res;
	}

	private static List<Integer> findDivisor(int num) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= (int) Math.sqrt(num); i++) {
			if (num % i == 0) {
				if (num / i == i)
					list.add(i);
				else {
					list.add(i);
					list.add(num / i);
				}
			}
		}
		return list;
	}

}
