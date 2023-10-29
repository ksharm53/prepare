package mar01;

public class WordDictionary {

	public TrieNode root;

	public class TrieNode {
		TrieNode[] links;
		boolean isEnd;

		public TrieNode() {
			this.links = new TrieNode[26];
			this.isEnd = false;
		}

		public void insert(char ch, TrieNode node) {
			this.links[ch - 'a'] = node;
		}

		public TrieNode[] getLinks() {
			return this.links;
		}

		public TrieNode getChar(char ch) {
			return this.links[ch - 'a'];
		}

		public TrieNode getCharIndex(int idx) {
			return this.links[idx];
		}

	}

	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void addWord(String word) {
		TrieNode temp = this.root;

		for (char ch : word.toCharArray()) {
			if (temp.getChar(ch) == null) {
				temp.insert(ch, new TrieNode());
			}
			temp = temp.getChar(ch);
		}
		temp.isEnd = true;
	}

	public boolean search(String word) {
		TrieNode temp = root;
		return helper(temp, word, 0);

	}

	public boolean helper(TrieNode temp, String word, int idx) {
		if (idx == word.length() && temp.isEnd) {
			return true;
		}

		if (idx >= word.length()) {
			return false;
		}

		if (word.charAt(idx) == '.') {

			for (int i = 0; i < 26; i++) {
				TrieNode val = temp;
				if (val.getCharIndex(i) != null) {
					val = val.getCharIndex(i);
					boolean res = helper(val, word, idx + 1);
					if (res) {
						return true;
					}
				}
			}
			return false;

		} else {
			if (temp.getChar(word.charAt(idx)) == null) {
				return false;
			} else {
				temp = temp.getChar(word.charAt(idx));
				return helper(temp, word, idx + 1);
			}
		}
	}

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("badaaa");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad"));
		System.out.println(wordDictionary.search("bad"));
		System.out.println(wordDictionary.search(".adaaap"));
		System.out.println(wordDictionary.search("b.."));

	}

}
