package newBeginning;

import java.util.HashMap;
import java.util.Map;

public class Main {

	static Map<Character, Integer> map;
	static int[] WEIGHTS = { 8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2 };

	public static void main(String[] args) {
		String str = "3GYFNEE36FS522428"; // Valid STring
		map = new HashMap<>();

		map.put('a', 1);
		map.put('b', 2);
		map.put('c', 3);
		map.put('d', 4);
		map.put('e', 5);
		map.put('f', 6);
		map.put('g', 7);
		map.put('h', 8);
		// map.put('i', 1);
		map.put('j', 1);
		map.put('k', 2);
		map.put('l', 3);
		map.put('m', 4);
		map.put('n', 5);
		// map.put('o', 9);
		map.put('p', 7);
		// map.put('q', 3);
		map.put('r', 9);
		map.put('s', 2);
		map.put('t', 3);
		map.put('u', 4);
		map.put('v', 5);
		map.put('w', 6);
		map.put('x', 7);
		map.put('y', 8);
		map.put('z', 9);

		System.out.println(is_vin_valid(str));

	}
	/*
	 * 
	 * Part 2: Another condition for a valid VIN is the following: The character in
	 * the 9th position matches the result of the checksum algorithm below
	 * 
	 * VIN Checksum algorithm: 1. Replace all of the letters from the VIN with their
	 * numeric counterparts. 2. Multiply each number with its index’s assigned
	 * weight. 3. Sum the resulting products. 4. Modulus the sum of the products by
	 * 11, to find the checksum. 5. If the checksum is 10, replace it with ‘X’.
	 * 
	 * TRANSLITERATIONS = { 'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5, 'f': 6, 'g': 7,
	 * 'h': 8, 'j': 1, 'k': 2, 'l': 3, 'm': 4, 'n': 5, 'p': 7, 'r': 9, 's': 2, 't':
	 * 3, 'u': 4, 'v': 5, 'w': 6, 'x': 7, 'y': 8, 'z': 9, }
	 * 
	 * WEIGHTS = [8, 7, 6, 5, 4, 3, 2, 10, 0, 9, 8, 7, 6, 5, 4, 3, 2]
	 * 
	 */

	public static boolean is_vin_valid(String str) {
		// int size = 0;
		if (str.length() != 17) {
			return false;
		}
		for (char each : str.toCharArray()) {
			// Only ALphaNUmeric
			if (!Character.isAlphabetic(each)) {
				return false;
			}

			// if char is i, o or q
			if (each == 'i' || each == 'o' || each == 'q') {
				return false;
			}
			// size++;
		}
		int checkSum = checkSum(str);
		char replaceChar = checkSum == 10 ? 'X' : (char) checkSum;
		if (str.charAt(9) != replaceChar) {
			return false;
		}

		return true;
	}

	private static int checkSum(String str) {
		//int[] array = new int[str.length()];
		long prefixSum = 0;
		for (int i = 0; i < str.length(); i++) {
			char each = str.charAt(i);

			int numericValue = 0;

			if (!Character.isDigit(each)) {
				char lowerCase = Character.toLowerCase(each);
				numericValue = map.get(lowerCase);
			} else {
				numericValue = Character.getNumericValue(each);
			}

			//array[i] = numericValue;

			long multiple = numericValue * WEIGHTS[numericValue];
			prefixSum += multiple;
		}

		// Mod
		int checkSum = (int) prefixSum % 11;
		return checkSum;
	}

}
