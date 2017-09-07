package thread.ch08;

public class Channel {
	private static final int MAX_REQUEST = 100;
	private final Request[] requestQueue;
	private int tail;
	private int head;
	private int count;

	private final WorkerThread[] threadPool;
	
	public Channel(int threads) {
		this.requestQueue = new Request[MAX_REQUEST];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		
		threadPool = new WorkerThread[threads];
		for (int i=0,j=threadPool.length ; i<j ; i++){
			threadPool[i] = new WorkerThread("Worker-", this);
		}
	}
	
	public void startWorkers() {
		for (int i=0,j=threadPool.length ; i<j ; i++){
			threadPool[i].start();
		}
	}
	
	public synchronized void putRequest(/*final*/ Request request) {
		// Worker-Thread Pattern 
		while(count >= requestQueue.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		
		requestQueue[tail] = request;
		tail = (tail + 1) % requestQueue.length;
		count++;
//		notifyAll();
		notify();
		
		
		// Thread-per-Message Pattern
//		new Thread() {
//			public void run() {
//				request.execute();
//			}
//		}.start();
	}
	
	public synchronized Request takeRequest() {
		while(count <=0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		Request request = requestQueue[head];
		head = (head + 1) % requestQueue.length;
		count--;
//		notifyAll();
		notify();
		return request;
	}
}
