package treeAndGraphs;

public class BinarySearchTreeInsertion {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, null, null));
		int data = 6;

		System.out.println(solve(root, data));

	}

	private static TreeNode solve(TreeNode root, int data) {
		TreeNode temp = root;

		if (root == null) {
			return new TreeNode(data);
		}

		while (root != null) {
			TreeNode prev = root;
			if (root.val < data) {
				root = root.right;
			} else {
				root = root.left;
			}
			if (root == null) {
				if (prev.val < data) {
					prev.right = new TreeNode(data);
				} else {
					prev.left = new TreeNode(data);
				}
				break;
			}
		}

		return temp;
	}

}
