package Apr1;

public class LongestZigZag {

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
		TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3),
				new TreeNode(4, new TreeNode(5, null, new TreeNode(6, null, new TreeNode(7))), new TreeNode(8))));
		System.out.println(solve(root, -1, -1)); // -1 root, 0 left , 1 right

	}

	private static int solve(TreeNode root, int dir, int lastDir) {
		if (root == null || (root.left == null && root.right == null)) {
			return 0;
		}

		if (lastDir != -1 && lastDir == dir) {
			return 0;
		} else {
			int left = solve(root.left, 0, dir) + 1;
			int right = solve(root.right, 1, dir) + 1;
			return Math.max(left, right);
		}

	}

}
