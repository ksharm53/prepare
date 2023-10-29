package mar01;

public class SumNumbers {
	public static int sum;

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
		sum = 0;
		TreeNode root = new TreeNode(4, new TreeNode(9, new TreeNode(5), null), new TreeNode(0));
		solve(root, new StringBuilder());
		System.out.println(sum);

	}

	public static void solve(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			sb.append(root.val);

			if (!sb.isEmpty()) {
				sum += Integer.valueOf(sb.toString());
			} else {
				sum += 0;
			}
			if (!sb.isEmpty())
				sb.deleteCharAt(sb.length() - 1);
			return;
		}
		sb.append(root.val);
		solve(root.left, sb);
		solve(root.right, sb);
		if (!sb.isEmpty())
			sb.deleteCharAt(sb.length() - 1);
	}

}
