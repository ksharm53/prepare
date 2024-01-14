package dec;

public class RecoverTree {
	static boolean flag;

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
		// TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new
		// TreeNode(2), null));
		flag = true;
		TreeNode root = new TreeNode(2, new TreeNode(3), new TreeNode(1));
		while (flag) {
			flag = false;
			solve(root, new TreeNode(Integer.MAX_VALUE), new TreeNode(Integer.MIN_VALUE));
		}
		System.out.println("solve");
	}

	private static void solve(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) {
			return;
		}
		if (root.val < min.val && min.val != Integer.MAX_VALUE) {
			int temp = min.val;
			min.val = root.val;
			root.val = temp;
			flag = true;
			return;
		}
		if (root.val > max.val && max.val != Integer.MIN_VALUE) {
			int temp = max.val;
			max.val = root.val;
			root.val = temp;
			flag = true;
			return;
		}
		solve(root.left, min, root);
		solve(root.right, root, max);
	}

}
