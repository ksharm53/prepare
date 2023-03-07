package nov13;

public class BalancedBinaryTree {

	public static boolean val;

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
		TreeNode root = new TreeNode(3, new TreeNode(9, null, null),
				new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(15), null)));
		val = true;

		solve(root);
		System.out.println(val);

	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = solve(root.left);
		int right = solve(root.right);

		if (Math.abs(left - right) > 1) {
			val = false;
		}
		return Math.max(left, right) + 1;
	}

}
