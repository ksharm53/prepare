package jan2024;

import java.io.File;
import java.io.FileInputStream;
import java.nio.channels.FileChannel;

public class ScriptingCopyFiles {

	public static void main(String[] args) {
		File source = new File("C:\\Users\\ksharm53\\Downloads\\dir");
		File dest = new File("C:\\Users\\ksharm53\\Downloads\\copy");

		copy(source, dest);

	}

	private static void copy(File source, File dest) {
		if (!source.isDirectory()) {
			try (FileChannel srcChannel = new FileInputStream(source).getChannel();
					FileChannel destChannel = new FileInputStream(dest).getChannel()) {
				destChannel.transferFrom(srcChannel, 0, srcChannel.size());

			} catch (Exception ex) {

			}
		} else {
			if (!dest.exists()) {
				dest.mkdir();
			}

			String[] list = source.list();
			for (String each : list) {
				File innerDir = new File(source, each);
				File innerDirdest = new File(dest, each);
				copy(innerDir, innerDirdest);
			}
		}

	}

}
