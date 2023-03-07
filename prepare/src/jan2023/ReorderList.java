package jan2023;

public class ReorderList {

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
		ListNode node = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

		solve(node);
	}

	private static void solve(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode reversed = reverseList(slow);
		mergeList(head, reversed);
	}

	private static void mergeList(ListNode head, ListNode reversed) {
		while (head != null && reversed != null) {
			ListNode headNext = head.next;
			ListNode revNext = reversed.next;
			head.next = reversed;
			reversed.next = headNext;
			head = headNext;
			reversed = revNext;
		}
	}

	private static ListNode reverseList(ListNode slow) {
		ListNode curr = slow;
		ListNode prev = null;
		ListNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
