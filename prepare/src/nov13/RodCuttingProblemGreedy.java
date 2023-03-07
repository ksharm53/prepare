package nov13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RodCuttingProblemGreedy {

	public static void main(String[] args) {
		int[] price = { 1, 3, 4, 5 };
		int length = 4;

		System.out.println(solve(price, length));
	}

	public static class Pair {
		Double density;
		int index;

		public Double getDensity() {
			return density;
		}

		public void setDensity(Double density) {
			this.density = density;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public Pair(Double density, int index) {
			super();
			this.density = density;
			this.index = index;
		}

	}

	private static int solve(int[] price, int length) {

		List<Pair> densityArray = new ArrayList<>();
		int value = 0;

		for (int i = 0; i < price.length; i++) {
			densityArray.add(new Pair(((double) price[i] / (double) (i + 1)), i));
		}

		Collections.sort(densityArray, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.getDensity() == o1.getDensity() ? o1.getIndex() - o2.getIndex()
						: o2.getDensity().compareTo(o1.getDensity());
			}
		});

		while (length > 0) {
			for (int i = 0; i < densityArray.size(); i++) {
				if (densityArray.get(i).getIndex() + 1 <= length) {
					length -= densityArray.get(i).getIndex() + 1;
					value += price[densityArray.get(i).getIndex()];
					break;
				}
			}
		}
		return value;
	}

}
