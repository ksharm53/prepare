package mar01;

public class PassThePillow {

	public static void main(String[] args) {
		int n = 3;
		int time = 6;
		System.out.println(passThePillow(n, time));

	}

	public static int passThePillow(int n, int time) {
		if (time < n) {
			return time + 1;
		}

		int rotation = time / (n - 1);
		if (rotation % 2 == 0) {
			return (time % (n - 1)) + 1;
		} else {
			return n - (time % (n - 1));
		}

	}

}
