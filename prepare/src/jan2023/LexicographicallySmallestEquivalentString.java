package jan2023;

import java.util.HashMap;
import java.util.Map;

public class LexicographicallySmallestEquivalentString {

	public static void main(String[] args) {
		String s1 = "leetcode";
		String s2 = "programs";
		String baseStr = "sourcecode";

		System.out.println(solve(s1, s2, baseStr));

	}

	public static class UnionFind {
		Map<Character, Character> leaderMap;

		public UnionFind(int n) {
			this.leaderMap = new HashMap<>();

			for (int i = 0; i < 26; i++) {
				char each = (char) (i + 97);
				leaderMap.put(each, each);
			}

		}

		public char find(char value) {
			char leader = leaderMap.get(value);
			if (leader != value) {
				char findVal = find(leader);
				leaderMap.put(value, findVal);
				return findVal;
			}
			return leader;
		}

		public void union(char first, char second) {
			char leadFirst = find(first);
			char leadSecond = find(second);

			if (leadFirst <= leadSecond) {
				leaderMap.put(leadSecond, leadFirst);
			} else {
				leaderMap.put(leadFirst, leadSecond);
			}
		}

	}

	private static String solve(String s1, String s2, String baseStr) {
		int length = s1.length();
		UnionFind uf = new UnionFind(length);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < length; i++) {
			uf.union(s1.charAt(i), s2.charAt(i));
		}

		for (int j = 0; j < baseStr.length(); j++) {
			sb.append(uf.find(baseStr.charAt(j)));
		}

		return sb.toString();
	}

}
