package postNoon;

import java.util.ArrayList;
import java.util.List;

public class FindMaxProducts {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		li.add(7);
		li.add(4);
		li.add(5);
		li.add(2);
		li.add(6);
		li.add(5);
		System.out.println(findMaxProducts(li));
	}

	public static long findMaxProducts(List<Integer> products) {
		int l = products.size();
		long max = 0;
		for (int i = l - 1; i >= 0; --i) {
			if (i != l - 1 && products.get(i) < products.get(i + 1))
				continue;
			int localMax = products.get(i);
			int prev = localMax;
			for (int j = i - 1; j >= 0; --j) {
				prev = Math.min(prev - 1, products.get(j));
				localMax += prev;
				if (prev == 1)
					break;
			}
			max = Math.max(localMax, max);
		}
		return max;
	}

}
