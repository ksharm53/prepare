package arrays;

import java.util.Stack;

public class AstroidCollision {

	public static void main(String[] args) {
		int[] array = { -2, -2, 1, -2 };
		System.out.println(solve(array));

	}

	private static int[] solve(int[] array) {
		if (array.length == 0) {
			return new int[] {};
		}
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < array.length; i++) {
			while (true) {
				if (stack.isEmpty() || (stack.peek() < 0 && array[i] < 0) || (stack.peek() > 0 && array[i] > 0)
						|| (stack.peek() < 0 && array[i] > 0)) {
					stack.push(array[i]);
					break;
				} else {

					if (Math.abs(stack.peek()) > Math.abs(array[i])) {
						break;
					} else if (Math.abs(stack.peek()) == Math.abs(array[i])) {
						stack.pop();
						break;
					} else if (Math.abs(stack.peek()) < Math.abs(array[i])) {
						stack.pop();
					}
				}

			}
		}
		int[] result = new int[stack.size()];
		int counter = stack.size() - 1;
		while (!stack.isEmpty()) {
			result[counter] = stack.pop();
			counter--;
		}
		return result;

	}

}
