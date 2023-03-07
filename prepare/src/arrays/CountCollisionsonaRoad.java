package arrays;

import java.util.Stack;

public class CountCollisionsonaRoad {

	public static void main(String[] args) {
		String directions = "SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR";
		System.out.println(solve(directions));
	}

	public static int solve(String directions) {
		int counter = 0;
		if (directions.length() < 2) {
			return 0;
		}

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < directions.length(); i++) {
			char current = directions.charAt(i);

			if (current == 'L') {
				if (!stack.isEmpty()) {
					char stackTop = stack.pop();
					if (stackTop == 'R') {
						counter += 2;
						stack.add('S');
					} else if (stackTop == 'S') {
						counter++;
						stack.add('S');
					}
				}
			} else if (current == 'S') {
				if (!stack.isEmpty() && stack.peek() == 'R') {
					stack.pop();
					counter++;
					stack.add('S');
				} else {
					stack.add('S');
				}
			} else if (current == 'R') {
				stack.add(current);
			}

			if (!stack.isEmpty() && stack.peek() == 'S') {
				char temp = stack.pop();
				while (!stack.isEmpty() && stack.peek() == 'R') {
					counter++;
					stack.pop();
				}
				stack.add(temp);

			}
		}
		return counter;
	}

}
