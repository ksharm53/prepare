package treeAndGraphs;

public class maximumdepthBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null),
				new TreeNode(3, null, new TreeNode(5, new TreeNode(10), null)));
		System.out.println(solve(root));
	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = 1 + solve(root.left);
		int right = 1 + solve(root.right);

		return Math.max(left, right);
	}

}
