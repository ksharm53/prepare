package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {

	static List<String> output = new ArrayList<>();

	public static void main(String[] args) {
		String s = "C";
		String op = "";
		output = new ArrayList<>();

		solve(s, op);
		System.out.println(output);
	}

	private static void solve(String s, String op) {

		if (s.length() == 0) {
			output.add(op);
			return;
		}
		
		if(Character.isAlphabetic(s.charAt(0))) {
			StringBuilder op1= new StringBuilder(op);
			StringBuilder op2= new StringBuilder(op);
			
			op1.append(Character.toLowerCase(s.charAt(0)));
			op2.append(Character.toUpperCase(s.charAt(0)));
			
			String temp=new StringBuilder(s).deleteCharAt(0).toString();
			
			solve(temp, op1.toString());
			solve(temp, op2.toString());
		}
		else {
			StringBuilder op1= new StringBuilder(op);
			op1.append(s.charAt(0));
			String temp=new StringBuilder(s).deleteCharAt(0).toString();
			solve(temp, op1.toString());
		}
		

	}

}
