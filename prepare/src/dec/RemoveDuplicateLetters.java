package dec;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "cbacdcbc";
		System.out.println(solve(s));
	}

	private static String solve(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
				continue;
			}
			if (!stack.isEmpty() && stack.peek() >= s.charAt(i)) {
				while (!stack.isEmpty() && stack.peek() > s.charAt(i) && map.get(stack.peek()) > 1) {
					map.put(stack.peek(), map.get(stack.peek()) - 1);
					set.remove(stack.peek());
					stack.pop();
				}
			}

			stack.add(s.charAt(i));
			set.add(s.charAt(i));
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.insert(0, stack.pop());
		}
		return sb.toString();
	}

}
