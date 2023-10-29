package july;

public class AddTwoNumbers {

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
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(7, new ListNode(3));

		int size2 = findSize(l2);
		int size1 = findSize(l1);
		int diff = Math.abs(size1 - size2);

		ListNode node = null;

		if (diff > 0) {
			if (size1 > size2) {
				ListNode temp1 = l1;

				Pair pair = dorecusrion(temp1, diff, l2);

				if (pair.carry > 0) {
					node = new ListNode(pair.carry, pair.node);
				} else {
					node = pair.node;
				}
			} else {
				ListNode temp2 = l2;

				Pair pair = dorecusrion(temp2, diff, l1);

				if (pair.carry > 0) {
					node = new ListNode(pair.carry, pair.node);
				} else {
					node = pair.node;
				}
			}
		} else {
			ListNode temp1 = l1;

			Pair pair = dorecusrion(temp1, diff, l2);

			if (pair.carry > 0) {
				node = new ListNode(pair.carry, pair.node);
			} else {
				node = pair.node;
			}
		}

		System.out.println(node);

	}

	private static Pair dorecusrion(ListNode temp1, int diff, ListNode l2) {
		if (diff == 0) {
			return doSum(temp1, l2);
		}

		Pair pair = dorecusrion(temp1.next, diff - 1, l2);

		int currSum = temp1.val + pair.carry;
		int carry = currSum / 10;

		ListNode ret = new ListNode(currSum % 10);
		ret.next = pair.node;
		return new Pair(ret, carry);

	}

	static class Pair {
		ListNode node;
		int carry;

		public Pair(ListNode node, int carry) {
			this.node = node;
			this.carry = carry;
		}

	}

	private static Pair doSum(ListNode temp1, ListNode l2) {

		if (temp1.next == null && l2.next == null) {
			int sum = temp1.val + l2.val;
			ListNode ret = new ListNode(sum % 10);
			int carry = sum / 10;
			return new Pair(ret, carry);
		}

		Pair pair = doSum(temp1.next, l2.next);

		int currSum = temp1.val + l2.val + pair.carry;
		int carry = currSum / 10;

		ListNode ret = new ListNode(currSum % 10);
		ret.next = pair.node;
		return new Pair(ret, carry);

	}

	private static int findSize(ListNode l2) {
		ListNode temp = l2;
		int size = 0;
		while (temp.next != null) {
			size++;
			temp = temp.next;
		}

		return size;
	}

}
