package arraysAndStrings;
import java.util.Arrays;

public class OnesAndZeros {
	static int [][][] t= new int[601][101][101];

	public static void main(String[] args) {

		for (int[][] eachString : t) {
			for (int[] string : eachString) {
				Arrays.fill(string, -1);
			}
		}

		String [] strs = {"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"};
		int m = 44;
		int n = 39;
		System.out.println(solve(strs,m,n,strs.length));

	}

	private static int solve(String[] strs, int m, int n, int length) {

		if(length==0||(m<=0&&n<=0)) {
			return 0;
		}

		if(t[length][m][n] !=-1) {
			return t[length][m][n];	
		} 
		else {
			String value= strs[length-1];		
			int zeroCount=(int) value.chars().filter(each -> each=='0').count();
			int OneCount= (int) value.length() -zeroCount;

			if(zeroCount <=m && OneCount <=n) {
				return t[length][m][n]=Math.max(1+solve(strs, m-zeroCount, n-OneCount, length-1), solve(strs, m, n, length-1));
			}
			else {

				return t[length][m][n]=solve(strs, m, n, length-1);
			}
		}
	}


}
