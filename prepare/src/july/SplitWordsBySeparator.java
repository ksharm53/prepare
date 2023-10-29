package july;

import java.util.ArrayList;
import java.util.List;

public class SplitWordsBySeparator {

	public static void main(String[] args) {
		List<String> words = List.of("$easy$", "$problem$");
		char separator = '$';

		System.out.println(solve(words, separator));

	}

	private static List<String> solve(List<String> words, char separator) {
		List<String> list = new ArrayList<>();

		for (String eachString : words) {
			String[] arr = eachString.split("\\" + separator);
			for (String eachInner : arr) {
				if (!eachInner.isBlank() && !eachInner.isEmpty()) {
					list.add(eachInner);
				}

			}
		}

		return list;
	}

}
