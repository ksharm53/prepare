package arraysAndStrings;

public class BackSpacing {

	static int counter=0;

	public static void main(String[] args) {		

		String s="bxj##tw";
		String t="bxo#j##tw";


		System.out.println(solve(s,t));

	}

	private static boolean solve(String s, String t) {

		if(s.length()==0 && t.length()==0) {
			return true;
		}

		StringBuilder sb= new StringBuilder(s);
		StringBuilder tb= new StringBuilder(t);

		for(int i=sb.length()-1; i>=0; i--) {
			while(i>=0 && sb.charAt(i)=='#') {
				counter++;
				sb.deleteCharAt(i);
				i--;
			}
			while(counter>0 && i>=0) {
				if(sb.charAt(i)!='#') {
					sb.deleteCharAt(i);
					counter --;
					i= counter==0 ?i:i-1;
				}
				else {
					counter++;
					sb.deleteCharAt(i);
					i--;
				}
			}
		}

		counter=0;

		for(int i=tb.length()-1; i>=0; i--) {
			while(i>=0 && tb.charAt(i)=='#') {
				counter++;
				tb.deleteCharAt(i);
				i--;
			}
			while(counter>0 && i>=0) {
				if(tb.charAt(i)!='#') {
					tb.deleteCharAt(i);
					counter --;
					i= counter==0 ?i:i-1;	
				}
				else {
					counter++;
					tb.deleteCharAt(i);
					i--;
				}

			}

		}

		return sb.toString().equalsIgnoreCase(tb.toString());
	}

}
