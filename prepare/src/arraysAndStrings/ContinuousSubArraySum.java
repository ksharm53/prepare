package arraysAndStrings;

public class ContinuousSubArraySum {

	static int sum=0;
	static int counter=0;

	public static void main(String[] args) {
		int [] nums = {23,2,6,4,7};
		int k = 13;

		System.out.println(solve(nums,k));

		//System.out.println(bruteForceAgain(nums,k));

	}

	private static boolean bruteForce(int[] nums, int k) {

		int sum=0;
		int length=nums.length;

		if( length < 2) {
			return false;
		}

		for(int i=0; i<length-1; i++) {
			sum=0;
			for(int j=i+1; j < length; j++) {
				if(sum ==0) {
					int tempi=i;
					int tempk=j;
					while(tempi <= tempk) {
						sum= sum + nums[tempi];
						tempi++;
					}	
				}
				else {
					sum =sum + nums[j];
				}

				if(sum % k ==0) {
					return true;
				}
			}
		}
		return false;
	}


	private static boolean bruteForceAgain(int[] nums, int k) {

		int sum=0;
		int length=nums.length;

		if( length < 2) {
			return false;
		}

		for(int i=0; i<length-1; i++) {
			sum=nums[i];
			for(int j=i+1; j < length; j++) {
				sum =sum + nums[j];
               int mod= k==0?sum:sum%k;
				if(mod ==0) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean solve(int[] nums, int k) {

		int i=0;
		int j=0;
		int sum=0;
		boolean flag=false;

		if(nums.length < 2) {
			return false;
		}

		while(j < nums.length) {

			sum=sum+nums[j];
			if(j-i >=1 && sum % k == 0) {
				return true;
			}
			else if(j-i >=1 && sum % k != 0) {
				while(j-i > 1) {
					flag=true;
					sum=sum-nums[i];
					i++;
					if(j-i >=1 && sum % k == 0) {
						return true;
					}
				}
				if(flag) {
					int temp=0;
					while(j-temp >1) {
						sum=sum+nums[temp];
						temp++;
					}
					i=0;
					flag=false;
				}

				j++;
			}
			else {
				j++;
			}

		}

		return false;
	}

}
