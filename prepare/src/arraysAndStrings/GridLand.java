package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GridLand {

	public static void main(String[] args) {
		List<List<Integer>> list = Arrays.asList(Arrays.asList(2, 1, 5), Arrays.asList(2, 2, 4),
				Arrays.asList(2, 8, 8));
		int n = 2, m = 9, k = 3;

		// System.out.println(gridlandMetro(n, m, k, list));

		System.out.println(missingNumbers(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
				Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204)));

	}

	private static List<Integer> missingNumbersAgain(List<Integer> arr, List<Integer> brr) {
		Collections.sort(arr);
		Collections.sort(brr);
		List<Integer> list = new ArrayList<>();
		int count = 0;
		int temp = 0;
		for (int i = 0; i < brr.size(); i = i + count) {
			count = 0;
			temp = 0;
			for (int j = 0; j < brr.size(); j++) {
				if (brr.get(i) == brr.get(j)) {
					count = count + 1;
				}
			}
			for (int b = 0; b < arr.size(); b++) {
				if (brr.get(i) == arr.get(b)) {
					temp = temp + 1;
				}
			}
			if ((count - temp) != 0) {
				list.add(brr.get(i));
			}

		}
		return list;
	}

	static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
		List<Integer> real = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			real.add(arr.get(i));
		}

		for (int j = 0; j < brr.size(); j++) {
			if (!real.contains(brr.get(j))) {
				if (!list.contains(brr.get(j))) {
					list.add(brr.get(j));
				}
			} else {
				real.remove(brr.get(j));
			}
		}
		Collections.sort(list);
		return list;
	}

	public static long gridlandMetro(int n, int m, int k, List<List<Integer>> track) {
		long total = (long) n * (long) m;

		if (k == 0) {
			return total;
		}
		Collections.sort(track, (a, b) -> {
			if (!a.get(0).equals(b.get(0))) {
				return Integer.compare(a.get(0), b.get(0));
			}
			return Integer.compare(a.get(1), b.get(1));
		});

		List<List<Integer>> mergedTrack = new ArrayList<>();
		mergedTrack.add(track.get(0));

		for (int i = 0; i < track.size(); i++) {
			List<Integer> last = mergedTrack.get(mergedTrack.size() - 1);
			List<Integer> current = track.get(i);

			if (last.get(0).equals(current.get(0)) && last.get(2) >= current.get(1)) {
				last.set(2, Math.max(last.get(2), current.get(1)));
			} else {
				mergedTrack.add(current);
			}
		}

		for (List<Integer> list : mergedTrack) {
			total -= list.get(2) - list.get(1) + 1;
		}
		return total;
	}

}
