package arraysAndStrings;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		String s = "pwwkew";

		System.out.println(solve(s));

	}

	private static int solve(String s) {

		int max= Integer.MIN_VALUE;
		
		if(s.length()==0) {
			return 0;
		}

		StringBuilder current=new StringBuilder();

		char[] charArray= s.toCharArray();

		for(int i=0; i<charArray.length ; i++) {
			current=new StringBuilder();
			current.append(charArray[i]);
			for(int j=i+1; j<charArray.length; j++) {
				if(current.toString().contains(Character.toString(charArray[j]))) {
					break;
				}
				else {
					current.append(charArray[j]);
				}				
			}
			max= Math.max(max, current.length());
		}

		return max;
	}

}
