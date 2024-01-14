package oct2023;

import java.util.Stack;

public class MinimumSteps {

	public static void main(String[] args) {
		String s = "0000111110000000";
		System.out.println(solve(s));

	}

	private static long solve(String s) {

		long oneCounter = 0;
		long count = 0;
		for (int i = 0; i < s.length(); i++) {
			int temp = i;
			char each = s.charAt(i);
			if (each == '0') {
				while (temp + 1 < s.length() && s.charAt(temp + 1) == '0') {
					temp++;
				}
				long diff = temp - i + 1;

				count += diff * oneCounter;
				i = temp;
			} else {
				oneCounter++;
			}
		}
		return count;
	}

}
