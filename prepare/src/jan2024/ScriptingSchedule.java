package jan2024;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScriptingSchedule {

	public static void main(String[] args) {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

		Runnable task = new Runnable() {
			@Override
			public void run() {
				System.out.println("Executing task at " + System.nanoTime());
			}
		};

		executor.scheduleAtFixedRate(task, 10, 30, TimeUnit.SECONDS);

	}

}
