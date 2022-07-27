package arraysAndStrings;

public class Sum3 {

	public static void main(String[] args) {
		int [] nums= {3,3};
		int target= 6;

		System.out.println(solve(nums, target));

	}

	private static int[] solve(int[] nums, int target) {

		int[] list= new int[2];
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if(nums[i]+ nums[j]==target) {
					list[0]=i;
					list[1]=j;
					return list;
				}
			}
		}
		return list;
	}

}
