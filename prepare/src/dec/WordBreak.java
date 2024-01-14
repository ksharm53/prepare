package dec;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
	static List<String> finalList;

	public static void main(String[] args) {
		String s = "pineapplepenapple";
		List<String> wordDict = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
		finalList = new ArrayList<>();
		solve(s, wordDict, new ArrayList<String>());
		System.out.println(finalList);
	}

	private static void solve(String s, List<String> wordDict, List<String> innerList) {
		if (s.length() == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < innerList.size(); i++) {
				sb.append(innerList.get(i));
				if (i != innerList.size() - 1) {
					sb.append(" ");
				}

			}
			finalList.add(sb.toString());
			if (innerList.size() > 0) {
				innerList.remove(innerList.size() - 1);
			}
			return;
		}

		for (int i = 0; i < wordDict.size(); i++) {
			String each = wordDict.get(i);
			if (s.startsWith(each)) {
				innerList.add(each);
				solve(s.substring(each.length(), s.length()), wordDict, innerList);
			}
		}
		if (innerList.size() > 0) {
			innerList.remove(innerList.size() - 1);
		}
	}

}
