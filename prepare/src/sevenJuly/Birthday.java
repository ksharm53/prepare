package sevenJuly;

import java.util.Arrays;
import java.util.List;

public class Birthday {

	public static void main(String[] args) {
		List<Integer> s = Arrays.asList(1, 2, 1, 3, 2);
		int d = 3;
		int m = 2;
		System.out.println(birthday(s, d, m));
	}

	public static int birthday(List<Integer> s, int d, int m) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int counter = 0;
		while (j < s.size()) {
			sum = sum + s.get(j);
			if (j - i + 1 < m) {
				j++;
			}
			else if (j - i + 1 == m) {
				if (sum == d) {
					counter++;
				}
				sum = sum - s.get(i);
				i++;
				j++;
			}
		}
		return counter;
	}

}
