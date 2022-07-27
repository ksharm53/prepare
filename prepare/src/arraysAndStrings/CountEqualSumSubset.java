package arraysAndStrings;

public class CountEqualSumSubset {

	public static void main(String[] args) {
		int nums []= {4,3,2,3,5,2,1};
		int count=4;

		System.out.println(solution(nums,count));

	}

	private static int solution(int[] nums, int count) {

		int sum=0;

		for (Integer integer : nums) {
			sum+=integer;
		}

		int sumFind=sum/count;

		int vertical=nums.length+1;
		int horizontal=sumFind+1;
		int [][] matrix= new int[vertical][horizontal];

		for(int i=0; i<horizontal;i++) {
			matrix[0][i]= 0;
		}

		for(int i=0; i<vertical;i++) {
			matrix[i][0]= 1;
		}

		for(int i=1; i<vertical;i++) {
			for(int j=1; j<horizontal; j++) {
				if(nums[i-1] <= j) {
					matrix[i][j]= matrix[i-1][j-nums[i-1]] + matrix[i-1][j];
				}
				else {
					matrix[i][j]=matrix[i-1][j];
				}
			}     	
		}

		return matrix[nums.length][sumFind];

	}

}
