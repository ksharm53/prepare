package newBeginning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddOne {

	public static void main(String[] args) {
		List<Integer> A = Arrays.asList(9, 9, 9, 9, 9);
		System.out.println(plusOne(A));
	}

	public static List<Integer> plusOne(List<Integer> A) {

		int carry = 1;
		List<Integer> list = new ArrayList<>();
		for (int i = A.size() - 1; i >= 0; i--) {
			int currentElement = A.get(i);
			currentElement += carry;
			carry = 0;
			if (currentElement == 10) {
				currentElement = currentElement % 10;
				carry = 1;
			}

			A.set(i, currentElement);
		}

		if (carry > 0) {
			list.add(1);
		}
		for (int i = 0; i < A.size(); i++) {
			if (list.size() == 0 && A.get(i) == 0) {
				continue;
			} else {
				list.add(A.get(i));
			}
		}
		return list;
	}

}
