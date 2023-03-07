package trie;

public class LongestCommonPrefix {

	private static TrieNode node;

	public LongestCommonPrefix() {
		node = new TrieNode();
	}

	public void insert(String value) {
		TrieNode root = node;
		for (char eachChar : value.toCharArray()) {
			if (!root.isPresent(eachChar)) {
				TrieNode next = new TrieNode();
				root.insert(eachChar, next);
			}
			root = root.getNode(eachChar);
		}
	}

	public boolean search(String value) {
		TrieNode root = node;
		for (char eachChar : value.toCharArray()) {
			if (!root.isPresent(eachChar)) {
				return false;
			} else {
				root = root.getNode(eachChar);
			}

		}
		return true;
	}

	public static class TrieNode {
		TrieNode[] links;

		boolean isEnd;

		public TrieNode() {
			this.links = new TrieNode[26];
			this.isEnd = false;
		}

		public boolean isPresent(char value) {
			if (links[value - 'a'] != null) {
				return true;
			} else {
				return false;
			}
		}

		public void insert(char value, TrieNode node) {
			links[value - 'a'] = node;
		}

		public TrieNode getNode(char value) {
			return links[value - 'a'];
		}

		public TrieNode[] getLinks() {
			return links;
		}

		public void setLinks(TrieNode[] links) {
			this.links = links;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}

	}

	public static void main(String[] args) {
		String[] strs = { "flower", "flow", "flight" };

		solve(strs);
	}

	private static void solve(String[] strs) {
		LongestCommonPrefix cm = new LongestCommonPrefix();
		StringBuilder sb = new StringBuilder();
		for (String string : strs) {
			cm.insert(string);
		}

	

	}

}
