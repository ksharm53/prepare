package feb07;

public class MinOperations {

	public static void main(String[] args) {
		int n = 11;
		System.out.println(solve(n));

	}

	private static int solve(int n) {
		int count = 0;
		while (n > 0) {
			double valDoub = Math.log(n) / Math.log(2);
			int valInt = (int) (Math.log(n) / Math.log(2));
			if (valDoub == valInt) {
				count++;
				return count;
			}
			int val = findClosest(n);
			if (val == 0) {
				val = 1;
			}
			n = Math.abs(n - val);
			count++;
		}
		return count;
	}

	private static int findClosest(int n) {
		int temp = 1;
		while (temp < n) {
			temp = temp * 2;
		}
		temp /= 2;
		if (Math.abs(n - temp) < Math.abs(n - (temp * 2))) {
			return temp;
		} else {
			return temp * 2;
		}

	}

}
