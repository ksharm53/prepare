package oct3;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		String s = "eccbbbbdec";
		System.out.println(solve(s));

	}

	private static int[] solve(String s) {

		int i = 0;
		List<Integer> list = new ArrayList<>();
		while (i < s.length()) {
			char first = s.charAt(i);
			int lastIndex = s.lastIndexOf(first);
			int temp = i + 1;
			while (temp < lastIndex) {
				if (s.lastIndexOf(s.charAt(temp)) <= lastIndex) {
					temp++;
				} else {
					lastIndex = s.lastIndexOf(s.charAt(temp));
				}
			}
			list.add(lastIndex - i + 1);
			i = lastIndex + 1;
		}
		//System.out.println(list);
		int[] result = new int[list.size()];
		for (int k = 0; k < list.size(); k++) {
			result[k] = list.get(k);
		}
		return result;
	}

}
