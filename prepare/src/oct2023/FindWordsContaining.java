package oct2023;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContaining {

	public static void main(String[] args) {
		String[] words = { "leet", "code" };
		char x = 'e';
		System.out.println(solve(words, x));
	}

	private static List<Integer> solve(String[] words, char x) {
		List<Integer> idx = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].contains(String.valueOf(x))) {
				idx.add(i);
			}
		}
		return idx;
	}

}
