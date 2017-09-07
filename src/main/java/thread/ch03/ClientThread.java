package thread.ch03;

import java.util.Random;

class ClientThread extends Thread {
	private final Random random;
	private final RequestBlockingQueue requestQueue;
//	private final RequestQueue requestQueue;
	
//	public ClientThread(RequestQueue requestQueue, String name, long seed){
	public ClientThread(RequestBlockingQueue requestQueue, String name, long seed){
		super(name);
		this.requestQueue = requestQueue;
		this.random = new Random(seed);
	}
	
	public void run() {
		//Client generate only requests by 10000
		try { //If exception is happened then it have to escape for loop
			for(int i=0 ; i<10000 ; i++){
				Request request = new Request("No." + i);
				System.out.println(Thread.currentThread().getName() + " requests " + request);
				requestQueue.putRequest(request);
				Thread.sleep(random.nextInt(1000));
			}
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}
}