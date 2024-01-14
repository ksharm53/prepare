package oct2023;

import java.util.Arrays;
import java.util.List;

public class PlaySegments {

	public static void main(String[] args) {
		List<Integer> coins = Arrays.asList(1, 1, 0, 1);
		System.out.println(solve(coins));

	}

	private static int solve(List<Integer> coins) {
		int oneCount = 0;
		int zeroCount = 0;
		for (Integer each : coins) {
			if (each == 0) {
				zeroCount++;
			} else {
				oneCount++;
			}
		}
		int player1Score = 0;
		int player2Score = 0;
		int round = 0;

		for (int i = 0; i < coins.size(); i++) {
			player2Score = oneCount - zeroCount;
			if (player1Score > player2Score) {
				break;
			}
			round++;

			if (coins.get(i) == 0) {
				player1Score--;
				zeroCount--;
			} else {
				player1Score++;
				oneCount--;
			}
		}

		return round;
	}

}
