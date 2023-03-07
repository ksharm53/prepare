package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JumpGameII {

	static int min;
	static int[] matrix;
	static Map<Integer, Boolean> map;

	public static void main(String[] args) {
		int[] nums = { 9997, 9997, 9996, 9995, 9994, 9993, 9992, 9991, 9990, 9989, 9988, 9987, 9986, 9985, 9984, 9983,
				9982, 9981, 9980, 9979, 9978, 9977, 9976, 9975, 9974, 9973, 9972, 9971, 9970, 9969, 9968, 9967, 9966,
				9965, 9964, 9963, 9962, 9961, 9960, 9959, 9958, 9957, 9956, 9955, 9954, 9953, 9952, 9951, 9950, 9949,
				9948, 9947, 9946, 9945, 9944, 9943, 9942, 9941, 9940, 9939, 9938, 9937, 9936, 9935, 9934, 9933, 9932,
				9931, 9930, 9929, 9928, 9927, 9926, 9925, 9924, 9923, 9922, 9921, 9920, 9919, 9918, 9917, 9916, 9915,
				9914, 9913, 9912, 9911, 9910, 9909, 9908, 9907, 9906, 9905, 9904, 9903, 9902, 9901, 9900, 9899, 9898,
				9897, 9896, 9895, 9894, 9893, 9892, 9891, 9890, 9889, 9888, 9887, 9886, 9885, 9884, 9883, 9882, 9881,
				9880, 9879, 9878, 9877, 9876, 9875, 9874, 9873, 9872, 9871, 9870, 9869, 9868, 9867, 9866, 9865, 9864,
				9863, 9862, 9861, 9860, 9859, 9858, 9857, 9856, 9855, 9854, 9853, 9852, 9851, 9850, 9849, 9848, 9847,
				9846, 9845, 9844, 9843, 9842, 9841, 9840, 9839, 9838, 9837, 9836, 9835, 9834, 9833, 9832, 9831, 9830,
				9829, 9828, 9827, 9826, 9825, 9824, 9823, 9822, 9821, 9820, 9819, 9818, 9817, 9816, 9815, 9814, 9813,
				9812, 9811, 9810, 9809, 9808, 9807, 9806, 9805, 9804, 9803, 9802, 9801, 9800, 9799, 9798, 9797, 9796,
				9795, 9794, 9793, 9792, 9791, 9790, 9789, 9788, 9787, 9786, 9785, 9784, 9783, 9782, 9781, 9780, 9779,
				9778, 9777, 9776, 9775, 9774, 9773, 9772, 9771, 9770, 9769, 9768, 9767, 9766, 9765, 9764, 9763, 9762,
				9761, 9760, 9759, 9758, 9757, 9756, 9755, 9754, 9753, 9752, 9751, 9750, 9749, 9748, 9747, 9746, 9745,
				9744, 9743, 9742, 9741, 9740, 9739, 9738, 9737, 9736, 9735, 9734, 9733, 9732, 9731, 9730, 9729, 9728,
				9727, 9726, 9725, 9724, 9723, 9722, 9721, 9720, 9719, 9718, 9717, 9716, 9715, 9714, 9713, 9712, 9711,
				9710, 9709, 9708, 9707, 9706, 9705, 9704, 9703, 9702, 9701, 9700, 9699, 9698, 9697, 9696, 9695, 9694,
				9693, 9692, 9691, 9690, 9689, 9688, 9687, 9686, 9685, 9684, 9683, 9682, 9681, 9680, 9679, 9678, 9677,
				9676, 9675, 9674, 9673, 9672, 9671, 9670, 9669, 9668, 9667, 9666, 9665 };
		min = 1000111;

		matrix = new int[nums.length + 1];
		map = new HashMap<>();

		Arrays.fill(matrix, -1);

		// System.out.println(solve(nums, 0, nums.length - 1));
		System.out.println(solveJumpGame(nums, 0, nums.length - 1));
	}

	private static int solve(int[] nums, int start, int end) {

		if (matrix[start] != -1) {
			return matrix[start];
		}

		if (start >= end) {
			return matrix[start] = 0;
		}

		int range = start + nums[start];

		for (int i = start + 1; i <= range && i < nums.length; i++) {
			min = Math.min(min, 1 + solve(nums, i, end));
		}
		return matrix[start] = min;

	}

	public static boolean solveJumpGame(int[] nums, int start, int length) {
		int range = start + nums[start];

		if (map.getOrDefault(start, false)) {
			return map.get(start);
		}

		if (range >= length) {
			map.put(start, true);
			return true;
		}

		for (int i = start + 1; i <= range && i < nums.length; i++) {
			if (solveJumpGame(nums, i, length)) {
				map.put(start, true);
				return true;
			}
		}
		map.put(start, false);
		return false;
	}

}