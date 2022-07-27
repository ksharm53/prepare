package arraysAndStrings;

public class EqualSumSubset {

	public static void main(String[] args) {
		int nums []= {4,3,2,3,5,2,1};
		int count=4;

		System.out.println(solution(nums));

	}

	private static boolean solution(int[] nums) {

		int sum=0;

		for (Integer integer : nums) {
			sum+=integer;
		}

		if(sum%2 !=0) {
			return false;
		}

		else {
			int sumFind= sum/2;
			int vertical=nums.length+1;
			int horizontal=sumFind+1;
			boolean [][] matrix= new boolean[vertical][horizontal];

			for(int i=0; i<horizontal;i++) {
				matrix[0][i]= false;
			}

			for(int i=0; i<vertical;i++) {
				matrix[i][0]= true;
			}

			for(int i=1; i<vertical;i++) {
				for(int j=1; j<horizontal; j++) {
					if(nums[i-1] <= j) {
						matrix[i][j]= matrix[i-1][j-nums[i-1]] ||  matrix[i-1][j];
					}
					else {
						matrix[i][j]=matrix[i-1][j];
					}
				}     	
			}

			return matrix[nums.length][sumFind];

		}
	}

}
