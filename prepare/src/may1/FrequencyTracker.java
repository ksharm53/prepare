package may1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrequencyTracker {

	public static void main(String[] args) {
		FrequencyTracker obj = new FrequencyTracker();
		obj.hasFrequency(1);
		obj.add(3);
		obj.add(1);
		obj.hasFrequency(1);
		obj.add(3);
		obj.hasFrequency(2);
		obj.add(1);
		obj.hasFrequency(2);
		obj.deleteOne(10);
		obj.hasFrequency(2);
		obj.deleteOne(6);
		obj.add(7);
		obj.deleteOne(10);
		obj.hasFrequency(2);
		obj.hasFrequency(1);
		obj.add(1);
		obj.add(2);
		obj.add(3);
		obj.hasFrequency(1);
		obj.deleteOne(3);
		obj.hasFrequency(2);
		obj.hasFrequency(3);

		/*
		 * 3-2 2-1 1-3 7-1
		 */

	}

	Map<Integer, Integer> numFreq;
	Map<Integer, Set<Integer>> freqList;

	public FrequencyTracker() {
		numFreq = new HashMap<>();
		freqList = new HashMap<>();
		System.out.println("null");
	}

	public void add(int number) {
		numFreq.put(number, numFreq.getOrDefault(number, 0) + 1);
		int lastFreq = numFreq.get(number);

		if (lastFreq - 1 > 0) {
			Set<Integer> list = freqList.getOrDefault(lastFreq - 1, new HashSet<>());
			list.remove(number);
			if (list.size() <= 0) {
				freqList.remove(lastFreq - 1);
			}

		}

		Set<Integer> list = freqList.getOrDefault(lastFreq, new HashSet<>());
		list.add(number);
		freqList.put(lastFreq, list);

		System.out.println("null");

	}

	public void deleteOne(int number) {
		if (numFreq.containsKey(number)) {
			int lastFreq = numFreq.get(number);
			numFreq.put(number, numFreq.get(number) - 1);
			if (lastFreq == 1) {
				numFreq.remove(number);
			}

			Set<Integer> set = freqList.get(lastFreq);
			set.remove(number);
			if (set.size() <= 0) {
				freqList.remove(lastFreq);
			} else {
				freqList.put(lastFreq, set);
			}

			if (lastFreq - 1 > 0) {
				Set<Integer> temp = freqList.getOrDefault(lastFreq - 1, new HashSet<>());
				temp.add(number);
				freqList.put(lastFreq - 1, temp);
			}

		}
	}

	public boolean hasFrequency(int frequency) {
		boolean res = freqList.containsKey(frequency);
		System.out.println(res);
		return res;
	}

}
