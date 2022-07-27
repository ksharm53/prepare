package arraysAndStrings;

public class MinimumCoinKnapsackRecursive {

	public static void main(String[] args) {
		int [] coins = {1};
		int amount = 11;

		System.out.println(solution(coins,amount, coins.length));

	}

	private static int solution(int[] coins, int amount, int n) {

		if(amount==0) {
			return 0;
		}
		if(coins[n-1] <= amount) {

			return Math.min(1 + solution(coins, amount-coins[n-1], n),solution(coins, amount, n-1));
		}
		else {
			return solution(coins, amount, n-1);
		}
	}

}
