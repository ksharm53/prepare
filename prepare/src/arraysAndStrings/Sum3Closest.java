package arraysAndStrings;

public class Sum3Closest {

	public static void main(String[] args) {
		int [] nums = {0,0,0};
		int target = 1;
		
		System.out.println(solve(nums,target));

	}

	private static int solve(int[] nums, int target) {
		
		int diff= Integer.MAX_VALUE;
		int sumResult = 0;
		
		if(nums.length <3) {
			return 0;
		}
		
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j <nums.length; j++) {
				for(int k=j+1; k <nums.length; k++) {
					int sum= nums[i]+ nums[j] + nums[k];
					int eachDiff=Math.abs(sum-target);
					if(eachDiff < diff) {
						diff=eachDiff;
						sumResult=sum;
					}
				}
			}
		}
		return sumResult;
	}

}
