package Sept23;

public class HouseRobberIII {

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
		TreeNode root = new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)));

		System.out.println(solve(root));

	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = 0;
		int right = 0;

		if (root.left != null) {
			left = Math.max(root.val + solve(root.left.left), root.val + solve(root.left.right));
		}
		if (root.right != null) {
			right = Math.max(root.val + solve(root.right.left), root.val + solve(root.right.right));
		}

		return Math.max(left + right, solve(root.left) + solve(root.right));
	}

}
