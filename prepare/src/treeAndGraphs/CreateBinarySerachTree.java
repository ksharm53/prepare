package treeAndGraphs;

public class CreateBinarySerachTree {

	public static void main(String[] args) {
		int[] nums = { -10, -3, 0, 5, 9 };
		System.out.println(solve(nums, 0, nums.length-1));
	}

	public static TreeNode solve(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode temp = new TreeNode(nums[mid]);

		temp.left = solve(nums, start, mid - 1);
		temp.right = solve(nums, mid + 1, end);

		return temp;
	}

}
