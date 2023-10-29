package aug;

public class Partition {

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
		ListNode head = new ListNode(1,
				new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
		int x = 3;
		System.out.println(solve(head, x));

	}

	private static ListNode solve(ListNode head, int x) {
		ListNode res = new ListNode(-200);
		ListNode temp = res;
		ListNode last = new ListNode(-200);
		ListNode oneBack = new ListNode(-200, head);

		while (head != null) {
			if (head.val < x) {
				res.next = new ListNode(head.val);
				res = res.next;
				last = head.next;
			}
			head = head.next;
		}

		return temp;
	}

}
