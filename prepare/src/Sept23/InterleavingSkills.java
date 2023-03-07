package Sept23;

import java.util.HashMap;
import java.util.Map;

public class InterleavingSkills {
	static Map<String, Boolean> map;

	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";

		String s = Integer.toBinaryString(10);
		System.out.println(s);

		map = new HashMap<>();
		System.out.println(check(s1, s2, s3));

	}

	static boolean check(String A, String B, String C) {

		boolean bA = false;
		boolean bB = false;
		if (A.length() == 0 && B.length() == 0 && C.length() == 0) {
			return true;
		}
		if (C.length() == 0) {
			return false;
		}

		String val = A + "-" + B + "-" + C;
		if (map.containsKey(val)) {
			return map.get(val);
		}

		if (A.length() != 0 && A.charAt(0) == C.charAt(0)) {
			bA = check(A.substring(1), B, C.substring(1));
		}
		if (B.length() != 0 && B.charAt(0) == C.charAt(0)) {
			bB = check(A, B.substring(1), C.substring(1));
		}

		map.put(val, (bA || bB));
		return map.get(val);
	}

}
