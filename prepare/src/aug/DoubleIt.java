package aug;

public class DoubleIt {

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
		ListNode root = new ListNode(9, new ListNode(9, new ListNode(9)));

		solve(root);

	}

	private static ListNode solve(ListNode root) {
		ListNode temp = root;
		StringBuilder sb = new StringBuilder();
		while (temp != null) {
			sb.append(temp.val);
			temp = temp.next;
		}

		ListNode last = null;
		long carry = 0;

		for (int i = sb.length() - 1; i >= 0; i--) {
			int eachVal = Character.getNumericValue(sb.charAt(i));
			long total = eachVal * 2 + carry;
			long remainder = total % 10;
			carry = total / 10;

			ListNode node = new ListNode((int) remainder);
			node.next = last;
			last = node;
		}
		if (carry > 0) {
			ListNode node = new ListNode((int) carry);
			node.next = last;
			last = node;
		}
		return last;
	}

}
