package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class SubsetSum {

	public static void main(String[] args) {
		List<Integer> A= Arrays.asList(3, 34, 4, 12, 5, 2);
		int B=37;

		boolean [][] matrix= new boolean[A.size()+1][B+1]; 

		System.out.println(solution(matrix, B, A));
	}

	private static boolean solution(boolean[][] matrix, int B, List<Integer> A) {

		int n=A.size();

		for(int i=0; i<B+1; i++) {
			matrix[0][i]=false;
		}

		for(int i=0; i<n+1; i++) {
			matrix[i][0]=true;
		}

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<B+1; j++) {

				if(A.get(i-1)<=j) {
					matrix[i][j]= matrix[i][j-A.get(i-1)] || matrix[i-1][j];
				}

				else {
					matrix[i][j]=matrix[i-1][j];
				}
			}
		}

		return matrix[n][B];

	}

}
