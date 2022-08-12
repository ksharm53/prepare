package linkedLists;

public class LinkedListSum {
	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData, SinglyLinkedListNode next) {
			this.data = nodeData;
			this.next = next;
		}
	}

	public static void main(String[] args) {

		SinglyLinkedListNode head = new SinglyLinkedListNode(1, new SinglyLinkedListNode(4, new SinglyLinkedListNode(3,
				new SinglyLinkedListNode(8, new SinglyLinkedListNode(1, new SinglyLinkedListNode(6, null))))));

		System.out.println(solve(head));

	}

	private static int solve(SinglyLinkedListNode head) {

		if (head == null)
			return 0;
		if (head.next == null)
			return head.data;

		SinglyLinkedListNode fast = head;
		SinglyLinkedListNode slow = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		SinglyLinkedListNode temp = head;
		SinglyLinkedListNode last = null;

		while (slow != null) {
			SinglyLinkedListNode next = slow.next;
			slow.next = last;
			last = slow;
			slow = next;
		}

		int maxSum = Integer.MIN_VALUE;
		while (temp != null && last != null) {
			maxSum = Math.max(maxSum, temp.data + last.data);
			temp = temp.next;
			last = last.next;
		}
		return maxSum;

	}

}
