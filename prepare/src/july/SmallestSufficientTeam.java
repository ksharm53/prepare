package july;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SmallestSufficientTeam {

	static List<Integer> finalList;
	static int min;

	public static void main(String[] args) {
		String[] req_skills = { "gvp", "jgpzzicdvgxlfix", "kqcrfwerywbwi", "jzukdzrfgvdbrunw", "k" };
		List<List<String>> people = List.of(List.of(), List.of(), List.of(), List.of(), List.of("jgpzzicdvgxlfix"),
				List.of("jgpzzicdvgxlfix", "k"), List.of("jgpzzicdvgxlfix", "kqcrfwerywbwi"), List.of("gvp"),
				List.of("jzukdzrfgvdbrunw"), List.of("gvp", "kqcrfwerywbwi"));

		Set<String> set = new HashSet<>();

		finalList = new ArrayList<>();

		min = Integer.MAX_VALUE;

		for (String each : req_skills) {
			set.add(each);
		}

		solve(set, people, 0, new ArrayList<Integer>());

		System.out.println(finalList);

		int[] res = new int[finalList.size()];
		for (int i = 0; i < finalList.size(); i++) {
			res[i] = finalList.get(i);
		}

		System.out.println(res);

	}

	private static void solve(Set<String> req_skills, List<List<String>> people, int idx, List<Integer> tempList) {
		if (req_skills.isEmpty()) {
			System.out.println("---------------------------" + tempList);
			if (tempList.size() < min) {
				min = tempList.size();
				finalList = new ArrayList<>(tempList);

				if (!tempList.isEmpty()) {
					int lastElement = tempList.get(tempList.size() - 1);
					for (String eachSkill : people.get(lastElement)) {
						req_skills.add(eachSkill);
					}
					tempList.remove(tempList.size() - 1);
				}

			}
		}

		if (idx >= people.size()) {
			return;
		}

		List<String> skills = people.get(idx);

		for (String eachSkill : skills) {
			req_skills.remove(eachSkill);
		}
		tempList.add(idx);
		// liya
		solve(req_skills, people, idx + 1, tempList);

		// nai liya

		solve(req_skills, people, idx + 1, tempList);

		if (!tempList.isEmpty()) {
			int lastElement = tempList.get(tempList.size() - 1);
			for (String eachSkill : people.get(lastElement)) {
				req_skills.add(eachSkill);
			}
			tempList.remove(tempList.size() - 1);
		}

	}

}
