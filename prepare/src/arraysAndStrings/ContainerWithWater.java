package arraysAndStrings;

public class ContainerWithWater {

	public static void main(String[] args) {
		int[] height= {1,1};

		System.out.println(solve(height,height.length));
	}

	private static int solve(int[] height, int length) {
		int max= Integer.MIN_VALUE;

		if(length <=1) {
			return 0;
		}

		else if(length==2) {
			return Math.min(height[length-1], height[length-2]) * 1;
		}

		for(int i=0; i<length; i++) {
			for(int j=i+1; j<length; j++) {
				max= Math.max(max, Math.min(height[i], height[j]) * (j-i));
			}
		}

		return max;
	}

}
