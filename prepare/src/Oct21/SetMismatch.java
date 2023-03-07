package Oct21;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMismatch {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 3, 2, 2, 7, 6, 4, 8, 9 };
		System.out.println(findErrorNums(arr));

	}

	public static int[] findErrorNums(int[] nums) {
		Arrays.sort(nums);
		int missingVal = -1;
		int duplicateVal = -1;
		boolean flag = false;
		boolean flagMissing = false;
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!flag && nums[i] != i + 1) {
				int idx = i;
				boolean innerFlag = false;
				while (idx < nums.length) {
					if (nums[idx] == i + 1) {
						innerFlag = true;
						break;
					}
					idx++;
				}
				if (!innerFlag) {
					missingVal = i + 1;
					flag = true;
				}
			}
			if (!flagMissing && set.contains(nums[i])) {
				duplicateVal = nums[i];
				flagMissing = true;
			}
			set.add(nums[i]);

			if (flagMissing && flag) {
				break;
			}
		}

		return new int[] { duplicateVal, missingVal };
	}

}
