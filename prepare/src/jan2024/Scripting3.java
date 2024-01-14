package jan2024;

import java.io.File;

public class Scripting3 {

	public static void main(String[] args) {
		// Find disk space

		File file = new File("C:\\");
		long total = file.getTotalSpace();
		long usable = file.getUsableSpace();
		long freeSpace = file.getFreeSpace();

		System.out.println("total: " + total + " usable: " + usable + " freeSpace: " + freeSpace);
	}

}
