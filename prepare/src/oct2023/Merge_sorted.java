package oct2023;

public class Merge_sorted {

	public static void main(String[] args) {
		LinkedListNode head1 = new LinkedListNode(
				new LinkedListNode(new LinkedListNode(new LinkedListNode(null, 19), 15), 8), 4);
		LinkedListNode head2 = new LinkedListNode(
				new LinkedListNode(new LinkedListNode(new LinkedListNode(null, 16), 10), 19), 7);

		System.out.println(merge_sorted(head1, head2));

	}

	public static class LinkedListNode {
		public LinkedListNode(LinkedListNode next, int data) {
			super();
			this.next = next;
			this.data = data;
		}

		LinkedListNode next;
		int data;
	}

	public static LinkedListNode merge_sorted(LinkedListNode head1, LinkedListNode head2) {

		if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		}

		LinkedListNode mergedHead = null;
		if (head1.data <= head2.data) {
			mergedHead = head1;
			head1 = head1.next;
		} else {
			mergedHead = head2;
			head2 = head2.next;
		}

		LinkedListNode mergedTail = mergedHead;

		while (head1 != null && head2 != null) {
			LinkedListNode temp = null;
			if (head1.data <= head2.data) {
				temp = head1;
				head1 = head1.next;
			} else {
				temp = head2;
				head2 = head2.next;
			}

			mergedTail.next = temp;
			mergedTail = temp;
		}

		if (head1 != null) {
			mergedTail.next = head1;
		} else if (head2 != null) {
			mergedTail.next = head2;
		}

		return mergedHead;

	}

}
