package mar01;

import java.util.Stack;

public class FindTheLongestBalancedSubstring {

	public static void main(String[] args) {
		String s = "01011";
		System.out.println(findTheLongestBalancedSubstring(s));

	}

	public static int findTheLongestBalancedSubstring(String s) {

		int max = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {

			if (!stack.isEmpty() && s.charAt(i) == '1' && stack.peek() == '0') {
				int counter = 0;
				int temp = i;
				while (temp < s.length() && s.charAt(temp) == '1') {
					temp++;
				}

				int count = temp - i;
				while (!stack.isEmpty() && stack.peek() == '0') {
					counter++;
					stack.pop();
				}

				int tempMax = Math.min(count, counter);
				max = Math.max(max, tempMax * 2);

				i = temp - 1;
			} else {
				stack.push(s.charAt(i));
			}
		}

		return max;
	}

}
