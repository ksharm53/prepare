package june;

public class MinimizeConcatenatedLength {

	static int min;

	public static void main(String[] args) {
		String[] words = { "tia", "yyaallzhe", "q", "o", "lzmpfuls", "dnnktjqm", "sly", "tkgbxq", "enfiproam", "mbf",
				"pt", "lhv", "hjcmwzvrf", "y", "lncqdddud", "ojmb", "ixextj", "rdjiuimil", "ecigeriqt" };
		min = Integer.MAX_VALUE;

		solve(words, "", 0);
		System.out.println(min);

	}

	private static void solve(String[] words, String curr, int idx) {
		if (idx == words.length) {
			min = Math.min(min, curr.length());
			return;
		}

		String StringIdx = words[idx];

		if (!curr.isEmpty() && !StringIdx.isEmpty() && curr.charAt(curr.length() - 1) == StringIdx.charAt(0)) {
			solve(words, curr.substring(0, curr.length() - 1) + StringIdx, idx + 1);

		}
		if (!StringIdx.isEmpty() && !curr.isEmpty() && StringIdx.charAt(StringIdx.length() - 1) == curr.charAt(0)) {
			solve(words, StringIdx.substring(0, StringIdx.length() - 1) + curr, idx + 1);

		}

		solve(words, curr + StringIdx, idx + 1);
		solve(words, StringIdx + curr, idx + 1);

	}

}
