package arraysAndStrings;

import java.util.Arrays;
import java.util.List;

public class ZeroOneKnapsackTopDown {

	public static void main(String[] args) {
		List<Integer> A= Arrays.asList( 647, 363, 887, 876, 434, 870, 143, 845, 417, 882, 999, 323, 652, 22, 700, 558, 477, 893, 390, 76, 713, 601, 511, 4, 870, 862, 689, 402, 790);
		List<Integer> B= Arrays.asList( 256, 424, 3, 86, 183, 286, 89, 427, 118, 258, 333, 433, 170, 155, 222, 190, 477, 330, 369, 193, 426, 56, 435, 50, 442, 13, 146, 61, 219);

		int N=754;

		System.out.println(solution(A,B,N, A.size()));

	}

	private static int solution(List<Integer> A, List<Integer> B, int C, int n){        

		int [][] matrix= new int[n+1][C+1];

		for(int i=0; i<C+1; i++) {
			matrix[0][i]=0;
		}

		for(int i=0; i<n+1; i++) {
			matrix[i][0]=0;
		}

		for(int i=1; i<n+1; i++) {
			for(int j=1; j<C+1; j++) {

				if(B.get(i-1) <= j) {
					matrix[i][j]= Math.max((A.get(i-1)+ matrix[i-1][j-B.get(i-1)]) , matrix[i-1][j]);
				}

				else {
					matrix[i][j]=matrix[i-1][j];
				}
			}
		}

		return matrix[n][C];
	}

}
