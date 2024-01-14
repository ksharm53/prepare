package oct2023;

import java.util.ArrayList;
import java.util.List;

public class FindPeaks {

	public static void main(String[] args) {
		int[] mountain = { 1, 4, 3, 8, 5 };
		System.out.println(solve(mountain));

	}

	private static List<Integer> solve(int[] mountain) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < mountain.length; i++) {
			if (i == 0 || i == mountain.length - 1) {
				continue;
			}

			if (mountain[i - 1] < mountain[i] && mountain[i] > mountain[i + 1]) {
				list.add(i);
			}
		}
		return list;
	}

}
