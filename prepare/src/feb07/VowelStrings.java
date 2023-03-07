package feb07;

import java.util.List;

public class VowelStrings {

	public static void main(String[] args) {
		String[] words = { "aba", "bcb", "ece", "aa", "e" };
		int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };

		System.out.println(vowelStrings(words, queries));

	}

	public static int[] vowelStrings(String[] words, int[][] queries) {
		int[] prefixData = new int[words.length + 1];
		int[] res = new int[queries.length];
		int runningCount = 0;
		List<Character> list = List.of('a', 'e', 'i', 'o', 'u');
		for (int i = 0; i < words.length; i++) {
			String each = words[i];
			if (list.contains(each.charAt(0)) && list.contains(each.charAt(each.length() - 1))) {
				runningCount++;
			}
			prefixData[i + 1] = runningCount;
		}

		for (int i = 0; i < queries.length; i++) {
			int start = queries[i][0];
			int end = queries[i][1];
			res[i] = prefixData[end + 1] - prefixData[start];
		}

		return res;
	}

}
