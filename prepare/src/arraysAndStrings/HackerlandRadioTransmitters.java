package arraysAndStrings;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HackerlandRadioTransmitters {

	public static void main(String[] args) {
		List<Integer> x = Arrays.asList(1, 2, 3, 4, 5);
		int k = 1;

		System.out.println(solve(x, k));

	}

	private static int solve(List<Integer> x, int k) {
		Collections.sort(x);

		int transmitter = 1;
		int last = x.get(0);
		int temp = x.get(0);
		for (int i = 0; i < x.size(); i++) {
			int each = x.get(i);
			if ((each - last) > k) {
				transmitter++;
				last = each;
				temp = each;
			} else if (each - temp <= k) {
				last = each;
			}
		}
		return transmitter;
	}

}
