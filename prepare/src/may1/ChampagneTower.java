package may1;

import java.util.Map;
import java.util.TreeMap;

public class ChampagneTower {

	public static void main(String[] args) {
		int poured = 2;
		int query_row = 11;
		int query_glass = 1;

		System.out.println(solve(poured, query_row, query_glass));
	}

	private static double solve(int poured, int query_row, int query_glass) {
		Map<Integer, Integer> set = new TreeMap<>();
		int first = 0;
		for (int i = 1; i <= 100; i++) {
			first += i;
			set.put(i, first);
		}

		int glasses = set.get(query_row);
		if (poured >= glasses) {
			return 1;
		}

		int pendingWine = poured - set.get(query_row - 1);

		if (pendingWine <= 0) {
			return 0;
		}
		
		

		return first;

	}

}
