package azPcise;

public class WheelCombinations {

	public static void main(String[] args) {
		int[] wheels = { 16 };

		System.out.println(solve(wheels));

	}

	private static int[] solve(int[] wheels) {
		int[] result = new int[wheels.length];
		if (wheels.length == 0) {
			return new int[] {};
		}

		for (int i = 0; i < wheels.length; i++) {
			int eachWheel = wheels[i];
			if (eachWheel % 2 != 0) {
				result[i] = 0;
			} else {
				result[i] = 1 + wheels[i] / 4;
			}

		}
		return result;
	}

}
