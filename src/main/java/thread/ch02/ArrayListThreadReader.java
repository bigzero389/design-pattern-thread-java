package thread.ch02;

import java.util.List;

public class ArrayListThreadReader extends Thread {
	private final List<Integer> list;
	
	public ArrayListThreadReader(List<Integer> list){
		super("ArrayListReaderThread");
		this.list = list;
	}
	
	public void run(){
		while(true){
			for(int n : list){
				System.out.println(n);
			}
		}
	}

}
