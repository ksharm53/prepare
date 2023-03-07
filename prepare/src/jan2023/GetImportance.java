package jan2023;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetImportance {

	public static class Employee {
		public int id;
		public int importance;
		public List<Integer> subordinates;

		public Employee(int id, int importance, List<Integer> subordinates) {
			super();
			this.id = id;
			this.importance = importance;
			this.subordinates = subordinates;
		}

	};

	public static void main(String[] args) {
		Employee emp1 = new Employee(1, 2, List.of(5));
		Employee emp2 = new Employee(5, -3, new ArrayList<>());
		List<Employee> employees = new ArrayList<>();
		employees.add(emp1);
		employees.add(emp2);

		int id = 5;
		System.out.println(solve(employees, id));

	}

	private static int solve(List<Employee> employees, int id) {
		int total = 0;

		employees.sort(new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.id - o2.id;
			}
		});

		Employee found = binarySort(employees, id);

		Queue<Employee> queue = new LinkedList<>();
		queue.add(found);

		while (!queue.isEmpty()) {
			Employee each = queue.poll();
			for (int eachEmployee : each.subordinates) {
				queue.add(binarySort(employees, eachEmployee));
			}
			total += each.importance;
		}
		return total;
	}

	private static Employee binarySort(List<Employee> employees, int id) {
		int start = 0;
		int last = employees.size() - 1;
		Employee employee = null;

		while (start <= last) {
			int mid = start + ((last - start) / 2);
			if (employees.get(mid).id == id) {
				employee = employees.get(mid);
				break;
			} else if (employees.get(mid).id < id) {
				start = mid + 1;
			} else {
				last = mid - 1;
			}
		}
		return employee;
	}

}
