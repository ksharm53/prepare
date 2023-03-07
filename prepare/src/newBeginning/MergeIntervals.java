package newBeginning;

import java.util.ArrayList;

public class MergeIntervals {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		// intervals.add(new Interval(1, 2));
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(8, 10));
		// intervals.add(new Interval(8, 10));
		// intervals.add(new Interval(12, 16));

		Interval newInterval = new Interval(1, 12);

		System.out.println(insert(intervals, newInterval));

	}

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

		if (intervals == null) {
			intervals = new ArrayList<Interval>();
			intervals.add(newInterval);
			return intervals;
		}
		if (intervals.size() == 0) {
			intervals.add(newInterval);
			return intervals;
		}

		Interval to_Merg = newInterval;
		int i = 0;
		while (i < intervals.size()) {
			Interval current = intervals.get(i);
			if (current.end < to_Merg.start) {
				i++;
				continue;
			} else if (current.start > to_Merg.end) {
				intervals.add(i, to_Merg);
				break;
			} else {
				to_Merg.start = Math.min(to_Merg.start, current.start);
				to_Merg.end = Math.max(to_Merg.end, current.end);
				intervals.remove(i);
			}
		}
		if (i == intervals.size())
			intervals.add(to_Merg);
		return intervals;
	}
}
