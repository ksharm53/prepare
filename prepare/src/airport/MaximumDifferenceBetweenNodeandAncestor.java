package airport;

public class MaximumDifferenceBetweenNodeandAncestor {
	public static int max;

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

		TreeNode root = new TreeNode(2, null,
				new TreeNode(0, null, new TreeNode(4, null, new TreeNode(3, null, new TreeNode(1)))));

		max = Integer.MIN_VALUE;

		solve(root);
		solveMax(root);
		System.out.println(max);

	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return Integer.MAX_VALUE;
		}
		int left = solve(root.left);
		int right = solve(root.right);

		int childMin = Math.min(left, right);
		if (childMin != Integer.MAX_VALUE) {
			max = Math.max(max, Math.abs(root.val - childMin));
		}

		return Math.min(Math.min(left, right), root.val);
	}

	private static int solveMax(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int left = solveMax(root.left);
		int right = solveMax(root.right);

		int childMax = Math.max(left, right);
		if (childMax != Integer.MIN_VALUE) {
			max = Math.max(max, Math.abs(root.val - childMax));
		}

		return Math.max(childMax, root.val);
	}

}
