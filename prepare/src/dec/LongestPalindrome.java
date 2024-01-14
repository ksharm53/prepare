package dec;

import java.util.Arrays;

public class LongestPalindrome {

	static int[][] matrix;
	static String max;

	public static void main(String[] args) {
		String s = "mqizdjrfqtmcsruvvlhdgzfrmxgmmbguroxcbhalzggxhzwfznfkrdwsvzhieqvsrbyedqxwmnvovvnesphgddoikfwuujrhxwcrbttfbmlayrlmpromlzwzrkjkzdvdkpqtbzszrngczvgspzpfnvwuifzjdrmwfadophxscxtbavrhfkadhxrmvlmofbzqshqxazzwjextdpuszwgrxirmmlqitjjpijptmqfbggkwaolpbdglmsvlwdummsrdyjhmgrasrblpjsrpkkgknsucsshjuxunqiouzrdwwooxclutkrujpfebjpoodvhknayilcxjrvnykfjhvsikjabsdnvgguoiyldshbsmsrrlwmkfmyjbbsylhrusubcglaemnurpuvlyyknbqelmkkyamrcmjbncpafchacckhymtasylyfjuribqxsekbjkgzrvzjmjkquxfwopsbjudggnfbuyyfizefgxamocxjgkwxidkgursrcsjwwyeiymoafgyjlhtcdkgrikzzlenqgtdukivvdsalepyvehaklejxxmmoycrtsvzugudwirgywvsxqapxyjedbdhvkkvrxxsgifcldkspgdnjnnzfalaslwqfylmzvbxuscatomnmgarkvuccblpoktlpnazyeazhfucmfpalbujhzbykdgcirnqivdwxnnuznrwdjslwdwgpvjehqcbtjljnxsebtqujhmteknbinrloregnphwhnfidfsqdtaexencwzszlpmxjicoduejjomqzsmrgdgvlrfcrbyfutidkryspmoyzlgfltclmhaeebfbunrwqytzhuxghxkfwtjrfyxavcjwnvbaydjnarrhiyjavlmfsstewtxrcifcllnugldnfyswnsewqwnvbgtatccfeqyjgqbnufwttaokibyrldhoniwqsflvlwnjmffoirzmoxqxunkuepj";
		matrix = new int[s.length() + 1][s.length() + 1];
		for (int[] arr : matrix) {
			Arrays.fill(arr, -1);
		}
		max = "";
		System.out.println(solve(s, 0, s.length()));
		System.out.println(max);
	}

	private static int solve(String s, int low, int high) {
		if (low > high) {
			return 0;
		}
		if (matrix[low][high] != -1) {
			return matrix[low][high];
		}
		String subString = s.substring(low, high);
		if (isPalindrome(subString)) {
			if (subString.length() > max.length()) {
				max = subString;
			}
			return matrix[low][high] = (high - low);
		}

		int one;
		int two;
		int three;
		if (matrix[low + 1][high] != -1) {
			one = matrix[low + 1][high];
		} else {
			one = solve(s, low + 1, high);
			matrix[low + 1][high] = one;
		}

		if (matrix[low][high - 1] != -1) {
			two = matrix[low][high - 1];
		} else {
			two = solve(s, low, high - 1);
			matrix[low][high - 1] = two;
		}

		if (matrix[low + 1][high - 1] != -1) {
			three = matrix[low + 1][high - 1];
		} else {
			three = solve(s, low + 1, high - 1);
			matrix[low + 1][high - 1] = three;
		}

		return matrix[low][high] = Math.max(Math.max(one, two), three);

	}

	private static boolean isPalindrome(String substring) {
		StringBuilder sb = new StringBuilder(substring);
		sb.reverse();

		return sb.toString().equals(substring);
	}

}
