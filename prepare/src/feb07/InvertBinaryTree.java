package feb07;

public class InvertBinaryTree {

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
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(7, new TreeNode(6), new TreeNode(9)));
		TreeNode res = solve(root);
		System.out.println(res);

	}

	private static TreeNode solve(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode left = solve(root.left);
		TreeNode right = solve(root.right);
		root.left = right;
		root.right = left;
		return root;
	}

}
