package thread.ch12;

public class ActivationQueue {
	private static final int MAX_METHOD_REQUEST = 100;

	@SuppressWarnings("rawtypes")
	private final MethodRequest[] requestQueue;
	private int tail;
	private int head;
	private int count;
	
	public ActivationQueue () {
		this.requestQueue = new MethodRequest[MAX_METHOD_REQUEST];
		this.tail = 0;
		this.head = 0;
		this.count = 0;
	}

	@SuppressWarnings("rawtypes")
	public synchronized void putRequest(MethodRequest request) {
		while(count >= requestQueue.length) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		requestQueue[tail] = request;
		tail = (tail+1) % requestQueue.length ;
		count++;
		notifyAll();
	}
	
	@SuppressWarnings("rawtypes")
	public synchronized MethodRequest takeRequest() {
		while(count <= 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
		MethodRequest request = requestQueue[head];
		head = (head+1) % requestQueue.length;
		count--;
		notifyAll();
		return request;
	}
}
