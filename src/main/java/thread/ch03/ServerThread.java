package thread.ch03;

import java.util.Random;

class ServerThread extends Thread {
	private final Random random;
	private final RequestBlockingQueue requestQueue;
//	private final RequestQueue requestQueue;
	
	public ServerThread(RequestBlockingQueue requestQueue, String name, long seed) {
		super(name);
		this.random = new Random(seed);
		this.requestQueue = requestQueue;
	}
	
	public void run() {
		for(int i=0 ; i<10000 ; i++){
			Request request = requestQueue.getRequest();
			System.out.println(Thread.currentThread().getName() + " handles " + request);
			try {
				Thread.sleep(random.nextInt(1000));
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
}