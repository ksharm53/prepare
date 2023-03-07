package Oct21;

import java.util.Stack;

public class MakeTheStringGreat {

	public static void main(String[] args) {
		String s = "leEeetcode";
		System.out.println(solve(s));
	}

	private static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			boolean flag = true;
			if (!stack.isEmpty()) {
				if (Character.toLowerCase(stack.peek()) == Character.toLowerCase(s.charAt(i))) {
					if ((Character.isUpperCase(stack.peek()) && Character.isLowerCase(s.charAt(i)))
							|| (Character.isLowerCase(stack.peek()) && Character.isUpperCase(s.charAt(i)))) {
						stack.pop();
						flag = false;
					}
				}
			}
			if (flag) {
				stack.add(s.charAt(i));
			}

		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		sb.reverse();
		return sb.toString();
	}

}
