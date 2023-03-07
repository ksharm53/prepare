package august23;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class SmallestSubsequenceofDistinctCharacters {

	public static void main(String[] args) {
		String s = "bbcaac";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Stack<Character> stack = new Stack<>();
		Set<Character> set = new HashSet<>();

		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (set.contains(curr)) {
				map.put(curr, map.getOrDefault(curr, 0) - 1);
				continue;
			}
			while (!stack.isEmpty() && stack.peek() > curr && map.get(stack.peek()) > 1) {
				char poppedElement = stack.pop();
				set.remove(poppedElement);
				map.put(poppedElement, map.getOrDefault(poppedElement, 0) - 1);
			}
			stack.push(curr);
			set.add(curr);
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();

	}

}
