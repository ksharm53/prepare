package oct3;

public class ValidateMap {

	public static void main(String[] args) {
		TimeMap map = new TimeMap();
		map.set("love", "high", 10);
		map.set("love", "low", 20);
		System.out.println(map.get("love", 5));
		System.out.println(map.get("love", 10));
		System.out.println(map.get("love", 15));
		System.out.println(map.get("love", 20));
		System.out.println(map.get("love", 25));

	}

}
