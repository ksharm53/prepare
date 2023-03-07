package august23;

public class MaximumIndex {

	public static void main(String[] args) {
		int steps = 4;
		int badElement = 0;
		System.out.println(maximumIndex(steps, badElement));
	}

	static int maximumIndex(int N, int B) {
		int maxIndex = 0;

		for (int i = 1; i <= N; i++) {
			maxIndex += i;
		}

		int current_index = maxIndex;
		int step = N;

		while (true) {

			while (current_index > 0 && N > 0) {

				current_index -= N;
				if (current_index == B) {
					current_index += N;
				}
				N--;
			}

			if (current_index <= 0) {
				break;
			}

			else {
				N = step;
				current_index = maxIndex - 1;
				maxIndex--;
				if (current_index == B) {
					current_index = maxIndex - 1;
					maxIndex--;
				}
			}
		}
		return maxIndex;
	}

}
