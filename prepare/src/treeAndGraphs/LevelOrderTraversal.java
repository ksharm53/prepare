package treeAndGraphs;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, null,
				new TreeNode(2, null, new TreeNode(5, new TreeNode(3, null, new TreeNode(4)), new TreeNode(6))));

		solve(root);

	}

	private static void solve(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();

			System.out.print(current.val + " ");
			if (current.left != null)
				queue.add(current.left);

			if (current.right != null)
				queue.add(current.right);

		}

	}

}
