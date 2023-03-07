package newBeginning;

import java.util.Arrays;
import java.util.List;

public class PickFromBothSides {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961,
				-509, -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447, 726, -229, 538,
				869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336, 141, 711, -747, -132, 547, 644, -338,
				-243, -963, -141, -277, 741, 529, -222, -684, 35);
		System.out.println(solve(list, 48));

	}

	public static int solve(List<Integer> A, int B) {
		int window = A.size() - B;
		int i = 0;
		int j = 0;
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int total = 0;
		for (Integer integer : A) {
			total += integer;
		}

		while (j < A.size()) {
			sum += A.get(j);
			if (j - i + 1 < window) {
				j++;
			} else if (j - i + 1 == window) {
				max = Math.max(max, total - sum);
				sum -= A.get(i);
				i++;
				j++;
			}
		}
		return max;
	}

}
