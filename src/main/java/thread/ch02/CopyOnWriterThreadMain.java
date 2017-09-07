package thread.ch02;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.List;

public class CopyOnWriterThreadMain {
	public static void main(String[] args){
		final List<Integer> list = new CopyOnWriteArrayList<Integer>();
		new ArrayListThreadWriter(list).start();
		new ArrayListThreadReader(list).start();
	}

}
