package june;

import java.util.Arrays;
import java.util.Comparator;

public class MinExtraChar {

	public static void main(String[] args) {
		String s = "rkmsilizktprllwoimafyuqmeqrujxdzgp";
		String[] dictionary = { "afy", "lyso", "ymdt", "uqm", "cfybt", "lwoim", "hdzeg", "th", "rkmsi", "d", "e", "tp",
				"r", "jx", "tofxe", "etjx", "llqs", "cpir", "p", "ncz", "ofeyx", "eqru", "l", "demij", "tjky", "jgodm",
				"y", "ernt", "jfns", "akjtl", "wt", "tk", "zg", "lxoi", "kt" };

		Arrays.sort(dictionary, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.length() - o1.length();
			}
		});

		System.out.println(solve(s, dictionary, 0, s.length()));

	}

	private static int solve(String s, String[] dictionary, int start, int end) {
		if (s.isBlank() || start > end) {
			return 0;
		}
		for (String eachString : dictionary) {
			int idx = s.indexOf(eachString);
			if (idx != -1) {
				String fSubString = s.substring(start, idx);
				String sSubString = s.substring(idx + eachString.length(), end);
				int firstHalf = solve(fSubString, dictionary, 0, fSubString.length());
				int secondHalf = solve(sSubString, dictionary, 0, sSubString.length());
				return firstHalf + secondHalf;
			}
		}

		return s.length();
	}

}
