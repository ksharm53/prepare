package may1;

public class IsWinner {

	public static void main(String[] args) {
		int[] player1 = { 2, 3 };
		int[] player2 = { 4, 1 };

		System.out.println(solve(player1, player2));

	}

	private static int solve(int[] player1, int[] player2) {
		int size = player1.length;
		int player1Scope = -1;
		int player2Scope = -1;

		int player1Count = 0;
		int player2Count = 0;

		for (int i = 0; i < size; i++) {
			// player 1
			if (i <= player1Scope) {
				player1Count += (2 * player1[i]);
			} else {
				player1Count += player1[i];
			}
			if (player1[i] == 10) {
				player1Scope = i + 2;
			}

			// player 2
			if (i <= player2Scope) {
				player2Count += (2 * player2[i]);
			} else {
				player2Count += player2[i];
			}
			if (player2[i] == 10) {
				player2Scope = i + 2;
			}
		}

		System.out.println(player1Count);
		System.out.println(player2Count);

		if (player1Count > player2Count) {
			return 1;
		} else if (player2Count > player1Count) {
			return 2;
		} else {
			return 0;
		}
	}

}
