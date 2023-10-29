package may1;

import java.util.List;

public class MaxVowels {

	static List<Character> list;

	public static void main(String[] args) {
		String s = "leetcode";
		int k = 3;

		list = List.of('a', 'e', 'i', 'o', 'u');

		System.out.println(solve(s, k));

	}

	private static int solve(String s, int k) {
		int i = 0;
		int j = 0;
		int max = Integer.MIN_VALUE;
		int count = 0;

		while (j < s.length()) {
			if (list.contains(s.charAt(j))) {
				count++;
			}

			if (j - i + 1 == k) {
				max = Math.max(max, count);
				if (list.contains(s.charAt(i))) {
					count--;
				}
				i++;
			}

			j++;
		}

		return max;
	}

}
