package thread.ch12;

public class SchedulerThread extends Thread {
	private final ActivationQueue queue;
	
	public SchedulerThread(ActivationQueue queue) {
		this.queue = queue;
	}
	
	@SuppressWarnings("rawtypes")
	public void invoke(MethodRequest request) {
		queue.putRequest(request);
	}
	
	public void run() {
		while(true) {
			queue.takeRequest().execute();
		}
	}

}
