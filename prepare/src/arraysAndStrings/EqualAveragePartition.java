package arraysAndStrings;
import java.util.Arrays;
import java.util.List;

public class EqualAveragePartition {

	public static void main(String[] args) {
		List<Integer> A= Arrays.asList(2, 7, 15, 29, 11, 9);

		int count=0;
		for (Integer integer : A) {
			count= count+integer;
		}

		System.out.println(sample(A,A.size(),9));

	}

	private static int sample(List<Integer> a,int length, int size) {

		if(length <=0) {
			return 0;
		}

		if(a.get(length-1) <=size) {
			return 1+ sample(a,length-1,size - a.get(length-1)) + sample(a, length-1, size);
		}
		else {
			return sample(a, length-1, size);
		}
	}

}
