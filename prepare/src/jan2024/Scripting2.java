package jan2024;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Scripting2 {

	public static void main(String[] args) {
		String path = "C:\\Users\\ksharm53\\Downloads\\dir";
		File directory = new File(path);
		File[] files = directory.listFiles();

		for (File file : files) {
			replace(file, "file", "kanav");
		}

	}

	private static void replace(File file, String from, String to) {
		try {
			String line = "";
			// StringBuilder sb = new StringBuilder();
			String oldtext = "";
			BufferedReader br = new BufferedReader(new FileReader(file));
			while ((line = br.readLine()) != null) {
				oldtext += line + "\r\n";
			}

			br.close();

			String newtext = oldtext.replaceAll(from, to);

			FileWriter fw = new FileWriter(file);
			fw.write(newtext);
			fw.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

}
