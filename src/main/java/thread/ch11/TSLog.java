package thread.ch11;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TSLog {
	private PrintWriter writer = null;
	
	public TSLog(String fileName) {
		try {
			writer = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void println(String s) {
//		System.out.println(s);
		writer.println(s);
	}
	
	public void close() {
		writer.println("========End of log========");
		writer.close();
	}

}
