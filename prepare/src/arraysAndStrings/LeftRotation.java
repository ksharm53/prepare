package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotation {

	public static void main(String[] args) {
		int d = 2;
		List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);		

		System.out.println(solve(arr, d));

	}

	private static List<Integer> solve(List<Integer> arr, int d) {
		int[] list = new int[arr.size()];
		List<Integer> listArray = new ArrayList<>();
		if (arr.size() == 0) {
			return listArray;
		}

		for (int i = 0; i < arr.size(); i++) {
			int position = (i - d + arr.size()) % arr.size();
			list[position] = arr.get(i);
		}

		for (int i : list) {
			listArray.add(i);
		}
		return listArray;
	}

}
