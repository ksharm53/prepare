package Oct13;

public class BinaryGame {

	public static void main(String[] args) {
		int min_length = 1;
		int max_length = 3;
		int one_group = 2;
		int zero_group = 1;
		System.out.println(solve(min_length, max_length, one_group, zero_group));

	}

	private static int solve(int min_length, int max_length, int one_group, int zero_group) {
		int count = 0;

		for (int i = min_length; i <= max_length; i++) {
			StringBuilder sb = new StringBuilder();

			for (int j = 0; j < i; j++) {
				sb.append("0");
			}

			while (true) {

				boolean flag = true;
				int zc = 0, oc = 0;

				for (int j = 0; j < sb.length(); j++) {

					if (sb.charAt(j) == '1') {
						if (oc == one_group) {
							flag = false;
							break;
						}
						oc = 0;
						zc = 0;
					} else {
						if (zc == zero_group) {
							flag = false;
							break;
						}
						zc = 0;
						oc = 0;
					}

					if (sb.charAt(j) == '0')
						zc++;

					if (sb.charAt(j) == '1')
						oc++;
				}

				if (flag)
					count++;

				if (sb.charAt(0) == '1')
					break;

				int k = i - 1;
				while (k >= 0) {
					if (sb.charAt(k) == '1') {
						sb.replace(k, k + 1, "0");
						k--;
					} else {
						sb.replace(k, k + 1, "1");
						break;
					}
				}
			}
		}

		return count;
	}
}
