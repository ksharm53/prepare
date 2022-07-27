package arraysAndStrings;
import java.util.Arrays;

public class PalindromePartitionLeetCode {
	public static void main(String[] args) {

		String s= "dVGAaVO25EmT6W3zSTEA0k12i64Kkmmli09Kb4fArlF4Gc2PknrlkevhROxUg";
		int i = 0;
		int j = s.length()-1;
		int min = Integer.MAX_VALUE;
		int[][] matrix = new int[501][501];

		for (int[] row: matrix) {
			Arrays.fill(row, -1);
		}

		System.out.println(sample(s,i,j,matrix,min));

	}

	private static int sample(String sb, int i, int j, int[][] matrix,int min) {		

		if(i>=j) {
			return 0;
		}

		if(matrix[i][j] != -1) {
			return matrix[i][j];
		}

		if(checkPalindrome(sb, i, j)) {
			return 0;
		}

		for(int k=i; k<=j-1; k++) {

			int tempSol= sample(sb, i, k, matrix, min) + sample(sb, k+1, j, matrix, min) + 1;

			if(tempSol < min) {
				min=tempSol;
			}
			matrix[i][j]=min;
		}

		return matrix[i][j];

	}

	private static boolean checkPalindrome(String sb, int i, int j) {

		if(i==j) {
			return true;
		}

		if(i>j) {
			return true;
		}

		while(i<j) {
			if(sb.charAt(i) != sb.charAt(j)) {
				return false;				
			}
			else {
				i++;
				j--;
			}
		}

		return true;
	}

}
