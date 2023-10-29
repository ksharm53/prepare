package aug;

public class InsertGreatestCommonDivisors {

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
		ListNode head = new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))));

		System.out.println(solve(head));

	}

	private static ListNode solve(ListNode head) {
		ListNode temp = head;

		while (head.next != null) {
			int first = head.val;
			int sec = head.next.val;
			int gcd = findGcd(first, sec);

			ListNode insert = new ListNode(gcd);
			ListNode aagewala = head.next;

			head.next = insert;
			insert.next = aagewala;

			head = head.next.next;
		}
		return temp;
	}

	static int findGcd(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		}
		return findGcd(n2, n1 % n2);
	}
}
