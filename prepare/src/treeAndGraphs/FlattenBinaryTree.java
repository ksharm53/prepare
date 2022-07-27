package treeAndGraphs;

import java.util.Stack;

public class FlattenBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(5, null, new TreeNode(6)));

		solve(node);

	}

	public static void solve(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stk = new Stack<TreeNode>();
		stk.push(root);
		while (!stk.isEmpty()) {
			TreeNode curr = stk.pop();
			if (curr.right != null)
				stk.push(curr.right);
			if (curr.left != null)
				stk.push(curr.left);
			if (!stk.isEmpty())
				curr.right = stk.peek();
			curr.left = null;
		}
	}

}
