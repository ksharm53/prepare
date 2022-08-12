package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

	static List<String> output = new ArrayList<>();

	public static void main(String[] args) {
		int n = 6;

		int open = n;
		int close = n;
		String op = "";
		output = new ArrayList<>();

		solve(open, close, op);
		System.out.println(output);

	}

	private static void solve(int open, int close, String op) {

		if (open == 0 && close == 0) {
			output.add(op);
			return;
		}

		else if (open == close) {
			StringBuilder op1 = new StringBuilder(op);

			op1.append("(");
			open--;
			solve(open, close, op1.toString());
		} else if (open == 0) {
			StringBuilder op1 = new StringBuilder(op);

			op1.append(")");
			close--;
			solve(open, close, op1.toString());
		}

		else if (close == 0) {
			StringBuilder op1 = new StringBuilder(op);

			op1.append("(");
			open--;
			solve(open, close, op1.toString());
		}
		else {
			StringBuilder op1 = new StringBuilder(op);
			StringBuilder op2 = new StringBuilder(op);

			op1.append("(");
			op2.append(")");
			
			int tempOpen= open - 1;
			int tempClose= close - 1;

			solve(tempOpen, close, op1.toString());
			solve(open, tempClose, op2.toString());
		}

	}

}
