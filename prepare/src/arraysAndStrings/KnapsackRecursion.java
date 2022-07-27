package arraysAndStrings;

public class KnapsackRecursion {

	public static void main(String[] args) {
		int wt []= {2,3,4,5,6};
		int value []= {10, 1, 5, 90, 1};
		int n= wt.length;
		int W=10;

		System.out.println(solution(wt, value, W, n));

	}

	private static int solution(int[] wt, int[] value, int W, int n) {
		
		//int [][] matrix= new int[n+1][W+1];

		if(W==0 || n==0) {
			return 0;
		}

		if(wt[n-1] <= W) {
			return Math.max(value[n-1] + solution(wt, value, W-wt[n-1], n-1), solution(wt, value, W, n-1)); 
		}
		else {
			return solution(wt, value, W, n-1);
		}

	}

}
