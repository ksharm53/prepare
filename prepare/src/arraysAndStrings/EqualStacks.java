package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class EqualStacks {

	public static void main(String[] args) {
		List<Integer> h1 = new ArrayList<>();
		h1.add(3);
		h1.add(2);
		h1.add(1);
		h1.add(1);
		h1.add(1);

		List<Integer> h2 = new ArrayList<>();

		h2.add(4);
		h2.add(3);
		h2.add(2);

		List<Integer> h3 = new ArrayList<>();

		h3.add(1);
		h3.add(1);
		h3.add(4);
		h3.add(1);
		System.out.println(equalStacks(h1, h2, h3));
	}

	public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3) {
		int totalH1 = 0;
		int totalH2 = 0;
		int totalH3 = 0;
		int minSize = Math.min(Math.min(h1.size(), h2.size()), h3.size());
		int h1Size = h1.size();
		int h2Size = h2.size();
		int h3Size = h3.size();

		for (Integer integer : h1) {
			totalH1 += integer;
		}

		for (Integer integer : h2) {
			totalH2 += integer;
		}

		for (Integer integer : h3) {
			totalH3 += integer;
		}

		while (!(totalH1 == totalH2 && totalH2 == totalH3)) {

			int max = Math.max(Math.max(totalH1, totalH2), totalH3);

			if (totalH3 == max && h3.size() > 0) {
				totalH3 = totalH3 - h3.get(0);
				h3.remove(0);
			} else if (totalH1 == max && h1.size() > 0) {
				totalH1 = totalH1 - h1.get(0);
				h1.remove(0);
			} else if (totalH2 == max && h2.size() > 0) {
				totalH2 = totalH2 - h2.get(0);
				h2.remove(0);
			}
		}

		if (h1Size == minSize) {
			return totalH1;
		} else if (h2Size == minSize) {
			return totalH2;
		} else if (h3Size == minSize) {
			return totalH3;
		} else
			return 0;

	}

}
