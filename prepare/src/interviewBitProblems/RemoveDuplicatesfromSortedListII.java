package interviewBitProblems;

public class RemoveDuplicatesfromSortedListII {

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
		ListNode head = new ListNode(1, new ListNode(1, new ListNode(1)));

		System.out.println(solve(head));

	}

	private static ListNode solve(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode previous = null;
		ListNode fast = head.next;

		if (fast == null) {
			return head;
		}

		while (fast != null && slow != null) {
			if (slow.val != fast.val) {
				previous = slow;
				slow = slow.next;
				fast = fast.next;
			} else {
				while (fast != null && fast.next != null && fast.val == fast.next.val) {
					fast = fast.next;
				}
				if (previous != null) {
					previous.next = fast.next;
				}

				if (fast != null) {
					slow = fast.next;
				}
				if (slow != null) {
					fast = slow.next;
				}

				if (previous == null) {
					head = slow;
				}
			}
		}
		return head;
	}

}
