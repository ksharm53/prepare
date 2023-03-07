package interviewBitProblems;

import java.util.Comparator;
import java.util.PriorityQueue;

import treeAndGraphs.TreeNode;

public class MergekSortedLists {

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
		ListNode first = new ListNode(1, new ListNode(4, new ListNode(5, null)));
		ListNode second = new ListNode(1, new ListNode(3, new ListNode(4, null)));
		ListNode third = new ListNode(2, new ListNode(6, null));

		ListNode[] lists = { first, second, third };

		System.out.println(solve(lists));

	}

	private static ListNode solve(ListNode[] lists) {
		if (lists==null || lists.length == 0) {
			return new ListNode();
		}
		ListNode result = new ListNode(0);
		ListNode hold = result;

		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {

			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		for (ListNode eachList : lists) {
			pq.add(eachList);
		}

		while (!pq.isEmpty()) {
			ListNode temp = pq.poll();
			hold.next = temp;
			hold = hold.next;

			if (temp.next != null) {
				pq.add(temp.next);
			}
		}
		return result.next;

	}

}
