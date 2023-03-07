package mar01;

import java.util.Stack;

public class MinInsertions {

	public static void main(String[] args) {
		String s = "(((()(()((())))(((()())))()())))(((()(()()((()()))";
		System.out.println(minInsertions(s));

	}

	public static int minInsertions(String s) {
		int count = 0;
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ')') {
				if (stack.isEmpty()) {
					count++;
					stack.add(1);
				} else if (!stack.isEmpty() && stack.peek() == 1) {
					stack.pop();
				} else if (!stack.isEmpty() && stack.peek() == 2) {
					stack.pop();
					stack.push(1);
				}
			} else {
				if (stack.isEmpty()) {
					stack.add(2);
				} else if (!stack.isEmpty() && stack.peek() == 1) {
					count++;
					stack.pop();
					stack.add(2);
				} else if (!stack.isEmpty() && stack.peek() == 2) {
					stack.add(2);
				}
			}

		}

		while (!stack.isEmpty()) {
			count += stack.pop();
		}

		return count;
	}

}
