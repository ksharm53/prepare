package july;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class SortVowels {

	static Set<Character> set;

	public static void main(String[] args) {
		String s = "lYmpH";
		set = new HashSet<>();
		set.add('a');
		set.add('e');
		set.add('i');
		set.add('o');
		set.add('u');

		System.out.println(solve(s));

	}

	private static String solve(String s) {
		PriorityQueue<Character> pq = new PriorityQueue<>();
		for (char eachChar : s.toCharArray()) {
			if (set.contains(Character.toLowerCase(eachChar))) {
				pq.add(eachChar);
			}
		}

		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < sb.length(); i++) {
			if (set.contains(Character.toLowerCase(sb.charAt(i)))) {
				char ch = pq.poll();
				sb.deleteCharAt(i);
				sb.insert(i, ch);
			}
		}

		return sb.toString();
	}

}
