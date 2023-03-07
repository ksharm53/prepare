package feb07;

import java.util.ArrayList;
import java.util.Stack;

public class Calculate {

	public static void main(String[] args) {
		String s = "1+2*5/3+6/4*2";
		System.out.println(solve(s));

	}

	private static int solve(String s) {
		StringBuilder sb = new StringBuilder(s);
		while (sb.indexOf("/") != -1 || sb.indexOf("*") != -1) {
			int divIdx = sb.indexOf("/");
			int mulIdx = sb.indexOf("*");

			if (divIdx != -1 && mulIdx != -1) {
				if (divIdx < mulIdx) {
					doDivide(sb);
				} else {
					doMultiply(sb);
				}
			} else if (divIdx == -1) {
				doMultiply(sb);

			} else if (mulIdx == -1) {
				doDivide(sb);
			}

		}
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < sb.length(); i++) {
			char each = sb.charAt(i);
			if (Character.isDigit(each)) {
				int temp = i;
				while (i < sb.length() && Character.isDigit(sb.charAt(i))) {
					i++;
				}
				stack.push(Integer.valueOf(sb.substring(temp, i)));
				i--;
			} else if (each == ' ') {
				continue;
			} else {
				if (each == '+') {
					int left = stack.pop();
					int start = i + 1;
					int temp = start;
					while (start < sb.length() && (Character.isDigit(sb.charAt(start)) || sb.charAt(start) == ' ')) {
						start++;
					}
					int right = Integer.valueOf(sb.substring(temp, start).trim());
					stack.push(left + right);
					i = start - 1;
				} else if (each == '-') {
					int left = stack.pop();
					int start = i + 1;
					int temp = start;
					while (start < sb.length() && (Character.isDigit(sb.charAt(start)) || sb.charAt(start) == ' ')) {
						start++;
					}
					int right = Integer.valueOf(sb.substring(temp, start).trim());
					stack.push(left - right);
					i = start - 1;
				}
			}
		}

		return stack.pop();
	}

	private static void doMultiply(StringBuilder sb) {
		int idxMul = sb.indexOf("*");
		int tempMul = idxMul;
		int leftMul = -1;
		int rightMul = -1;
		while (tempMul - 1 >= 0 && (sb.charAt(tempMul - 1) == ' ' || Character.isDigit(sb.charAt(tempMul - 1)))) {
			tempMul--;
			leftMul = tempMul;
		}
		tempMul = idxMul;
		while (tempMul + 1 < sb.length()
				&& (sb.charAt(tempMul + 1) == ' ' || Character.isDigit(sb.charAt(tempMul + 1)))) {
			tempMul++;
			rightMul = tempMul;
		}
		int firstMul = Integer.valueOf(sb.substring(leftMul, idxMul).trim());
		int secondMul = Integer.valueOf(sb.substring(idxMul + 1, rightMul + 1).trim());
		int calMul = firstMul * secondMul;
		sb.replace(leftMul, rightMul + 1, String.valueOf(calMul));

	}

	private static void doDivide(StringBuilder sb) {
		int idx = sb.indexOf("/");
		int temp = idx;
		int left = -1;
		int right = -1;
		while (temp - 1 >= 0 && (sb.charAt(temp - 1) == ' ' || Character.isDigit(sb.charAt(temp - 1)))) {
			temp--;
			left = temp;
		}
		temp = idx;
		while (temp + 1 < sb.length() && (sb.charAt(temp + 1) == ' ' || Character.isDigit(sb.charAt(temp + 1)))) {
			temp++;
			right = temp;
		}
		int first = Integer.valueOf(sb.substring(left, idx).trim());
		int second = Integer.valueOf(sb.substring(idx + 1, right + 1).trim());
		int cal = first / second;
		sb.replace(left, right + 1, String.valueOf(cal));

	}

}
