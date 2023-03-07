package jan2023;

import java.util.HashSet;
import java.util.Set;

public class RestoreIpAddresses {

	public static Set<String> set;

	public static void main(String[] args) {
		String s = "25525511135";
		set = new HashSet<>();
		solve(new StringBuilder(s), "");
		System.out.println(set);

	}

	private static void solve(StringBuilder input, String output) {
		if (input.length() == 0) {
			set.add(output);
			return;
		}
		StringBuilder op1 = new StringBuilder(output);
		StringBuilder op2 = new StringBuilder(output);
		if (!op2.isEmpty()) {
			int count = 0;
			for (int i = 0; i < op2.length(); i++) {
				if (op2.charAt(i) == '.') {
					count++;
				}
			}
			if (count < 3) {
				op2.append('.');
			}

		}
		char ip = input.charAt(0);

		if (op1.isEmpty() || op1.charAt(op1.length() - 1) == '.') {
			op1.append(ip);
		} else {
			if (op1.toString().contains(".")) {
				if (Integer.valueOf(op1.substring(op1.lastIndexOf(".") + 1, op1.length()) + ip) <= 255) {
					op1.append(ip);
				} else {
					op1.append(".");
					op1.append(ip);
				}
			} else {
				if (Integer.valueOf(op1.substring(0, op1.length()) + ip) <= 255) {
					op1.append(ip);
				} else {
					op1.append(".");
					op1.append(ip);
				}
			}
		}

		input.deleteCharAt(0);
		solve(input, op1.toString());
		// input.insert(0, ip);
		op2.append(ip);
		solve(input, op2.toString());
	}

}
