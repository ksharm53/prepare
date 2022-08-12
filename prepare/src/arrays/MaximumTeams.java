package arrays;

import java.util.Arrays;

public class MaximumTeams {

	public static void main(String[] args) {
		int[] skill = { 3, 4, 3, 1, 6, 5 };
		int teamSize = 3;
		int maxDiff = 2;

		System.out.println(solve(skill, teamSize, maxDiff));

	}

	private static int solve(int[] skill, int teamSize, int maxDiff) {
		int i = 0;
		int j = 0;
		Arrays.sort(skill);

		int ans = 0;

		while (j < skill.length) {
			if (j - i + 1 < teamSize) {
				j++;
			} else if (j - i + 1 == teamSize) {
				if (skill[j] - skill[i] > maxDiff) {
					i++;
					j++;
				} else {
					i = i + 3;
					j++;
					ans++;
				}
			}
		}
		return ans;
	}

}
