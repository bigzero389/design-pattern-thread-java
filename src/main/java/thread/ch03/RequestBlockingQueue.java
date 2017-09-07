package thread.ch03;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class RequestBlockingQueue {
	private final BlockingQueue<Request> queue = new LinkedBlockingQueue<Request>();
		
	public Request getRequest(){
		Request req = null;
		try {
			req = queue.take();
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		return req;
	}
	
	public void putRequest(Request req){
		try {
			queue.put(req);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
	}

}

