package dec;

import java.util.Stack;

public class AsteroidCollision {

	public static void main(String[] args) {
		int[] asteroids = { -2, -1, 1, 2 };
		System.out.println(solve(asteroids));
	}

	private static int[] solve(int[] asteroids) {
		Stack<Integer> stack = new Stack<>();
		upar: for (int i = 0; i < asteroids.length; i++) {
			while ((!stack.isEmpty() && stack.peek() > 0 && asteroids[i] < 0)) {
				if (Math.abs(stack.peek()) < Math.abs(asteroids[i])) {
					stack.pop();
				} else if (Math.abs(stack.peek()) == Math.abs(asteroids[i])) {
					stack.pop();
					continue upar;
				} else {
					continue upar;
				}
			}
			stack.add(asteroids[i]);
		}
		int[] arr = new int[stack.size()];
		int pointer = arr.length - 1;
		while (!stack.isEmpty()) {
			arr[pointer] = stack.pop();
			pointer--;
		}

		return arr;
	}

}
