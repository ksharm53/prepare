package jan2024;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScriptingSystemHealthCheck {

	public static void main(String[] args) {
		ScheduledExecutorService exe = Executors.newSingleThreadScheduledExecutor();

		Runnable task = new Runnable() {
			@Override
			public void run() {
				doSystemHealthCheck();
			}
		};

		exe.scheduleAtFixedRate(task, 10, 10, TimeUnit.SECONDS);

	}

	public static void doSystemHealthCheck() {
		Runtime runTime = Runtime.getRuntime();
		long memory = runTime.totalMemory() - runTime.freeMemory();
		System.out.println(memory);
	}

}
