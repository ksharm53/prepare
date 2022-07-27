package arraysAndStrings;

public class DistinctSubsequence {

	public static void main(String[] args) {
		String A="rabbbit";
		String B="rabbit";

		System.out.println(sample(A,B, A.length(), B.length()));
	}

	private static int sample(String A, String B, int sizeA, int sizeB) {
		
		int [][] matrixLocal= new int [sizeA+1][sizeB+1];

		for(int i=0; i<=sizeA; i++) {
			matrixLocal[i][0]=0;
		}

		for(int i=0; i<=sizeB; i++) {
			matrixLocal[0][i]=1;
		}

		for(int i=1; i<=sizeA; i++) {
			for(int j=1; j<=sizeB; j++) {
				if(A.charAt(i-1)==B.charAt(j-1)) {
					matrixLocal[i][j]= 1+matrixLocal[i-1][j-1];
				}
				else {
					matrixLocal[i][j]= Math.max(matrixLocal[i-1][j], matrixLocal[i][j-1]);
				}
			}
		}

		return matrixLocal[sizeA][sizeB];
	}

}
