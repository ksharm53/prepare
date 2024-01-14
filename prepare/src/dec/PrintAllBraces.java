package dec;

import java.util.ArrayList;

public class PrintAllBraces {
	static ArrayList<ArrayList<Character>> result;

	public static void main(String[] args) {
		result = new ArrayList<>();
		printAllBraces(3, 3, 3, new ArrayList<Character>());
		System.out.println(result);
	}

	private static void printAllBraces(int total, int open, int close, ArrayList<Character> list) {
		if (open == 0 && close == 0) {
			result.add(list);
			return;
		}

		if (list.isEmpty() && open > 0) {
			list.add('{');
			printAllBraces(total, open - 1, close, list);
		}

		else if ((total - open) <= (total - close)) {
			list.add('{');
			printAllBraces(total, open - 1, close, list);
		} else {

			ArrayList<Character> temp = new ArrayList<>(list);
			if (open > 0) {
				list.add('{');
				printAllBraces(total, open - 1, close, list);
			}
			if (close > 0) {
				temp.add('}');
				printAllBraces(total, open, close - 1, temp);
			}
		}

	}

}
