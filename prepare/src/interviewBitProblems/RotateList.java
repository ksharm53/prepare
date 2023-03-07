package interviewBitProblems;

public class RotateList {

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
		ListNode head = new ListNode(0, new ListNode(1, new ListNode(2)));

		System.out.println(solve(head, 4));

	}

	private static ListNode solve(ListNode head, int k) {
		if (head == null) {
			return null;
		}
		ListNode temp = head;

		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}

		int shift = k % length;
		int movement = length - shift;

		head = temp;
		ListNode first = head;
		ListNode fast = head;
		ListNode holdFast = head;
		ListNode mid = head;

		while (fast != null && first != null && mid != null) {
			movement--;
			if (movement == 0) {
				mid = fast;
			}
			holdFast = fast;
			fast = fast.next;
		}

		holdFast.next = first;
		head = mid.next;
		mid.next = null;

		return head;

	}

}
