package treeAndGraphs;

public class SymmetricTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)),
				new TreeNode(2, new TreeNode(4), new TreeNode(3)));
		System.out.println(solve(root));
	}

	private static boolean solve(TreeNode root) {
		if (root == null) {
			return true;
		}

		return areSymmetric(root.left, root.right);

	}

	private static boolean areSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if ((left == null && right != null) || (left != null && right == null)) {
			return false;
		} else if (left.val != right.val) {
			return false;
		} else {
			return areSymmetric(left.left, right.right) && areSymmetric(left.right, right.left);
		}
	}

}
