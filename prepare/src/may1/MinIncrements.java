package may1;

public class MinIncrements {

	static int res;

	public static void main(String[] args) {
		int n = 15;
		int[] cost = { 764, 1460, 2664, 764, 2725, 4556, 5305, 8829, 5064, 5929, 7660, 6321, 4830, 7055, 3761 };

		res = 0;

		System.out.println(solve(cost, new int[cost.length], 1));

	}

	static int solve(int[] cost, int[] sum, int index) {
		if (index > cost.length)
			return 0;
		int l = solve(cost, sum, 2 * index);
		int r = solve(cost, sum, 2 * index + 1);
		res += Math.abs(l - r);

		sum[index - 1] = Math.max(l, r) + cost[index - 1];

		return sum[index - 1];
	}

	/*
	 * public static class Node { int parentVal; int parentSum;
	 * 
	 * public Node(int parentVal, int parentSum) { this.parentVal = parentVal;
	 * this.parentSum = parentSum; }
	 * 
	 * }
	 * 
	 * private static int solve(int n, int[] cost) { Queue<int[]> queue = new
	 * LinkedList<>(); queue.add(new int[] { 1, cost[0] });
	 * 
	 * int res = 0;
	 * 
	 * while (!queue.isEmpty()) {
	 * 
	 * int size = queue.size(); int max = Integer.MIN_VALUE;
	 * 
	 * List<Node> levelDiff = new ArrayList<>(); for (int i = 0; i < size; i++) {
	 * int[] val = queue.poll(); int lastSum = val[1];
	 * 
	 * max = Math.max(max, lastSum); levelDiff.add(new Node(val[0], lastSum)); }
	 * 
	 * System.out.println("---------------------------------------");
	 * 
	 * for (Node each : levelDiff) { int diff = (max - each.parentSum);
	 * 
	 * System.out.println("diff " + diff);
	 * 
	 * res += diff;
	 * 
	 * if ((2 * each.parentVal) - 1 < cost.length) { queue.add( new int[] { (2 *
	 * each.parentVal), cost[(2 * each.parentVal) - 1] + each.parentSum + diff }); }
	 * if ((2 * each.parentVal + 1) - 1 < cost.length) { queue.add(new int[] { (2 *
	 * each.parentVal + 1), cost[(2 * each.parentVal + 1) - 1] + each.parentSum +
	 * diff }); }
	 * 
	 * }
	 * 
	 * System.out.println("Res " + res);
	 * 
	 * System.out.println("---------------------------------------");
	 * 
	 * }
	 * 
	 * return res; }
	 */

}
