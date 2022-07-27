package arraysAndStrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	static class SinglyLinkedListNode {
		public int data;
		public SinglyLinkedListNode next;

		public SinglyLinkedListNode(int nodeData, SinglyLinkedListNode next) {
			this.data = nodeData;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(10, 50, 90, 30);
		SinglyLinkedListNode list = new SinglyLinkedListNode(3,
				new SinglyLinkedListNode(4, new SinglyLinkedListNode(3, new SinglyLinkedListNode(6, null))));
		System.out.println(solve(list1));
	}

	private static int solve(List<Integer> list1) {
		int i = 0;
		int j = 0;
		int localSum = 0;
		int counter = 0;
		while (j < list1.size()) {
			localSum = localSum + list1.get(j);
			if (j - i + 1 < 2) {
				j++;
			} else if (j - i + 1 == 2) {
				if (localSum % 60 == 0) {
					counter++;
				}
				localSum = localSum - list1.get(i);
				i++;
				j++;
			}
		}
		return counter;
	}

	private static SinglyLinkedListNode solve(SinglyLinkedListNode list) {
		SinglyLinkedListNode head = list;
		Set<Integer> set = new HashSet<>();
		if (list == null) {
			return null;
		}

		set.add(list.data);

		while (list.next != null) {
			if (!set.contains(list.next.data)) {
				set.add(list.next.data);
				list = list.next;
			} else {
				list.next = list.next.next;
			}
		}
		return head;
	}

}
