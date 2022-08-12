package treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class TreeTopView {

	static class Pair {
		TreeNode node;
		int level;

		Pair(TreeNode node, int level) {
			this.node = node;
			this.level = level;
		}

		public TreeNode getNode() {
			return node;
		}

		public void setNode(TreeNode node) {
			this.node = node;
		}

		public int getLevel() {
			return level;
		}

		public void setLevel(int level) {
			this.level = level;
		}
	}

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1, null,
				new TreeNode(2, null, new TreeNode(5, new TreeNode(3, null, new TreeNode(4)), new TreeNode(6))));

		solve(root);

	}

	private static void solve(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<Pair> queue = new LinkedList<>();
		TreeMap<Integer, Integer> map = new TreeMap<>();

		int level = 0;
		queue.add(new Pair(root, level));

		while (!queue.isEmpty()) {
			Pair pair = queue.poll();
			TreeNode current = pair.getNode();
			int temp = pair.getLevel();

			if (!map.keySet().contains(temp)) {
				map.put(temp, current.val);
			}
			if (current.left != null)
				queue.add(new Pair(current.left, temp - 1));
			if (current.right != null)
				queue.add(new Pair(current.right, temp + 1));
		}

		System.out.println(map.values());

	}

}
