package thread.ch02;

import java.util.ArrayList;
import java.util.List;

public class ArrayListThreadMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		new ArrayListThreadWriter(list).start();
		new ArrayListThreadReader(list).start();
	}

}
