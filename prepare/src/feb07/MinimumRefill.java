package feb07;

public class MinimumRefill {

	public static void main(String[] args) {
		int[] plants = { 1, 2, 4, 4, 5 };
		int capacityA = 6;
		int capacityB = 5;

		// 5, 0
		// 3,1 > 1
		//

		System.out.println(solve(plants, capacityA, capacityB));

	}

	private static int solve(int[] plants, int capacityA, int capacityB) {
		int start = 0;
		int end = plants.length - 1;
		int alice = capacityA;
		int bob = capacityB;
		int refil = 0;

		while (start <= end) {
			if (start == end) {
				if (alice >= bob) {
					if (alice < plants[start]) {
						refil++;
						alice = capacityA;
					}
					alice -= plants[start];
					start++;
				} else if (bob > alice) {
					if (bob < plants[end]) {
						refil++;
						bob = capacityB;
					}
					bob -= plants[end];
					end--;
				}
			}

			else {
				if (alice < plants[start]) {
					refil++;
					alice = capacityA;
				}
				alice -= plants[start];
				start++;

				if (bob < plants[end]) {
					refil++;
					bob = capacityB;
				}
				bob -= plants[end];
				end--;

			}
		}

		return refil;
	}

}
