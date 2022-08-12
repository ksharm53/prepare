package misc;

import java.util.TreeMap;

public class MyCalendarI {

	 TreeMap<Integer, Integer> calendar;

	public MyCalendarI() {
		calendar = new TreeMap<>();
	}

	public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

	public static void main(String[] args) {
		MyCalendarI obj = new MyCalendarI();
		System.out.println(obj.book(20, 29));
		System.out.println(obj.book(13, 22));
		System.out.println(obj.book(44, 50));
		System.out.println(obj.book(1, 7));
		System.out.println(obj.book(2, 10));
		System.out.println(obj.book(14, 20));

	}

}
