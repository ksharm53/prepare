package oct3;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {

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

	public static int min;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
				new TreeNode(20, new TreeNode(15), new TreeNode(7)));

		TreeNode rootAgain = new TreeNode(2, null,
				new TreeNode(3, null, new TreeNode(4, null, new TreeNode(5, null, new TreeNode(6)))));

		min = Integer.MAX_VALUE;
		solve(rootAgain, 1);
		System.out.println(min);
		System.out.println(minDepth(rootAgain));

	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int counter = 1;

		while (!queue.isEmpty()) {
			int level = queue.size();
			for (int i = 1; i <= level; i++) {
				TreeNode each = queue.poll();
				if (each.left == null && each.right == null) {
					return counter;
				}
				if (each.left != null) {
					queue.add(each.left);
				}
				if (each.right != null) {
					queue.add(each.right);
				}
			}
			counter++;
		}
		return counter;
	}

	private static void solve(TreeNode root, int count) {
		if (root == null) {
			return;
		}

		if (root.left == null && root.right == null) {
			min = Math.min(min, count);
		}

		solve(root.left, count + 1);
		solve(root.right, count + 1);
	}

}
