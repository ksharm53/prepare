package oct3;

import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		Stack<Character> stack = new Stack<>();
		StringBuilder result = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			if (!stack.isEmpty() && s.charAt(i) == ']') {
				StringBuilder sb = new StringBuilder();
				while (!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
					sb.append(stack.pop());
				}
				sb.reverse();
				stack.pop();
				StringBuilder sbDigit = new StringBuilder();
				while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
					sbDigit.append(stack.pop());
				}
				sbDigit.reverse();
				int val = Integer.valueOf(sbDigit.toString());
				StringBuilder again = new StringBuilder();
				while (val > 0) {
					again.append(sb.toString());
					val--;
				}

				for (int m = 0; m < again.length(); m++) {
					stack.push(again.charAt(m));
				}
			} else
				stack.add(s.charAt(i));
		}

		while (!stack.isEmpty()) {
			result.append(stack.pop());
		}
		result.reverse();
		return result.toString();
	}

}
