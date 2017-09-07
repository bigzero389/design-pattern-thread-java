package thread.ch01;

import java.util.concurrent.Semaphore;
import java.util.Random;

class Log {
	public static void println(String s){
		System.out.println(Thread.currentThread().getName() + ": " + s);
	}
}

class BoundedResource {
	private final Semaphore semaphore;
	private final int permits;
	private final static Random random = new Random(314159);
	
	public BoundedResource(int permits){
		this.semaphore = new Semaphore(permits);
		this.permits = permits;
	}

	public void use() throws InterruptedException {
		semaphore.acquire();
		try {
		    doUse();
		} catch (Exception e) {
		    // TODO: handle exception
            Log.println("doUse Error");
		} finally {
		    semaphore.release();
		}
	}

	protected void doUse() throws InterruptedException {
	    Log.println("BEGIN: used = " + (permits-semaphore.availablePermits()));
	    Thread.sleep(random.nextInt(1000));
	    Log.println("END:   used = " + (permits-semaphore.availablePermits()));
	}
}

class SemaphoreUserThread extends Thread {
	private final static Random random = new Random(26535);
	private final BoundedResource resource;
	
	public SemaphoreUserThread(BoundedResource resource) {
		this.resource = resource;
	}
	
	public void run() {
		try {
		    while(true){
		    	resource.use();
		    	Thread.sleep(random.nextInt(8000));
		    }
		} catch (Exception e) {
			// TODO: handle exception
			Log.println("UserThread.run Error");
		}
	}
}

public class SemaphoreMain {
	public static void main(String[] args) {
		BoundedResource resource = new BoundedResource(3);
		
		for (int i=0 ; i<10 ; i++){
			new SemaphoreUserThread(resource).start();
		}
	}
}