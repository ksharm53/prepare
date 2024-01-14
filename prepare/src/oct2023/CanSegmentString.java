package oct2023;

import java.util.HashSet;
import java.util.Set;

public class CanSegmentString {

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<String>();
		String s = new String();
		s = "applepie";

		dictionary.add("apple");
		dictionary.add("pear");
		dictionary.add("pier");
		dictionary.add("pie");
		if (canSegmentString(s, dictionary)) {
			System.out.println("String Can be Segmented");
		} else {
			System.out.println("String Can NOT be Segmented");
		}
	}

	private static boolean canSegmentString(String s, Set<String> dictionary) {
		if (s.isEmpty()) {
			return true;
		}

		for (String each : dictionary) {
			if (s.contains(each)) {
				int idx = s.indexOf(each);
				String next = s.substring(0, idx) + s.substring(idx + each.length(), s.length());
				return canSegmentString(next, dictionary);
			}
		}

		return false;
	}

}
