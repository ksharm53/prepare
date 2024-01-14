package dec;

import java.util.HashMap;
import java.util.Map;

public class ConvertToTitle {
	static Map<Integer, Character> map;

	public static void main(String[] args) {
		int columnNumber = 707;
		map = new HashMap<>();
		map.put(1, 'A');
		map.put(2, 'B');
		map.put(3, 'C');
		map.put(4, 'D');
		map.put(5, 'E');
		map.put(6, 'F');
		map.put(7, 'G');
		map.put(8, 'H');
		map.put(9, 'I');
		map.put(10, 'J');
		map.put(11, 'K');
		map.put(12, 'L');
		map.put(13, 'M');
		map.put(14, 'N');
		map.put(15, 'O');
		map.put(16, 'P');
		map.put(17, 'Q');
		map.put(18, 'R');
		map.put(19, 'S');
		map.put(20, 'T');
		map.put(21, 'U');
		map.put(22, 'V');
		map.put(23, 'W');
		map.put(24, 'X');
		map.put(25, 'Y');
		map.put(26, 'Z');

		System.out.println(solve(columnNumber));

	}

	private static StringBuilder solve(int columnNumber) {
		StringBuilder sb = new StringBuilder();
		if (columnNumber <= 26) {
			sb.append(map.get(columnNumber));
			return sb;
		}

		int ques = columnNumber / 26;
		int rem = columnNumber % 26;
		if (rem == 0) {
			ques--;
			rem = 26;
		}
		sb = solve(ques);
		sb.append(map.get(rem));

		return sb;
	}

}
