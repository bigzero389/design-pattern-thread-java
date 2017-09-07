package thread.ch09.problem;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		try {
			Content content1 = Retriever.retrieve("http://www.yahoo.com/");
			Content content2 = Retriever.retrieve("http://www.google.com/");
			Content content3 = Retriever.retrieve("http://www.hyuki.com/");
		
			saveToFile("yahoo.html", content1);
			saveToFile("google.html", content2);
			saveToFile("hyuki.html", content3);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
			
		long end = System.currentTimeMillis();
		System.out.println("Elapsed time = " + (end - start) + "msec.");
		
	}
	
	public static void saveToFile(String fileName, Content content) {
		byte[] bytes = content.getBytes();
		try {
			System.out.println(Thread.currentThread().getName() + ": Saving to " + fileName);
			FileOutputStream out = new FileOutputStream(fileName);
			for(int i=0,j=bytes.length ; i<j ; i++){
				out.write(bytes[i]);
			}
			out.close();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
