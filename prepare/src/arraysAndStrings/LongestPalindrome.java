package arraysAndStrings;

public class LongestPalindrome {

	public static void main(String[] args) {

		String s="cbbd";

		System.out.println(solution(s));
	}

	private static String solution(String s) {

		StringBuilder sb= new StringBuilder(s);		

		if(sb.length() ==0) {
			return "";
		}

		if (sb.reverse().toString().equalsIgnoreCase(s)) {
			return sb.toString();
		}
		else {
         return solution(s.substring(0, s.length()-1));
		}
	}

}
