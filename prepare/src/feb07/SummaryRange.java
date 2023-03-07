package feb07;

import java.util.ArrayList;
import java.util.List;

public class SummaryRange {

	public static void main(String[] args) {
		int[] nums = { -1 };
		System.out.println(summaryRanges(nums));

	}

	public static List<String> summaryRanges(int[] nums) {
		int nat = 0;
		int first = -1;
		int last = -1;
		List<String> list = new ArrayList<>();

		if (nums.length == 1) {
			list.add(String.valueOf(nums[0]));
		}

		for (int i = 0; i < nums.length; i++) {
			if (i == 0) {
				first = nums[i];
				nat = nums[i];
				nat++;
				continue;
			}
			if (nat != nums[i]) {
				last = nums[i - 1];
				String val = "";
				if (first != last) {
					val = first + "->" + last;
				} else {
					val = String.valueOf(first);
				}
				list.add(val);
				nat = nums[i];
				first = nums[i];
			}
			if (i == nums.length - 1) {
				last = nums[i];
				String val = "";
				if (first != last) {
					val = first + "->" + last;
				} else {
					val = String.valueOf(first);
				}
				list.add(val);
			}
			nat++;
		}

		return list;
	}

}
