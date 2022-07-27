package arraysAndStrings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Candy {

	public static void main(String[] args) {
		int[] ratings = { 1, 2, 87, 87, 87, 2, 1 };

		System.out.println(solve(ratings));

		System.out.println(solveCopied(ratings));

	}

	private static int solveCopied(int[] ratings) {

		int[] candies = new int[ratings.length];
		Arrays.fill(candies, 1);
		boolean hasChanged = true;
		while (hasChanged) {
			hasChanged = false;
			for (int i = 0; i < ratings.length; i++) {
				if (i != ratings.length - 1 && ratings[i] > ratings[i + 1] && candies[i] <= candies[i + 1]) {
					candies[i] = candies[i + 1] + 1;
					hasChanged = true;
				}
				if (i > 0 && ratings[i] > ratings[i - 1] && candies[i] <= candies[i - 1]) {
					candies[i] = candies[i - 1] + 1;
					hasChanged = true;
				}
			}
		}
		int sum = 0;
		for (int candy : candies) {
			sum += candy;
		}
		return sum;
	}

	private static int solve(int[] ratings) {
		int[] candy = new int[ratings.length];

		Arrays.fill(candy, 1);
		boolean hasChanged = true;
		while (hasChanged) {
			hasChanged = false;
			for (int idx = 0; idx < ratings.length; idx++) {

				if (idx + 1 < ratings.length && ratings[idx] > ratings[idx + 1] && candy[idx] <= candy[idx + 1]) {
					candy[idx] = candy[idx + 1] + 1;
					hasChanged = true;
				}

				if (idx - 1 >= 0 && ratings[idx] > ratings[idx - 1] && candy[idx] <= candy[idx - 1]) {
					candy[idx] = candy[idx - 1] + 1;
					hasChanged = true;
				}
			}
		}

		return IntStream.of(candy).sum();
	}

}
