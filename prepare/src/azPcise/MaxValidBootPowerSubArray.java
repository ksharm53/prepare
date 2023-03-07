package azPcise;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Give you a list servers. Their processing power is given as a array of integer, and boot power as a array of integer.
Write a function to return the max length of sub array which's power consumption is less than or equal to max power limit.
Formula to calculate the power consumption for a subArray is:
Max(bootPower[i...j]) + Sum(processPower[i....j]) * length of subArray.
 */
public class MaxValidBootPowerSubArray {

	public static void main(String[] args) {
		int[] bootingPower = { 3, 6, 1, 3, 4 };
		int[] processingPower = { 2, 1, 3, 4, 5 };
		int powerMax = 25;

		System.out.println(solve(processingPower, bootingPower, powerMax));

	}

	public static int solve(int[] processingPower, int[] bootingPower, int maxPower) {
		if (processingPower.length != bootingPower.length) {
			return 0;
		}

		PriorityQueue<Integer> boot = new PriorityQueue<>(Comparator.reverseOrder());

		int maxLength = 0;
		// int currentLength = 1;

		int start = 0;
		int end = 0;
		int currentSumProcess=0;

		while (end < processingPower.length) {

			currentSumProcess += processingPower[end];
			boot.add(bootingPower[end]);

			int currentBootingPower = boot.peek();

			int powerConsumption = currentBootingPower + currentSumProcess * (end - start + 1);

			if (powerConsumption <= maxPower) {
				maxLength = (end - start + 1);
				end++;
			} else {
				currentSumProcess -= processingPower[start];
				boot.remove(bootingPower[start]);
				start++;
				end++;
			}
		}

		return maxLength;
	}

}
