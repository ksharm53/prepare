package linkedLists;

public class RemoveNthNodeFromEndofList {

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

	public static void main(String[] args) {
		// ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new
		// ListNode(4, new ListNode(5)))));

		ListNode head = new ListNode(1);

		System.out.println(solve(head, 1));

	}

	private static ListNode solve(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}
		if (fast == null)
			return head.next;

		while (slow.next != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;

	}

}
