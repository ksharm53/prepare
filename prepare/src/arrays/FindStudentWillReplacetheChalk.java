package arrays;

public class FindStudentWillReplacetheChalk {

	public static void main(String[] args) {
		int[] chalk = { -3, -4, 1, 2 };
		int k = 25;

		System.out.println(solve(chalk, k));
	}

	private static int solve(int[] chalk, int k) {
		long total = 0;

		for (int i : chalk) {
			total = total + i;
		}
		long value = k % total;
		if (value == 0) {
			return 0;
		}
		for (int i = 0; i < chalk.length; i++) {
			value = value - chalk[i];
			if (value < 0) {
				return i;
			} else if (value == 0) {
				return i + 1;
			} else {
				continue;
			}
		}
		return -1;
	}

}
