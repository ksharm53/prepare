package Sept23;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
	public static List<List<Integer>> superList;

	public static void main(String[] args) {
		int k = 4;
		int n = 1;
		superList = new ArrayList<>();

		solve(k, n, new ArrayList<>(), 0, 0, 1);

		System.out.println(superList);

	}

	public static void solve(int k, int n, List<Integer> list, int sum, int count, int toAdd) {

		if (count == k) {
			if (sum == n) {
				superList.add(new ArrayList<>(list));
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
				return;
			} else {
				sum -= list.get(list.size() - 1);
				list.remove(list.size() - 1);
				return;
			}
		}

		if (sum > n || count > k) {
			sum -= list.get(list.size() - 1);
			list.remove(list.size() - 1);
			return;
		}

		for (int i = toAdd; i <= 9; i++) {
			if (sum + i > n) {
				break;
			}
			list.add(i);
			solve(k, n, list, sum + i, count + 1, i + 1);
		}
		if (!list.isEmpty()) {
			list.remove(list.size() - 1);
		}

	}

}
