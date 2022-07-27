package arraysAndStrings;

public class ReverseInteger {

	static int maxValue= Integer.MAX_VALUE;
	static int minValue= Integer.MIN_VALUE;

	public static void main(String[] args) {
		int x = -2147483648;

		System.out.println(sample(x));
	}

	private static int sample(int x) {

		if(x==0) {
			return 0;
		}
		else if(x <=minValue || x>=maxValue) {
			return 0;
		}
		else if(x < 0) {
			return handleNegative(Math.abs(x));
		}
		else {
			return handlePositive(x);			
		}

	}

	private static int handleNegative(int x) {

		long result= Long.valueOf(generic(x).toString());

		result= result * -1;

		return (int) (result <= minValue ? 0:result);

	}

	private static int handlePositive(int x) {

		long result= Long.valueOf(generic(x).toString());

		return (int) (result >= maxValue ? 0: result);

	}

	private static StringBuilder generic(int x) {

		StringBuilder sb= new StringBuilder();

		while(x > 9) {
			sb.append(x%10);
			x=x/10;
		}
		sb.append(x);
		return sb;
	}



}
