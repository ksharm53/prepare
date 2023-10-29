package mar01;

import java.util.Stack;

public class MinRemoveToMakeValid {

	public static void main(String[] args) {
		String s = "))((";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		StringBuilder sb = new StringBuilder();
		int offset = 0;
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			boolean flag = true;
			if (s.charAt(i) == '(') {
				stack.add(new int[] { 0, i });
				flag = false;
				offset++;
			} else if (s.charAt(i) == ')') {
				if (!stack.isEmpty()) {
					offset--;
					int[] val = stack.pop();
					sb.insert(val[1] - offset, '(');
				} else {
					flag = false;
					offset++;
				}
			}
			if (flag) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
