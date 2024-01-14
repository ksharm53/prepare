package dec;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatings {

	Map<String, PriorityQueue<Node>> map;
	Map<String, String> foodCuisineMap;
	Map<String, Node> foodNodeMap;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public class Node {
		String food;
		int rating;

		public Node(String food, int rating) {
			this.food = food;
			this.rating = rating;
		}

	}

	public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {

		map = new HashMap<>();
		foodCuisineMap = new HashMap<>();
		foodNodeMap = new HashMap<>();
		int size = foods.length;
		for (int i = 0; i < size; i++) {
			String food = foods[i];
			String cuisine = cuisines[i];
			int rating = ratings[i];

			foodCuisineMap.put(food, cuisine);
			Node node = new Node(food, rating);
			PriorityQueue<Node> temp = map.getOrDefault(cuisine, new PriorityQueue<>(new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					return o1.rating == o2.rating ? o1.food.compareTo(o2.food) : o2.rating - o1.rating;
				}
			}));
			temp.add(node);
			map.put(cuisine, temp);
			foodNodeMap.put(food, node);
		}
	}

	public void changeRating(String food, int newRating) {
		String cuisine = foodCuisineMap.get(food);
		PriorityQueue<Node> temp = map.get(cuisine);
		Node node = foodNodeMap.get(food);
		temp.remove(node);

		Node newNode = new Node(food, newRating);
		temp.add(newNode);
		map.put(cuisine, temp);
		foodNodeMap.put(food, newNode);
	}

	public String highestRated(String cuisine) {
		PriorityQueue<Node> temp = map.get(cuisine);
		if (temp == null) {
			return "kuch nahi mila bhai";
		}
		return temp.peek().food;
	}

}
