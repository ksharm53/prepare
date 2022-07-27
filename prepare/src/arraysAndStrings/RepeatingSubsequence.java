package arraysAndStrings;

public class RepeatingSubsequence {

	static int[][] matrix= new int [101][101];

	public static void main(String[] args) {
		String A="aabb";

		System.out.println(sample(A, A, A.length(), A.length()));

	}

	private static int sample(String A, String B, int sizeA, int sizeB) {

		if(sizeA ==0 || sizeB ==0) {
			return 0;
		}

		for(int i=0; i<=sizeA; i++) {
			matrix[0][i]=0;
		}

		for(int i=0; i<=sizeB; i++) {
			matrix[i][0]=0;
		}

		for(int i=1; i<=sizeA; i++) {
			for(int j=1; j<=sizeB; j++) {
				if(A.charAt(i-1)==B.charAt(j-1) && i!=j ) {
					matrix[i][j]= matrix[i-1][j-1]+1;
				}
				else {
					matrix[i][j]= Math.max(matrix[i-1][j], matrix[i][j-1]) ;
				}
			}
		}


		return matrix[sizeA][sizeB];
	}

}
