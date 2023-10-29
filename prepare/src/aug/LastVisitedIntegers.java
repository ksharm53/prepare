package aug;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LastVisitedIntegers {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("1", "prev", "2", "prev", "prev");
		System.out.println(solve(words));
	}

	private static List<Integer> solve(List<String> words) {
		List<Integer> list = new ArrayList<>();
		List<Integer> res = new ArrayList<>();
		int prevCount = 0;
		for (int i = 0; i < words.size(); i++) {
			String eachInteger = words.get(i);
			if (eachInteger.equals("prev")) {
				if (i - 1 >= 0 && words.get(i - 1).equals(eachInteger)) {
					prevCount++;
				} else {
					prevCount = 1;
				}

				if (prevCount <= list.size()) {
					res.add(list.get(list.size() - prevCount));
				} else {
					res.add(-1);
				}
			} else {
				list.add(Integer.valueOf(eachInteger));
			}
		}
		return res;
	}

}
