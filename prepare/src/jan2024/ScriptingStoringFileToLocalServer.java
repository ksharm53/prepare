package jan2024;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class ScriptingStoringFileToLocalServer {

	public static void main(String[] args) throws IOException {
		FTPClient client = new FTPClient();
		try {
			client.connect("");
			client.login("", "");
			client.enterLocalPassiveMode();
			client.setFileType(FTP.BINARY_FILE_TYPE);

			FileInputStream fi = new FileInputStream("");
			boolean done = client.storeFile("", fi);
			fi.close();
			if (done) {
				System.out.println("Ho Gaya");
			}

		} catch (Exception ex) {

		} finally {
			if (client.isConnected()) {
				client.logout();
				client.disconnect();
			}
		}

	}

}
