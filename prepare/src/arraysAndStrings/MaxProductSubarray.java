package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class MaxProductSubarray {

	public static void main(String[] args) {
		List<Integer> A = new ArrayList<>();
		A.add(-2);
		A.add(3);
		A.add(1);
		A.add(4);

		System.out.println(solve(A));

	}

	private static int solve(List<Integer> a) {

		int maxProduct = a.get(0);
		int tempStore = 1;
		int tempStoreActual = 1;
		boolean negativeCounter = false;

		if (a.size() == 0) {
			return -1;
		}

		int i = 0;
		int j = 1;

		while (j < a.size()) {
			int currentProduct = maxProduct * a.get(j);

			if (maxProduct <= currentProduct) {
				maxProduct = currentProduct;
				j++;
				continue;
			} else if (maxProduct > currentProduct) {
				if(a.get(j) ==0) {
					tempStore = currentProduct;
					tempStoreActual = maxProduct;
					negativeCounter = true;
					i = j + 1;
					maxProduct = 1;
				}
				if (negativeCounter) {
					negativeCounter = false;
					maxProduct = currentProduct * tempStore;
				} else {
					tempStore = currentProduct;
					tempStoreActual = maxProduct;
					negativeCounter = true;
					i = j + 1;
					maxProduct = 1;
				}
				j++;
			}
		}
		return Math.max(tempStoreActual, maxProduct);
	}

}
