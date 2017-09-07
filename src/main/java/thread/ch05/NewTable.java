package thread.ch05;

import java.util.concurrent.ArrayBlockingQueue;

@SuppressWarnings("serial")
public class NewTable extends ArrayBlockingQueue<String>{
	public NewTable(int size){
		super(size);
	}
	
	public void put(String cake) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " puts " + cake);
		super.put(cake);
	}
	
	public String take() throws InterruptedException {
		String cake = super.take();
		System.out.println(Thread.currentThread().getName() + " takes " + cake);
		return cake;
	}

}
