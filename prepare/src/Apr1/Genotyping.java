package Apr1;

import java.util.*;

class UnionFind {
	private int[] parent;
	private int[] rank;

	public UnionFind(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}

	public void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX == rootY) {
			return;
		}
		if (rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		} else if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		} else {
			parent[rootY] = rootX;
			rank[rootX]++;
		}
	}
}

public class Genotyping {
	public static void main(String[] args) {
		String[][] inputs = { { "NORM", "100", "110" }, { "MUT", "110", "12" } };

		int n = inputs.length * 2;
		UnionFind uf = new UnionFind(n);

		Map<String, Integer> indexMap = new HashMap<>();
		int index = 0;
		for (String[] input : inputs) {
			String type = input[0];
			String a = input[1];
			String b = input[2];

			int indexA = indexMap.getOrDefault(a, index++);
			int indexB = indexMap.getOrDefault(b, index++);

			if (type.equals("NORM")) {
				uf.union(indexA, indexB);
			} else {
				int rootA = uf.find(indexA);
				int rootB = uf.find(indexB);
				if (rootA == rootB) {
					System.out.println("Inconsistent: " + a + ", " + b);
				} else if (indexMap.containsValue(rootA) && indexMap.containsValue(rootB)) {
					System.out.println("Nonunique: " + a + ", " + b);
				} else {
					uf.union(indexA, rootB);
					uf.union(indexB, rootA);
				}
			}
		}

		Set<Integer> normSet = new HashSet<>();
		Set<Integer> mutSet = new HashSet<>();
		for (int i = 0; i < n; i++) {
			int root = uf.find(i);
			if (indexMap.containsValue(root)) {
				mutSet.add(root);
			} else {
				normSet.add(root);
			}
		}

		System.out.println("Normals: " + normSet);
		System.out.println("Mutants: " + mutSet);
	}
}
