package august23;

public class ReverseNodesinkGroup {

	static int currentNodes;

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
		ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		ListNode temp = head;
		int total = 0;
		int k = 2;
		currentNodes = 0;

		while (head != null) {
			total++;
			head = head.next;
		}
		head = temp;

		int totalNodes = (total / 2) * k;
		ListNode result = solve(head, k, totalNodes);

		System.out.println(result);

	}

	private static ListNode solve(ListNode head, int k, int alloweNodes) {
		if (head == null) {
			return null;
		}
		if (currentNodes == alloweNodes) {
			return head;
		}

		int internalCounter = 0;

		ListNode prev = null;
		while (head != null && internalCounter < k) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
			internalCounter++;
			currentNodes++;
		}
		if (head != null) {
			head.next = solve(head, k, alloweNodes);
		}
		return prev;
	}

}
