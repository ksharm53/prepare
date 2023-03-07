package Oct21;

import java.util.ArrayList;
import java.util.List;

public class LongestUnivaluePath {
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

	public static int max;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)),
				new TreeNode(5, null, new TreeNode(5)));
		max = Integer.MIN_VALUE;
		solve(root, root.val);
		System.out.println(max);

	}

	private static int solve(TreeNode root, int prev) {
		if (root == null) {
			return 0;
		}

		int left = solve(root.left, root.val);
		int right = solve(root.right, root.val);
		max = Math.max(max, left + right);

		if (prev == root.val) {
			return Math.max(left, right) + 1;
		}

		return 0;
	}

}
