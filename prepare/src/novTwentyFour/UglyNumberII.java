package novTwentyFour;

import java.util.List;

public class UglyNumberII {

	public static void main(String[] args) {
		int n = 1690;
		int i = 1;
		while (n > 0) {
			if (findFactor(i)) {
				n--;
			}
			i++;
		}
		System.out.println(i - 1);

	}

	public static boolean findFactor(int n) {
		int c = 2;
		List<Integer> tempList = List.of(2, 3, 5);
		while (n > 1) {
			if (n % c == 0) {
				if (!tempList.contains(c)) {
					return false;
				}
				n /= c;
			} else {
				c++;
			}
		}
		return true;
	}

}
