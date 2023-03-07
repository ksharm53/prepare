package oct3;

import java.util.Collections;
import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {
	HashMap<String, TreeMap<Integer, String>> map;

	public TimeMap() {
		this.map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		this.map.putIfAbsent(key, new TreeMap<>(Collections.reverseOrder()));
		TreeMap<Integer, String> maptemp = this.map.get(key);
		maptemp.put(timestamp, value);
		this.map.put(key, maptemp);
	}

	public String get(String key, int timestamp) {
		if (this.map.get(key) == null) {
			return "";
		} else {
			if (this.map.get(key).ceilingEntry(timestamp) != null) {
				return this.map.get(key).ceilingEntry(timestamp).getValue();
			} else {
				return "";
			}

		}

	}
}
