package Apr1;

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		int[] pushed = { 1, 2, 3, 4, 5 };
		int[] popped = { 4, 3, 5, 2, 1 };
		System.out.println(solve(pushed, popped));
	}

	private static boolean solve(int[] pushed, int[] popped) {
		Stack<Integer> stack = new Stack<>();
		if (pushed.length != popped.length) {
			return false;
		}

		int idx = 0;

		for (int i = 0; i < pushed.length; i++) {

			stack.push(pushed[i]);

			while (!stack.isEmpty() && stack.peek() == popped[idx]) {
				stack.pop();
				idx++;
			}

		}
		return stack.isEmpty();
	}

}
