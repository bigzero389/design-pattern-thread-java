package thread.ch02;

import java.util.List;

public class SynchronizedListThreadReader extends Thread {
	private final List<Integer> list;
	
	public SynchronizedListThreadReader(List<Integer> list){
		super("SynchronizedListThreadReader");
		this.list = list;
	}
	
	public void run() {
		while(true){
			synchronized(list){ //You have to use a synchronized because for loop uses iterator internally 
//				for(int i=0,j=list.size() ; i<j ; i++) {
				for(int n : list) {
					System.out.println(n);
//					System.out.println(list.get(i));
				}
			}
		}
	}

}
