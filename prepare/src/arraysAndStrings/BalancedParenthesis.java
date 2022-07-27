package arraysAndStrings;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		String s = "{{[[(())]]}}";
		System.out.println(solve(s));
	}

	private static String solve(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char each = s.charAt(i);
			if (stack.size() == 0 && (each == '}' || each == ')' || each == ']')) {
				return "NO";
			}

			if (each == '{' || each == '(' || each == '[') {
				stack.push(each);
			} else {
				if ((each == '}' && stack.peek()=='{') || (each == ')' && stack.peek()=='(') || (each == ']' && stack.peek()=='[')) {
					stack.pop();
				} else {
					return "NO";
				}
			}

		}
		return stack.size() > 0 ? "NO" : "YES";
	}

}
