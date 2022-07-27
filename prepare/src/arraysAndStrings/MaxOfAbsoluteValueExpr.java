package arraysAndStrings;

public class MaxOfAbsoluteValueExpr {

	public static void main(String[] args) {
		int [] arr1 = {1,2,3,4};
		int [] arr2 = {-1,4,5,6};

		System.out.println(solve(arr1, arr2));
	}

	private static int solve(int[] arr1, int[] arr2) {
		
		int maxi=0;
		int maxj=0;
		int maxlast= 0;

		int maxFinal= Integer.MIN_VALUE;

		if(arr1.length != arr2.length) {
			return 0;
		}

		for(int i=0; i<arr1.length; i++) {
			for(int j=i+1; j<arr1.length; j++) {
				maxi= Math.abs(arr1[i]-arr1[j]);

				maxj= Math.abs(arr2[i]-arr2[j]);

				maxlast=  Math.abs(i-j);

				maxFinal= Math.max(maxi +maxj+maxlast, maxFinal);
			}
		}
		return maxFinal;
	}

}
