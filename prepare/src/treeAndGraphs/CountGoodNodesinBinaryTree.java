package treeAndGraphs;

import java.util.Stack;

public class CountGoodNodesinBinaryTree {

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
		TreeNode root = new TreeNode(3, new TreeNode(1, new TreeNode(3), null),
				new TreeNode(4, new TreeNode(1), new TreeNode(5)));

		TreeNode root1 = new TreeNode(3, new TreeNode(3, new TreeNode(4), new TreeNode(2)), null);
		TreeNode root2 = new TreeNode(9, null, new TreeNode(3, new TreeNode(6), null));

		TreeNode root3 = new TreeNode(1, new TreeNode(4, new TreeNode(6, null, new TreeNode(10)), null), null);

		System.out.println(solve(root));
		// solve(root1);

	}

	private static int solve(TreeNode root) {
		int counter = 0;

		if (root == null) {
			return 0;
		}
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> stackMax = new Stack<>();
		stack.push(root);
		stackMax.push(Integer.MIN_VALUE);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.pop();
			int maxValue = stackMax.pop();

			if (temp.val >= maxValue) {
				counter++;
			}
			if (temp.right != null) {
				stack.push(temp.right);
				stackMax.push(Math.max(maxValue, temp.val));
			}
			if (temp.left != null) {
				stack.push(temp.left);
				stackMax.push(Math.max(maxValue, temp.val));
			}
		}

		return counter;
	}

}
