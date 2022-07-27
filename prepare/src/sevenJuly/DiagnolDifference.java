package sevenJuly;

import java.util.Arrays;
import java.util.List;

public class DiagnolDifference {

	public static void main(String[] args) {
		List<List<Integer>> arr = Arrays.asList(Arrays.asList(11,2,4), Arrays.asList(4, 5, 6), Arrays.asList(10,8,-12));
		System.out.println(solve(arr));
	}

	private static int solve(List<List<Integer>> arr) {
		if (arr.size() == 0) {
			return 0;
		}

		int i = 0;
		int j = 0;
		int rightDiagnol = 0;
		while (i < arr.size() && j < arr.get(0).size()) {
			rightDiagnol = rightDiagnol + arr.get(i).get(j);
			i++;
			j++;
		}

		int k = 0;
		int l = arr.get(0).size() - 1;
		int leftDoagnol = 0;
		while (k < arr.size() && l >= 0) {
			leftDoagnol = leftDoagnol + arr.get(k).get(l);
			k++;
			l--;
		}
		return Math.abs(leftDoagnol - rightDiagnol);
	}

}
