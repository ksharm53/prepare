package Sept23;

public class DiameterOfBinaryTree {
	private static int maxLast;

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
		TreeNode node = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
		maxLast = Integer.MIN_VALUE;
		solve(node);
		System.out.println(maxLast);
	}

	public static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = solve(root.left);
		int right = solve(root.right);

		int maxInner = Math.max(left, right) + 1;
		maxLast = Math.max(maxInner, left + right);
		return maxInner;
	}

}
