package jan2023;

public class ClosetTarget {

	public static void main(String[] args) {
		String[] words = { "hsdqinnoha", "mqhskgeqzr", "zemkwvqrww", "zemkwvqrww", "daljcrktje", "fghofclnwp",
				"djwdworyka", "cxfpybanhd", "fghofclnwp", "fghofclnwp" };
		String target = "zemkwvqrww";
		int startIndex = 8;

		System.out.println(closetTarget(words, target, startIndex));

	}

	public static int closetTarget(String[] words, String target, int startIndex) {
		int length = words.length;
		int nextCount = 0;
		int rightCount = 0;
		int nextIdx = startIndex;
		int prevIdx = startIndex;
		if (words[startIndex] == target) {
			return 0;
		}
		while (length > 0) {
			nextIdx = (nextIdx + 1) % length;
			prevIdx = (prevIdx - 1 + length) % length;
			nextCount++;
			rightCount++;
			if (words[nextIdx].equals(target)) {
				return nextCount;
			}
			if (words[prevIdx].equals(target)) {
				return rightCount;
			}

			length--;
		}

		return -1;
	}

}
