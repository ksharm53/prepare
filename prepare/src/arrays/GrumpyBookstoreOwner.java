
package arrays;

public class GrumpyBookstoreOwner {

	public static void main(String[] args) {
		int[] customers = { 1 };
		int[] grumpy = { 0 };
		int minutes = 3;

		System.out.println(solve(customers, grumpy, minutes));

	}

	private static int solve(int[] customers, int[] grumpy, int minutes) {
		int n = customers.length;
		int happyCustomer = 0;
		int max = 0;

		for (int i = 0; i < n; i++) {
			if (grumpy[i] == 0) {
				happyCustomer += customers[i];
			}
		}

		int i = 0;
		int j = 0;

		while (j < n) {
			if (grumpy[j] == 1) {
				happyCustomer += customers[j];
			}
			if (j - i + 1 < minutes) {
				j++;

			} else if (j - i + 1 == minutes) {
				max = Math.max(max, happyCustomer);
				if (grumpy[i] == 1) {
					happyCustomer -= customers[i];
				}
				i++;
				j++;
			}

		}
		return max;
	}

}
