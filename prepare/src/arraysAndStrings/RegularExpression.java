package arraysAndStrings;
public class RegularExpression {

	static int max= Integer.MIN_VALUE;
	static int aIndex;
	static int bIndex;
	static boolean [][] matrix;

	public static void main(String[] args) {
		String A = "aaaaaaaa";
		String B = "a*";

		matrix= new boolean [A.length()+1][B.length()+1];
		System.out.println(solve(A,B, A.length(), B.length()));
	}

	private static int solve(String a, String b, int sizeA, int sizeB) {

		for(int i=0;i<=a.length();i++){
			matrix[i][0]=false;
		}
		matrix[0][0]=true;
		for(int i=1;i<=b.length();i++){
			matrix[0][i]=true;
			for(int j=1;j<=i;j++){
				if(b.charAt(j-1) !='*'){
					matrix[0][i]=false;
					break;
				}
			}
		}

		for(int i=1; i<=sizeA; i++) {
			for(int j=1; j<=sizeB; j++) {

				if(a.charAt(i-1) == b.charAt(j-1) || b.charAt(j-1)=='?') {
					matrix[i][j]=matrix[i-1][j-1];
				}

				else if(b.charAt(j-1)=='*') {
					matrix[i][j]=matrix[i-1][j] || matrix[i][j-1];
				}
				else {
					matrix[i][j]=false;
				}
			}
		}
		return matrix[sizeA][sizeB]== true?1:0;			

	}

}
