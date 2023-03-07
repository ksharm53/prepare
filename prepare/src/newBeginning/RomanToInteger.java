package newBeginning;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	static Map<Character, Integer> map;

	public static void main(String[] args) {
		String s = "MCMXCIV";
		map = new HashMap<>();

		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		System.out.println(solve(s));

	}

	private static int solve(String s) {
		int total = 0;
		s = s.replace("IV", "IIII");
		s = s.replace("IX", "VIIII");
		s = s.replace("XL", "XXXX");
		s = s.replace("XC", "LXXXX");
		s = s.replace("CD", "CCCC");
		s = s.replace("CM", "DCCCC");

		for (char eachChar : s.toCharArray()) {
			total += map.get(eachChar);
		}
		return total;
	}

}
