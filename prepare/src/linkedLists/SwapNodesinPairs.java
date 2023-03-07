package linkedLists;

public class SwapNodesinPairs {

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
		ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

		System.out.println(solve(root));

	}

	public static ListNode solve(ListNode head) {

		if (head == null) {
			return null;
		}
		if (head.next == null) {
			return head;
		}

		ListNode prevNode = new ListNode();

		ListNode dummy = prevNode;
		ListNode current = head;

		while (current != null && current.next != null) {
			dummy.next = current.next;
			current.next = dummy.next.next;
			dummy.next.next = current;

			dummy = current;
			current = current.next;

		}
		return prevNode.next;

	}

}
