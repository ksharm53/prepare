package trie;

import java.util.HashMap;
import java.util.Map;

public class MapSum {

	TrieNode root;

	public MapSum() {
		root = new TrieNode();
	}

	public class TrieNode {

		Map<Character, TrieNode> map;
		int sum;

		public TrieNode() {
			map = new HashMap<>();
		}

		public int getSum() {
			return sum;
		}

		public void setSum(int sum) {
			this.sum = sum;
		}

		public TrieNode getChild(char eachElement) {
			return map.get(eachElement);
		}

		public void putChild(char eachElement, TrieNode node) {
			map.put(eachElement, node);
		}

	}

	public static void main(String[] args) {

		MapSum mapSum = new MapSum();

		mapSum.insert("apple", 3);
		System.out.println(mapSum.sum("ap"));
		mapSum.insert("app", 2);
		System.out.println(mapSum.sum("ap"));

	}

	public void insert(String key, int val) {
		TrieNode current = root;
		for (char eachElement : key.toCharArray()) {
			TrieNode next = current.getChild(eachElement);
			if (next == null) {
				next = new TrieNode();
				current.putChild(eachElement, next);
			}
			current = next;
		}
		current.sum = val;
	}

	public int sum(String prefix) {
		TrieNode current = root;
		for (char eachElement : prefix.toCharArray()) {
			TrieNode next = current.getChild(eachElement);
			if (next == null) {
				return 0;
			}
			current = next;
		}

		return dfs(current);
	}

	private int dfs(TrieNode root) {
		int sum = 0;
		for (char c : root.map.keySet()) {
			sum += dfs(root.map.get(c));
		}
		return sum + root.sum;
	}

}
