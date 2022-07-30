package treeAndGraphs;

public class HeightOfBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)),
				new TreeNode(6, new TreeNode(5), new TreeNode(7)));

		System.out.println(solve(root) - 1);

	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(1 + solve(root.left), 1 + solve(root.right));
	}

}
