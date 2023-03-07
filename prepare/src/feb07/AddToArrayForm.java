package feb07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AddToArrayForm {

	public static void main(String[] args) {
		int[] num = { 9, 9, 9, 9, 9, 9, 9, 9, 9, 9 };
		System.out.println(addToArrayForm(num, 1));

	}

	public static List<Integer> addToArrayForm(int[] num, int k) {
		List<Integer> list = new ArrayList<>();
		int carry = 0;
		int idx = num.length - 1;

		while (idx >= 0 || k > 0) {
			int rem = k % 10;
			int val = -1;
			if (idx >= 0) {
				val = num[idx] + rem + carry;
			} else {
				val = rem + carry;
			}
			list.add(val % 10);
			carry = val / 10;
			k = k / 10;
			idx--;
		}
		if (carry > 0) {
			list.add(carry);
		}

		Collections.reverse(list);
		return list;
	}

}
