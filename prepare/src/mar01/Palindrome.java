package mar01;

public class Palindrome {

	public static void main(String[] args) {
		String val="ABC";
		System.out.println(findPalindromeSubstring(val));
	}
	
	public static String findPalindromeSubstring(String str) {
	    String palindromeSubstring = "NONE";
	    int maxLength = 0;
	    for (int i = 0; i < str.length(); i++) {
	        // Check for odd length palindromes
	        int left = i;
	        int right = i;
	        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
	            int length = right - left + 1;
	            if (length > maxLength || (length == maxLength && str.substring(left, right+1).compareTo(palindromeSubstring) < 0)) {
	                maxLength = length;
	                palindromeSubstring = str.substring(left, right+1);
	            }
	            left--;
	            right++;
	        }
	        // Check for even length palindromes
	        left = i;
	        right = i+1;
	        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
	            int length = right - left + 1;
	            if (length > maxLength || (length == maxLength && str.substring(left, right+1).compareTo(palindromeSubstring) < 0)) {
	                maxLength = length;
	                palindromeSubstring = str.substring(left, right+1);
	            }
	            left--;
	            right++;
	        }
	    }
	    return palindromeSubstring;
	}


}
