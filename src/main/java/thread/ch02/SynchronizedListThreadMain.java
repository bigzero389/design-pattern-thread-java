package thread.ch02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SynchronizedListThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
		new ArrayListThreadWriter(list).start();
		new SynchronizedListThreadReader(list).start();
	}

}
