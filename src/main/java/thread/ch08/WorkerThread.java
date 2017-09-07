package thread.ch08;

public class WorkerThread extends Thread {
	private final Channel channel;
	
	public WorkerThread(String name, Channel channel) {
		super(name);
		this.channel = channel;
	}
	
	public void run() {
		while(!Shutdown.isSystemStop){
			Request request = channel.takeRequest();
			request.execute();
		}
	}
	
//	public void stopThread() {
//		this.interrupt();
//	}
}
