package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class WinnerCircularGame {

	public static void main(String[] args) {
		int n = 5;
		int k = 2;

		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}

		System.out.println(solve(list, 0, k));

	}

	private static int solve(List<Integer> list, int index, int k) {

		if (list.size() == 1) {
			return list.get(0);
		}

		int currentindex = (index + k -1) % list.size();

		list.remove(currentindex);

		return solve(list, currentindex, k);

	}

}
