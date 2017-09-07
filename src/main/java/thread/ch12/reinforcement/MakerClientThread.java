package thread.ch12.reinforcement;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;

public class MakerClientThread extends Thread {
	private final ActiveObject activeObject;
	private final char fillChar;
	
	public MakerClientThread(String name, ActiveObject activeObject) {
		super(name);
		this.activeObject = activeObject;
		this.fillChar = name.charAt(0);
	}
	
	public void run() {
		try {
			for(int i=0 ; true; i++) {
				Future<String> future = activeObject.makeString(i,  fillChar);
				Thread.sleep(10);
				String value = future.get();
				System.out.println(Thread.currentThread().getName() + ": value = " + value);
			}
		} catch (RejectedExecutionException e) {
			// TODO: handle exception
			System.out.println(Thread.currentThread().getName() + ":" + e);
		} catch (CancellationException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		} catch (ExecutionException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		} catch (InterruptedException e) {
			System.out.println(Thread.currentThread().getName() + ":" + e);
		}
	}

}
