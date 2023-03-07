package airport;

public class MaximumProductofSplittedBinaryTree {

	public static int sum;
	public static long prod;

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
		TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)),
				new TreeNode(3, new TreeNode(6), null));

		sum = sumFunct(root);
		prod = Long.MIN_VALUE;
		System.out.println(sum);
		solve(root);
		System.out.println(prod % (1000000000 + 7));

	}

	private static int solve(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftVal = solve(root.left);
		int rightVal = solve(root.right);

		int currNodeVal = leftVal + rightVal + root.val;
		prod = Math.max(prod, ((sum - currNodeVal) * currNodeVal));
		return currNodeVal;

	}

	private static int sumFunct(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int leftVal = sumFunct(root.left);
		int rightVal = sumFunct(root.right);

		return leftVal + rightVal + root.val;

	}

}
