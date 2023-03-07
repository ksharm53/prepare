package oct3;

public class LowestCommonAncestorofaBinaryTree {
	public static TreeNode result;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		public TreeNode(int val, TreeNode left, TreeNode right) {
			super();
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3,
				new TreeNode(5, new TreeNode(6, null, null), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
				new TreeNode(1, new TreeNode(0), new TreeNode(8)));

		TreeNode p = new TreeNode(5);
		TreeNode q = new TreeNode(4);

		solve(root, p, q);
		System.out.println(result);

	}

	private static boolean solve(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return false;
		}

		if (root.val == p.val || root.val == q.val) {
			return true;
		}

		boolean left = solve(root.left, p, q);
		boolean right = solve(root.right, p, q);

		if (left && right) {
			if (result == null || (result != null && root.val < result.val)) {
				result = root;
			}
		}

		return left || right;

	}

	/*
	 * private static void solveBetter(TreeNode root, TreeNode p, TreeNode q) { if
	 * (root == null) { return; }
	 * 
	 * if (p.val > root.val && q.val > root.val) { solveBetter(root.left, p, q); }
	 * else if (p.val < root.val && q.val < root.val) { solveBetter(root.right, p,
	 * q); } else { result = root; }
	 * 
	 * }
	 */

}
