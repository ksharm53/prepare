package dec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class ReorganizeString {

	public static void main(String[] args) {
		String s = "bbbbbbaab";
		System.out.println(solve(s));

	}

	public static class Node {
		char eachChar;
		int count;

		public Node(char eachChar, int count) {
			this.eachChar = eachChar;
			this.count = count;
		}

	}

	private static String solve(String s) {
		List<Node> list = new ArrayList<>();

		Map<Character, Integer> map = new HashMap<>();
		for (char eachChar : s.toCharArray()) {
			map.put(eachChar, map.getOrDefault(eachChar, 0) + 1);
		}

		for (Entry<Character, Integer> eachEntry : map.entrySet()) {
			list.add(new Node(eachEntry.getKey(), eachEntry.getValue()));
		}

		Collections.sort(list, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				return o2.count - o1.count;
			}
		});

		StringBuilder sb = new StringBuilder();
		int low = 0;
		int high = list.size() - 1;
		boolean flag = true; // low false high true
		while (low <= high) {
			if (flag) {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == list.get(low).eachChar) {
					return "";
				}
				sb.append(list.get(low).eachChar);
				list.get(low).count--;
				if (list.get(low).count == 0) {
					low++;
				}
			} else {
				if (sb.length() > 0 && sb.charAt(sb.length() - 1) == list.get(high).eachChar) {
					return "";
				}
				sb.append(list.get(high).eachChar);
				list.get(high).count--;
				if (list.get(high).count == 0) {
					high--;
				}

			}
			flag = !flag;
		}

		return sb.length() == s.length() ? sb.toString() : "";
	}

}
