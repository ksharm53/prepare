package may1;

import java.util.Stack;

public class MinLength {

	public static void main(String[] args) {
		String s = "ABFCACDB";
		System.out.println(solve(s));

	}

	public static int solve(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty()) {
				if ((stack.peek() == 'A' && s.charAt(i) == 'B') || (stack.peek() == 'C' && s.charAt(i) == 'D')) {
					stack.pop();
					continue;
				}
			}
			stack.push(s.charAt(i));
		}
		return stack.size();
	}

}
