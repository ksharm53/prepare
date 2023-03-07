package Sept23;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static Stack<Integer> stack;

	public static class Node {
		int data;
		boolean visited;
		List<Node> neighbours;

		public Node(int vertexCount) {
			this.data = vertexCount;
			this.neighbours = new ArrayList<>();
		}

		public void addneighbours(Node neighbourNode) {
			this.neighbours.add(neighbourNode);
		}

		public boolean isVisited() {
			return visited;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

		public List<Node> getNeighbours() {
			return neighbours;
		}

		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}

	}

	public void topologicalSort(Node node) {
		List<Node> nei = node.getNeighbours();
		if (nei.size() > 0) {
			for (Node eachNeighbour : nei) {
				if (eachNeighbour != null && eachNeighbour.isVisited() == false) {
					topologicalSort(eachNeighbour);
					eachNeighbour.setVisited(true);
				}
			}
		}
		stack.push(node.data);
	}

	public static void main(String[] args) {
		int numCourses = 2;
		int[][] prerequisites = { { 1, 0 }, { 0, 1 } };
		stack = new Stack<Integer>();
		//System.out.println(solve(numCourses, prerequisites));
	}
}
