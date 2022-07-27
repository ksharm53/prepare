package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class BalancedSum {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(2, 0, 0, 0);
		System.out.println(balancedSums(list));

	}

	public static String balancedSums(List<Integer> arr) {
		int total = 0;
		if (arr.size() == 0) {
			return "NO";
		}
		for (Integer integer : arr) {
			total = total + integer;
		}
		int sum = 0;
		for (int i = 0; i < arr.size(); i++) {
			int temp = arr.get(i) + sum;
			if (sum == (total - temp)) {
				return "YES";
			}
			sum = sum + arr.get(i);
		}
		return "NO";
	}

}
