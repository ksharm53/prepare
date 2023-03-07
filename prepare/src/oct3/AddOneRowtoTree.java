package oct3;

public class AddOneRowtoTree {

	public static boolean flag = false;

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
		int depth = 1;
		int val = 5;
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3));
		if (depth == 1) {
			TreeNode temp = new TreeNode(val);
			temp.left = root;
			System.out.println(temp);
		}
		solve(root, 1, val, depth);
		System.out.println(root);

	}

	public static void solve(TreeNode root, int level, int val, int depth) {
		if (root == null)
			return;
		if (level < depth - 1) {
			solve(root.left, level + 1, val, depth);
			solve(root.right, level + 1, val, depth);
		} else {
			TreeNode temp = root.left;
			root.left = new TreeNode(val);
			root.left.left = temp;
			temp = root.right;
			root.right = new TreeNode(val);
			root.right.right = temp;
		}

	}

}
