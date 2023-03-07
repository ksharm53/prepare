package newBeginning;

public class MiscClass {

	public static void main(String[] args) {
		int a = 8;
		int b = 3;
		int c = 2;
		System.out.println(solution(a, b, c));

	}

	static boolean solution(int a, int b, int c) {
		if (a * b == c || a + b == c || a - b == c || (b != 0 && a % b == 0 && a / b == c)) {
			return true;
		}
		return false;

	}

}
