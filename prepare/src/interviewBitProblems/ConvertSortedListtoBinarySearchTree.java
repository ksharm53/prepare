package interviewBitProblems;

public class ConvertSortedListtoBinarySearchTree {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

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
		ListNode head = new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9, null)))));

		System.out.println(solve(head, null));

	}

	private static TreeNode solve(ListNode head, ListNode tail) {
		if (head == tail || head == null) {
			return null;
		}

		ListNode slow = head;
		ListNode fast = head;

		while (fast != tail && fast.next != tail) {
			slow = slow.next;
			fast = fast.next.next;
		}

		TreeNode root = new TreeNode(slow.val);
		root.left = solve(head, slow);
		root.right = solve(slow.next, tail);

		return root;

	}

}
