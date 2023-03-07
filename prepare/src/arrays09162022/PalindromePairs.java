package arrays09162022;

import java.util.ArrayList;
import java.util.List;

public class PalindromePairs {

	public static void main(String[] args) {
		String[] words = {"a",""};
		System.out.println(solve(words));
	}

	private static List<List<Integer>> solve(String[] words) {
		List<List<Integer>> list = new ArrayList<>();

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append(words[i]);
				sb.append(words[j]);

				if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
					list.add(new ArrayList<>(List.of(i, j)));
				}

				sb = new StringBuilder();
				sb.append(words[j]);
				sb.append(words[i]);

				if (sb.toString().equalsIgnoreCase(sb.reverse().toString())) {
					list.add(new ArrayList<>(List.of(j, i)));
				}
			}
		}
		return list;
	}

}
