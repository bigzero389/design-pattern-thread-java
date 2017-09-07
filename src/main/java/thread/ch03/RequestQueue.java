package thread.ch03;

import java.util.LinkedList;
import java.util.Queue;

class RequestQueue {
	private final Queue<Request> queue = new LinkedList<Request>();

	public synchronized Request getRequest() throws Exception { //this instance try to get this's lock
		while(queue.peek() == null){
			wait();   //This instance already have this's lock, so it can run it's wait method
			System.out.println("Thread waiting......");
		}
		return queue.remove();
	}
	
	public synchronized void putRequest(Request request){ //this instance try to get this's lock or already have it
		queue.offer(request);
		notifyAll(); // This instance already have this's lock , so it can release it's lock
	}
}