package arraysAndStrings;
import java.util.Arrays;

public class LongestCommonSubsequenceRecursion {

	public static void main(String[] args) {
		String text1 = "abc";
		String text2 = "abc"; 

		System.out.println(solutionRecursive(text1, text2, text1.length(), text2.length()));

		//System.out.println(solutionTopDown(text1, text2, text1.length(), text2.length()));
		
	}

	private static int solutionTopDown(String text1, String text2, int length, int length2) {
		
		int horizontal= length+1;
		int vertical= length2+1;
		
		int matrix [][]= new int[vertical][horizontal];
		
		for(int i=0; i<vertical; i++) {
			matrix[i][0]=0;
		}
		
		for(int i=0; i<horizontal; i++) {
			matrix[0][i]=0;
		}
		
		for(int i=1; i<vertical; i++) {
			for(int j=1; j<horizontal; j++) {
				if(text2.charAt(i-1)==text1.charAt(j-1)) {
					matrix[i][j]= 1 + matrix[i-1][j-1];
				}
				else {
					matrix[i][j]=Math.max(matrix[i][j-1],matrix[i-1][j]);
				}
			}
		}
		
		return matrix[vertical-1][horizontal-1];
	}

	private static int solutionRecursive(String text1, String text2, int length, int length2) {

		int matrix [][]= new int[1001][1001];

		for (int[] row: matrix)
		    Arrays.fill(row, -1);
		
		if(length ==0 || length2 ==0) {
			return 0;
		}
		
		if(matrix[length][length2] !=-1) {
			return matrix[length][length2];
		}

		if(text1.charAt(length-1)==text2.charAt(length2-1)) {
			return matrix[length][length2]=1 + solutionRecursive(text1, text2, length-1, length2-1);
		}
		else {
			return matrix[length][length2]=Math.max(solutionRecursive(text1, text2, length-1, length2), solutionRecursive(text1, text2, length, length2-1));
		}

	}
}
