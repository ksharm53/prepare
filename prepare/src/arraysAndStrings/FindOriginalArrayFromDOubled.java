package arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class FindOriginalArrayFromDOubled {

	public static void main(String[] args) {
		int[] changed = { 2, 1, 2, 4, 2, 4 };
		System.out.println(findOriginalArray(changed));
	}

	public static int[] findOriginalArray(int[] changed) {

		if (changed.length % 2 != 0) {
			return new int[] {};
		}
		Arrays.sort(changed);

		ArrayList<Integer> list = new ArrayList<>();

		for (Integer integer : changed) {
			list.add(integer);
		}

		// Collections.sort(list);
		int[] retunArray = new int[changed.length / 2];
		int counter = 0;

		while (!list.isEmpty()) {
			int temp = list.get(0);
			int doubleVal = temp * 2;
			if (list.contains(doubleVal)) {
				retunArray[counter] = temp;
				counter++;
				list.remove(Integer.valueOf(temp));
				list.remove(Integer.valueOf(doubleVal));
			} else {
				return new int[] {};
			}
		}

		return retunArray;

	}

}
