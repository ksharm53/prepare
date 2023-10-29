package mar01;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

	public static TrieNode saved;
	public static List<String> ls;

	public static void main(String[] args) throws CloneNotSupportedException {
		List<String> dictionary = new ArrayList<>();
		dictionary.add("cat");
		dictionary.add("bat");
		dictionary.add("rat");
		dictionary.add("catt");

		String sentence = "the cattle was rattled by the battery";

		StringBuilder sb = new StringBuilder();

		saved = new TrieNode();
		ls = new ArrayList<>(dictionary);

		for (String each : dictionary) {
			char[] charArray = each.toCharArray();
			TrieNode root = saved;
			for (int i = 0; i < charArray.length; i++) {

				char eachChar = charArray[i];

				if (!root.isPresent(eachChar)) {
					root.link[eachChar - 'a'] = new TrieNode();
				}
				root = root.getChar(eachChar);
			}
			root.isEnd = true;
		}

		String[] arr = sentence.split(" ");

		for (int i = 0; i < arr.length; i++) {
			String eachString = arr[i];
			String val = found(eachString);
			if (!val.isEmpty()) {
				sb.append(val);
			} else {
				sb.append(eachString);
			}

			if (i != arr.length) {
				sb.append(" ");
			}
		}

		System.out.println(sb.toString());

		System.out.println(solve(dictionary, sentence));

	}

	private static String found(String eachString) {
		TrieNode root = saved;
		StringBuilder sb = new StringBuilder();
		char[] arr = eachString.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			char eachChar = arr[i];
			if (root == null || root.link[eachChar - 'a'] == null) {
				break;
			}
			sb.append(eachChar);
			if (ls.contains(sb.toString())) {
				return sb.toString();
			}
			root = root.getChar(eachChar);
		}
		return root.isEnd ? sb.toString() : "";
	}

	private static String solve(List<String> dictionary, String sentence) {
		StringBuilder sb = new StringBuilder();
		String[] arr = sentence.split(" ");
		for (int j = 0; j < arr.length; j++) {
			String each = arr[j];
			StringBuilder temp = new StringBuilder();
			boolean flag = false;
			for (int i = 0; i < dictionary.size(); i++) {
				if (each.startsWith(dictionary.get(i))) {
					if (temp.isEmpty() || temp.length() > dictionary.get(i).length()) {
						temp.replace(0, temp.length(), dictionary.get(i));
					}
					flag = true;
				}
			}
			if (flag) {
				sb.append(temp);
			} else {
				sb.append(each);
			}

			if (j != arr.length - 1) {
				sb.append(" ");
			}
		}

		return sb.toString();
	}

}
