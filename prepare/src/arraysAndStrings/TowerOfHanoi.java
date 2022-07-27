package arraysAndStrings;

public class TowerOfHanoi {
	
	static int counter=0;

	public static void main(String[] args) {
		int N=3;
		int from=1;
		int to=3;
		int aux=2;
		counter=0;
		
		solve(N,from,to,aux);
		
		System.out.println(counter);

	}

	private static void solve(int n, int from, int to, int aux) {
		
		if(n==1) {
			System.out.println("move disk "+ n +" from rod "+ from+" to rod "+ to);
			counter++;
			return;
		}
		
		solve(n-1, from, aux, to);
		
		System.out.println("move disk "+ n +" from rod "+ from+" to rod "+ to);
		counter++;
	
		solve(n-1, aux, to, from);
		
	}

}
