package aug;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ElephantCompetition {

	PriorityQueue<EachElephantEntry> pq;
	Map<String, String> ourElephantsEnterTime;
	Map<String, String> ourElephantsExitTime;
	Map<String, Integer> countExisting;

	static class EachElephantEntry {
		String name;
		int enterTime;
		int height;
		boolean yourElephant;

		public EachElephantEntry(String name, int enterTime, int height, boolean yourElephant) {
			this.name = name;
			this.enterTime = enterTime;
			this.height = height;
			this.yourElephant = yourElephant;
		}

	}

	static class Elephant {
		String name;
		int height;

		public Elephant(String name, int height) {
			this.name = name;
			this.height = height;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

	}

	static class Schedule {
		String name;
		int enterTime;
		int exitTime;

		public Schedule(String name, int enterTime, int exitTime) {
			this.name = name;
			this.enterTime = enterTime;
			this.exitTime = exitTime;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getEnterTime() {
			return enterTime;
		}

		public void setEnterTime(int enterTime) {
			this.enterTime = enterTime;
		}

		public int getExitTime() {
			return exitTime;
		}

		public void setExitTime(int exitTime) {
			this.exitTime = exitTime;
		}

	}

	public ElephantCompetition(List<Elephant> elephants, List<Schedule> schedule) {
		pq = new PriorityQueue<>(new Comparator<EachElephantEntry>() {

			@Override
			public int compare(EachElephantEntry o1, EachElephantEntry o2) {
				return o2.height - o1.height;
			}
		});

		ourElephantsEnterTime = new HashMap<>();
		ourElephantsExitTime = new HashMap<>();
		countExisting = new HashMap<>();

		int size = elephants.size();
		for (int i = 0; i < size; i++) {
			Elephant each = elephants.get(i);
			Schedule schd = null;
			for (Schedule eachSchedule : schedule) {
				if (eachSchedule.name.equalsIgnoreCase(each.getName())) {
					schd = eachSchedule;
					break;
				}
			}
			if (schd != null) {
				ourElephantsEnterTime.put(schd.enterTime + "-" + each.getHeight(), each.getName());
				ourElephantsExitTime.put(schd.exitTime + "-" + each.getHeight(), each.getName());

			}
		}

	}

	public void elephantEntered(int currentTime, int height) {
		String name = "Unknown";
		if (ourElephantsEnterTime.containsKey(currentTime + "-" + height)) {
			name = ourElephantsEnterTime.get(currentTime + "-" + height);
			pq.add(new EachElephantEntry(name, currentTime, height, true));
			countExisting.put(height + "-true", countExisting.getOrDefault(height + "-true", 0) + 1);
		} else {
			pq.add(new EachElephantEntry(name, currentTime, height, false));
			countExisting.put(height + "-false", countExisting.getOrDefault(height + "-false", 0) + 1);
		}
	}

	public void elephantLeft(int currentTime, int height) {
		if (ourElephantsExitTime.containsKey(currentTime + "-" + height)) {
			countExisting.put(height + "-true", countExisting.get(height + "-true") - 1);
		} else {
			countExisting.put(height + "-false", countExisting.get(height + "-false") - 1);
		}
	}

	public void getBiggestElephants() {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		List<String> namesList = new ArrayList<>();
		for (EachElephantEntry eachElephantEntry : pq) {
			int countVal = countExisting
					.get(eachElephantEntry.height + (eachElephantEntry.yourElephant == true ? "-true" : "-false"));
			if (countVal <= 0) {
				continue;
			}
			if (!eachElephantEntry.yourElephant) {
				break;
			} else {
				count++;
				namesList.add(eachElephantEntry.name);
			}
		}

		Collections.reverse(namesList);

		sb.append(count + " ");

		for (String name : namesList) {
			sb.append(name).append(" ");
		}

		System.out.println(sb.toString());

	}

	public static void main(String[] args) {

		List<String> listInput = new ArrayList<>();
		listInput.add("definition marry 300");
		listInput.add("definition rob 250");
		listInput.add("schedule marry 10 15");
		listInput.add("schedule rob 13 20");
		listInput.add("start");
		listInput.add("8 enter 200");
		// listInput.add("9 enter 300");
		listInput.add("10 enter 310");
		listInput.add("10 enter 300");
		listInput.add("11 inspect");
		listInput.add("13 enter 250");
		listInput.add("13 exit 310");
		listInput.add("13 inspect");
		listInput.add("15 exit 300");
		listInput.add("16 inspect");
		listInput.add("16 exit 200");
		listInput.add("20 exit 250");
		listInput.add("21 end");

		ElephantCompetition elephantCompition = null;

		List<Elephant> elephants = new ArrayList<>();
		// Not Sure
		List<Schedule> schedules = new ArrayList<>();

		for (String eachLine : listInput) {

			String[] split = eachLine.split(" ");
			if (split[0].equalsIgnoreCase("definition")) {
				Elephant newElephant = new Elephant(split[1], Integer.valueOf(split[2]));
				elephants.add(newElephant);
			} else if (split[0].equalsIgnoreCase("schedule")) {
				Schedule newSchedule = new Schedule(split[1], Integer.valueOf(split[2]), Integer.valueOf(split[3]));
				schedules.add(newSchedule);
			}

			else if (eachLine.contains("start")) {
				elephantCompition = new ElephantCompetition(elephants, schedules);
			}

			else if (eachLine.contains("end")) {
				break;
			}

			else if (eachLine.contains("enter")) {
				elephantCompition.elephantEntered(Integer.valueOf(split[0]), Integer.valueOf(split[2]));
			} else if (eachLine.contains("exit")) {
				elephantCompition.elephantLeft(Integer.valueOf(split[0]), Integer.valueOf(split[2]));
			} else if (eachLine.contains("inspect")) {
				elephantCompition.getBiggestElephants();
			}
		}

		/*
		 * ElephantCompetition elephantCompition = null; Scanner sc = new
		 * Scanner(System.in); List<Elephant> elephants = new ArrayList<>(); // Not Sure
		 * List<Schedule> schedules = new ArrayList<>();
		 * 
		 * while (sc.hasNext()) { String eachLine = sc.nextLine(); String[] split =
		 * eachLine.split(" "); if (split[0].equalsIgnoreCase("definition")) { Elephant
		 * newElephant = new Elephant(split[1], Integer.valueOf(split[2]));
		 * elephants.add(newElephant); } else if (split[0].equalsIgnoreCase("schedule"))
		 * { Schedule newSchedule = new Schedule(split[1], Integer.valueOf(split[2]),
		 * Integer.valueOf(split[3])); schedules.add(newSchedule); }
		 * 
		 * if (eachLine.contains("start")) { elephantCompition = new
		 * ElephantCompetition(elephants, schedules); break; } }
		 * 
		 * while (sc.hasNext()) { String eachLine = sc.nextLine(); if
		 * (eachLine.contains("end")) { break; }
		 * 
		 * String[] split = eachLine.split(" "); if (eachLine.contains("enter")) {
		 * elephantCompition.elephantEntered(Integer.valueOf(split[0]),
		 * Integer.valueOf(split[2])); } else if (eachLine.contains("exit")) {
		 * elephantCompition.elephantLeft(Integer.valueOf(split[0]),
		 * Integer.valueOf(split[2])); } else if (eachLine.contains("inspect")) {
		 * elephantCompition.getBiggestElephants(); } }
		 */
	}

}
