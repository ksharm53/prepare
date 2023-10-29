package mar01;

public class TrieNode {

	TrieNode[] link;
	boolean isEnd;

	public TrieNode() {
		link = new TrieNode[26];
	}

	public boolean isPresent(char ch) {
		return this.link[ch - 'a'] != null;
	}

	public TrieNode getChar(char ch) {
		return this.link[ch - 'a'];
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}
