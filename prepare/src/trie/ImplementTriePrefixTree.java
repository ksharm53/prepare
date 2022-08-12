package trie;

public class ImplementTriePrefixTree {

	private TrieNode node;

	public ImplementTriePrefixTree() {
		node = new TrieNode();
	}

	public class TrieNode {
		TrieNode[] links;
		private boolean isEnd;

		public TrieNode() {
			links = new TrieNode[26];
		}

		public boolean isPresent(char ch) {
			return links[ch - 'a'] != null;
		}

		public TrieNode get(char ch) {
			return links[ch - 'a'];
		}

		public void insert(char ch, TrieNode node) {
			links[ch - 'a'] = node;
		}

		public boolean isEnd() {
			return isEnd;
		}

		public void setEnd(boolean isEnd) {
			this.isEnd = isEnd;
		}
	}

	public static void main(String[] args) {
		ImplementTriePrefixTree obj = new ImplementTriePrefixTree();

		obj.insert("apple");
		boolean serachReturn = obj.search("apple");
		boolean searchStartsWith = obj.startsWith("app");

		System.out.println(searchStartsWith);
		System.out.println(serachReturn);
	}

	public void insert(String word) {
		TrieNode root = node;
		for (char eachChar : word.toCharArray()) {
			if (!root.isPresent(eachChar)) {
				TrieNode newNode = new TrieNode();
				root.insert(eachChar, newNode);
			}
			root = root.get(eachChar);
		}
		root.setEnd(true);
	}

	public boolean search(String word) {
		TrieNode root = node;
		for (char eachChar : word.toCharArray()) {
			if (root.isPresent(eachChar)) {
				root = root.get(eachChar);
			} else {
				return false;
			}
		}
		return root.isEnd ? true : false;
	}

	public boolean startsWith(String prefix) {
		TrieNode root = node;
		for (char eachChar : prefix.toCharArray()) {
			if (root.isPresent(eachChar)) {
				root = root.get(eachChar);
			} else {
				return false;
			}
		}
		return root != null ? true : false;
	}

}
