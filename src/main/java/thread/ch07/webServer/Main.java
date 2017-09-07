package thread.ch07.webServer;

import java.io.IOException;

public class Main {
	public static void main(String args[]) {
		try {
			new MiniServer(8888).execute();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
