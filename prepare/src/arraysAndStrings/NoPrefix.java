package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class NoPrefix {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("aab", "aac", "aacghgh", "aabghgh");
		solve(words);
		solveAgain(words);
	}

	private static void solve(List<String> words) {
		TreeSet<String> set = new TreeSet<>();

		for (String each : words) {
			String next = set.ceiling(each);
			String prev = set.floor(each);
			if ((next != null && next.startsWith(each)) || (prev != null && each.startsWith(prev))) {
				System.out.println("BAD SET");
				System.out.println(each);
				return;
			}
			set.add(each);
		}
		System.out.println("GOOD SET");
	}

	private static void solveAgain(List<String> words) {

		Set<String> done = new HashSet<>();
		done.add(words.get(0));
		for (int j = 1; j < words.size(); j++) {
			String string = words.get(j);
			for (int k = 0; k < done.size(); k++) {
				Iterator<String> it = done.iterator();
				if (it.hasNext()) {
					String doneString = it.next();
					if (doneString.startsWith(string)) {
						System.out.println("BAD SET");
						System.out.println(string);
						return;
					}
				}
			}
			for (int i = string.length() - 1; i >= 0; i--) {
				if (done.contains(string.substring(0, i))) {
					System.out.println("BAD SET");
					System.out.println(string);
					return;
				}
			}
			done.add(words.get(j));
		}
		System.out.println("GOOD SET");
	}

}
