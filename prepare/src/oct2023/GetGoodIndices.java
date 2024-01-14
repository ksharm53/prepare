package oct2023;

import java.util.ArrayList;
import java.util.List;

public class GetGoodIndices {

	public static void main(String[] args) {
		int[][] variables = { { 1000, 1000, 1000, 1000 }, { 3, 3, 3, 1 }, { 6, 1, 1, 4 } };
		int target = 1000;
		System.out.println(solve(variables, target));

	}

	private static List<Integer> solve(int[][] variables, int target) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < variables.length; i++) {
			int ai = variables[i][0];
			int bi = variables[i][1];
			int ci = variables[i][2];
			int mi = variables[i][3];

			long val = modPow(ai, bi, 10);
			long nextVal = modPow(val, ci, mi);
			if (nextVal == target) {
				list.add(i);
			}
		}
		return list;
	}

	private static long modPow(long base, int exponent, int mod) {
		long result = 1;
		long b = base % mod;
		while (exponent > 0) {
			if ((exponent & 1) != 0) {
				result = (result * b) % mod;
			}
			exponent >>= 1;
			b = (b * b) % mod;
		}
		return result;
	}

}
