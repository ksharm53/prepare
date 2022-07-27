package treeAndGraphs;

public class PreOrder {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5)));

		solve(root);

	}

	private static void solve(TreeNode root) {
		if (root == null) {
			return;
		}

		solve(root.left);
		System.out.println(root.val);
		solve(root.right);
	}

}
