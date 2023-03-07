package Sept23;

import java.util.HashMap;
import java.util.Map;

public class SatisfiabilityofEqualityEquations {

	public static class UnionFind {

		Map<Character, Character> isParent;
		Map<Character, Integer> rankMap;
		int totalSets;

		public UnionFind() {
			isParent = new HashMap<>();
			rankMap = new HashMap<>();
			totalSets = 0;

			for (char i = 'a'; i <= 'z'; ++i) {
				isParent.put(i, i);
				rankMap.put(i, 1);
				totalSets++;
			}
		}

		private Character find(char value) {
			Character findings = isParent.get(value);
			if (!findings.equals(value)) {
				char leader = find(isParent.get(value));
				isParent.put(value, leader);
				return leader;
			}
			return value;
		}

		private void union(Character a, Character b) {
			char repreA = this.find(a);
			char repreB = this.find(b);

			if (repreA == repreB) {
				return;
			} else {
				if (rankMap.get(repreA) > rankMap.get(repreB)) {
					isParent.put(repreB, repreA);
					int rankA = rankMap.get(repreA) + rankMap.get(repreB);
					rankMap.put(repreA, rankA);
				} else {
					isParent.put(repreA, repreB);
					int rankB = rankMap.get(repreA) + rankMap.get(repreB);
					rankMap.put(repreB, rankB);
				}
				totalSets--;
			}
		}

		private boolean validateConnection(Character a, Character b) {
			char parentA = this.find(a);
			char parentB = this.find(b);
			return parentA == parentB ? true : false;
		}

	}

	public static void main(String[] args) {
		String[] equations = { "c==c", "b==d", "x!=z" };

		System.out.println(solve(equations));

	}

	private static boolean solve(String[] equations) {
		UnionFind uf = new UnionFind();
		for (String eachString : equations) {
			char first = eachString.charAt(0);
			char second = eachString.charAt(3);
			if (eachString.substring(1, 3).equals("==")) {
				uf.union(first, second);
			}
		}

		for (String eachString : equations) {
			char first = eachString.charAt(0);
			char second = eachString.charAt(3);
			if (eachString.substring(1, 3).equals("!=")) {
				if (first == second) {
					return false;
				}
				if (uf.validateConnection(first, second)) {
					return false;
				}
			}
		}
		return true;
	}

}
