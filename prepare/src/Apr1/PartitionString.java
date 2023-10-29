package Apr1;

import java.util.HashSet;
import java.util.Set;

public class PartitionString {

	static Set<Character> set;

	public static void main(String[] args) {
		String s = "abacaba";
		set = new HashSet<>();

		System.out.println(partitionString(s));
	}

	public static int partitionString(String s) {

		int partition = 1;

		for (int i = 0; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				set.clear();
				partition++;
			}
			set.add(s.charAt(i));
		}

		return partition;
	}

}
