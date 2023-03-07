package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class RemoveDuplicateLetters {

	public static void main(String[] args) {
		String s = "cbacdcbc";
		System.out.println(solve(s));

	}

	private static String solve(String s) {
		
		Map<Character, Integer> map = new TreeMap<>();
		StringBuilder sb = new StringBuilder(s);
		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}

		int[] nle = nle(s.toCharArray());
		List<Integer> list = new ArrayList<>();

		for (Map.Entry<Character, Integer> eachEntry : map.entrySet()) {
			char key = eachEntry.getKey();
			if (eachEntry.getValue() > 1) {
				int index = sb.indexOf(String.valueOf(key));
				while (eachEntry.getValue() > 1) {
					if (nle[index] == -1) {
						list.add(index);
						for (int i = 0; i < nle.length; i++) {
							if (nle[i] == index) {
								nle[i] = -1;
							}
						}
						map.put(key, map.getOrDefault(key, 0) - 1);
					}
					index = sb.indexOf(String.valueOf(key), index + 1);
					if (index == -1) {
						break;
					}
				}
			}
		}

		StringBuilder sb1 = new StringBuilder();

		for (int i = 0; i < sb.length(); i++) {
			if (!list.contains(i)) {
				sb1.append(sb.charAt(i));
			}
		}
		return sb1.toString();
	}

	private static int[] nle(char[] charArray) {
		int[] result = new int[charArray.length];
		Stack<int[]> stack = new Stack<>();
		for (int i = 0; i < charArray.length; i++) {
			if (stack.isEmpty()) {
				result[i] = -1;
			} else if (stack.peek()[1] < Character.getNumericValue(charArray[i])) {
				result[i] = stack.peek()[0];
			} else if (stack.peek()[1] >= Character.getNumericValue(charArray[i])) {
				while (!stack.isEmpty() && stack.peek()[1] >= Character.getNumericValue(charArray[i])) {
					stack.pop();
				}
				if (stack.isEmpty()) {
					result[i] = -1;
				} else if (stack.peek()[1] < Character.getNumericValue(charArray[i])) {
					result[i] = stack.peek()[0];
				}
			}
			stack.add(new int[] { i, Character.getNumericValue(charArray[i]) });
		}
		return result;
	}

}
