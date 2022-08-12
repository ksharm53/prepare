package treeAndGraphs;

public class IsBinaryTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(2, new TreeNode(2, null, null), new TreeNode(2, null, null));
		System.out.println(isValidBST(root));

	}

	public static  boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return helper(root.left, null, root.val) && helper(root.right, root.val, null);
	}

	private static boolean helper(TreeNode node, Integer loBound, Integer hiBound) {
		if (node == null)
			return true;
		if (loBound != null && node.val <= loBound)
			return false;
		if (hiBound != null && node.val >= hiBound)
			return false;
		return helper(node.left, loBound, node.val) && helper(node.right, node.val, hiBound);
	}

}
