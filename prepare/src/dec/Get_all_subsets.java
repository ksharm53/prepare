package dec;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Get_all_subsets {

	public static void main(String[] args) {
		int[] myints = new int[] { 2, 3, 4 };
		List<Integer> v = new ArrayList<Integer>();
		for (Integer i : myints) {
			v.add(i);
		}
		List<Set<Integer>> subsets = new ArrayList<Set<Integer>>();

		get_all_subsets(v, subsets, 0, new HashSet<Integer>());

		System.out.println("****Total*****" + subsets.size());
		for (int i = 0; i < subsets.size(); ++i) {
			System.out.print("{");
			for (Integer it : subsets.get(i)) {
				System.out.print(it + ", ");
			}
			System.out.println("}");
		}
		System.out.println("****Total*****" + subsets.size());
	}

	private static void get_all_subsets(List<Integer> v, List<Set<Integer>> subsets, int idx, Set<Integer> eachSet) {
		if (idx == v.size()) {
			subsets.add(eachSet);
			return;
		}

		Set<Integer> newSet = new HashSet<>(eachSet);
		newSet.add(v.get(idx));

		get_all_subsets(v, subsets, idx + 1, eachSet);
		get_all_subsets(v, subsets, idx + 1, newSet);
	}
}
